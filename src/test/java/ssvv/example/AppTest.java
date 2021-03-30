package ssvv.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;
import ssvv.example.domain.Student;
import ssvv.example.domain.Tema;
import ssvv.example.repository.StudentRepository;
import ssvv.example.repository.TemaRepository;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;
import ssvv.example.validation.ValidationException;
import ssvv.example.validation.Validator;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    StudentRepository studentRepository;
    TemaRepository temaRepository;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Before
    public void setup(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        this.studentRepository = new StudentRepository(studentValidator);
        this.temaRepository = new TemaRepository(temaValidator);

    }

    @Test
    public void tc_1_addStudentWithValidGroup() {
        Student s = this.studentRepository.save(new Student("17", "cristi", 600));
        assertNull(s);
    }

    @Test
    public void addStudentWithInvalidGroup() {
        Student s = studentRepository.save(new Student("17", "cristi", 938));
        assertNull(s);
    }

    @Test
    public void AddStudentInvalidName() {
        Student s = studentRepository.save(new Student("17", "", 600));
        assertNull(s);
    }

    @Test
    public void addStudentValidName(){
        Student s = studentRepository.save(new Student("17", "dawd", 600));
        assertNull(s);
    }

    @Test
    public void addStudentValidId(){
        Student s = studentRepository.save(new Student("17", "dawd", 600));
        assertNull(s);
    }

    @Test
    public void addStudentInvalidId(){
        Student s = studentRepository.save(new Student("", "dawd", 600));
        assertNull(s);
    }

    @Test
    public void addStudentWithInvalidGroup2() {
        Student s = studentRepository.save(new Student("17", "cristi", 110));
        assertNull(s);
    }

    @Test
    public void addStudentWithInvalidGroup3(){
        Student s = studentRepository.save(new Student("17","cristi",1000));
        assertNull(s);
    }

    @Test
    public void addStudentWithInvalidGroup4(){
        Student s = studentRepository.save(new Student("17","cristi",17));
        assertNull(s);
    }

    @Test
    public void addAssignmentValid(){
        Tema t = temaRepository.save(new Tema("1","descriere",8,7));
        assertNull(t);
    }

    @Test
    public void addAssignmentInvalid(){
        Tema t = temaRepository.save(new Tema("","descriere",8,7));
        assertNull(t);
    }




}
