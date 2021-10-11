package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.simon.spring_boot_restapi_intro.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {


    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("123456","Simon", "Elbrink", LocalDate.parse("1997-03-18"),"1997-03-18-0000", "Nygatan 8 Lenhovda"),
                    new Student("asdf", "Erik", "Svensson", LocalDate.parse("1976-01-01"),"1976-01-01-0000","Växjö SomeWhereStreet")
            )
    );


    @GetMapping("/firstresource")
    public ResponseEntity<Student> getResource(){

        return ResponseEntity.status(HttpStatus.valueOf(200)).body(students.get(0));
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> findAll(){

        if (students.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

}
