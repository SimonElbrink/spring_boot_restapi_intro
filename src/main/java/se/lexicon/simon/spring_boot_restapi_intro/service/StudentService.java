package se.lexicon.simon.spring_boot_restapi_intro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.simon.spring_boot_restapi_intro.model.Student;
import se.lexicon.simon.spring_boot_restapi_intro.repo.StudentRepository;

import java.util.*;

/**
 * StudentService
 * The Service is a pattern we can use for many things.
 * You should consider a service layer when you want to handle parts of you program (ex. business logic, Converting)
 * It us up to you if you need one or not.
 */
@Service
public class StudentService {


    StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    //CRUD

    public Student create(Student student){

        Student saved = studentRepo.save(student);

        return saved;
    }

    public Student findById(String id){

        Optional<Student> foundStudent = studentRepo.findById(id);


        return foundStudent.orElseThrow(IllegalArgumentException::new);
    }

    public Collection<Student> findAll(){
        return studentRepo.findAll();
    }


    public Collection<Student> findByFirstName(String firstName){

        List<Student> found = studentRepo.findAllByFirstNameContainingIgnoreCase(firstName);

        return found;
    }

    @Transactional
    public Student update(Student student){

        Student original = studentRepo.findById(student.getStudentId()).get();

        original.setFirstName(student.getFirstName());
        original.setLastName(student.getLastName());
        original.setBirthDate(student.getBirthDate());
        original.setPsn(student.getPsn());
        original.setAddress(student.getAddress());

        return original;
    }

    public void delete(String studentId){
       studentRepo.deleteById(studentId);
    }



}
