package ssvv.example;

import org.junit.Before;
import org.junit.Test;
import ssvv.example.domain.Nota;
import ssvv.example.domain.Pair;
import ssvv.example.domain.Student;
import ssvv.example.domain.Tema;
import ssvv.example.repository.NotaRepository;
import ssvv.example.repository.StudentRepository;
import ssvv.example.repository.TemaRepository;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;
import ssvv.example.validation.Validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AppTest2 {
    StudentRepository studentRepository;
    TemaRepository temaRepository;
    NotaRepository notaRepository;

    @Before
    public void setup(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        this.studentRepository = new StudentRepository(studentValidator);
        this.temaRepository = new TemaRepository(temaValidator);
        this.notaRepository = new NotaRepository(notaValidator);
    }

    @Test
    public void addStudentValidName(){
        Student s = studentRepository.save(new Student("17", "dawd", 600));
        assertNull(s);
    }
    @Test
    public void addAssignmentValid(){
        Tema t = temaRepository.save(new Tema("1","descriere",8,7));
        assertNull(t);
    }
    @Test
    public void addGradeValid(){
        Nota n = notaRepository.save(new Nota(new Pair("1","1"),5,5,"feedback"));
        assertNull(n);
    }

    @Test
    public void bingBang(){
        this.addAssignmentValid();
        this.addGradeValid();
        this.addStudentValidName();
        assertTrue(true);
    }
}
