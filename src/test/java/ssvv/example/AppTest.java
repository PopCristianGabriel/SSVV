package ssvv.example;

import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.StudentRepository;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.Validator;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addStudentWithValidGroup(){
        // given
        Validator<Student> studentValidator = new StudentValidator();
        StudentRepository studentRepository = new StudentRepository(studentValidator);
        // when
        Student s = studentRepository.save(new Student("17", "cristi", 600));
        // then
        assertNotNull(s);
        studentRepository.delete("77");
    }
    @Test
    public void addStudentWithInvalidGroup(){
        // given
        Validator<Student> studentValidator = new StudentValidator();
        StudentRepository studentRepository = new StudentRepository(studentValidator);
        // when
        Student s = studentRepository.save(new Student("17", "cristi", -1));
        // then
        assertNull(s);
        studentRepository.delete("77");
    }

}
