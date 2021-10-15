package se.lexicon.simon.spring_boot_restapi_intro.service;

import org.springframework.stereotype.Component;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentDto;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentDtoAll;
import se.lexicon.simon.spring_boot_restapi_intro.dto.StudentFormDto;
import se.lexicon.simon.spring_boot_restapi_intro.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ConversionService {


    public Student toStudent(StudentFormDto form){
        return new Student(form.getFirstName(),form.getLastName(), form.getBirthDate(), form.getPsn(), form.getAddress());
    }

    public StudentDto toStudentDto(Student student){
        return new StudentDto(student.getStudentId(), student.getFirstName(), student.getLastName(), student.getBirthDate());
    }

    public Collection<StudentDto> toStudentDtoList(Collection<Student> students){

        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student student: students
             ) {
            studentDtoList.add(toStudentDto(student));

        }

        return studentDtoList;
    }


    public StudentDtoAll toStudentDtoAll(Student student){
        return new StudentDtoAll(student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getBirthDate(),
                student.getPsn(),
                student.getAddress()
        );
    }







}
