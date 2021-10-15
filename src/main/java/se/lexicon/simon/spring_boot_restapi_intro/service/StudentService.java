package se.lexicon.simon.spring_boot_restapi_intro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentDto;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentDtoAll;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentFormDto;
import se.lexicon.simon.spring_boot_restapi_intro.exception.ResourceNotFoundException;
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


    private final StudentRepository studentRepo;
    private final ConversionService convert;

    @Autowired
    public StudentService(StudentRepository studentRepo, ConversionService convert) {
        this.studentRepo = studentRepo;
        this.convert = convert;
    }

    //CRUD

    public StudentDtoAll create(StudentFormDto form){

       Student student = convert.toStudent(form);

        Student saved = studentRepo.save(student);

        return convert.toStudentDtoAll(saved);
    }

    public StudentDtoAll findById(String id){

        Optional<Student> foundStudent = studentRepo.findById(id);


        if (foundStudent.isPresent()){
            return convert.toStudentDtoAll(foundStudent.get());
        } else{
            throw new ResourceNotFoundException("Could not find Student With id: " + id);
        }

    }

    public Collection<StudentDto> findAll(){
        return convert.toStudentDtoList(studentRepo.findAll());
    }


    public Collection<StudentDto> findAllByName(String firstName){
        return convert.toStudentDtoList(studentRepo.findAllByNameContainingIgnoreCase(firstName));
    }

    @Transactional
    public StudentDtoAll update(String id, StudentFormDto student){

        Optional<Student> original = studentRepo.findById(id);

        //Throws null pointer if not found,
        // updating the values in the Database (Transactional needed)
        original.ifPresent((s)->{
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setBirthDate(student.getBirthDate());
            s.setPsn(student.getPsn());
            s.setAddress(student.getAddress());
        });

        return convert.toStudentDtoAll(original.get());

    }

    public void delete(String studentId){
       studentRepo.deleteById(studentId);
    }



}
