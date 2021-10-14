package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.simon.spring_boot_restapi_intro.service.StudentService;
import se.lexicon.simon.spring_boot_restapi_intro.model.Student;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * A place for handling the endpoints for the java program.
 * Clients can then access the methods through Http methods and the Path.
 */
@RestController
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

        @GetMapping("/firstresource")
    public ResponseEntity<Student> getResource(){

        return ResponseEntity.status(HttpStatus.valueOf(200)).body(studentService.findById("123456"));
    }

//    @GetMapping("/api/students")
//    public ResponseEntity<List<Student>> findAll(){
//
//        if (students.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(students);
//    }


    @PostMapping("/api/students")
    public ResponseEntity<Student> create(@RequestBody Student student){

        Student saved = studentService.create(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//        return ResponseEntity.created(URI.create("localhost:8080/api/students/" + saved.getStudentId())).body(saved);
    }

    @GetMapping("api/students/{id}")
    public ResponseEntity<Student> findById( @PathVariable("id") String studentId){

        Student foundStudentById = studentService.findById(studentId);

        return ResponseEntity.ok(foundStudentById);

    }

//    @GetMapping("/api/students")
//    public ResponseEntity<?> genericFind(
//          @RequestParam(name = "type", defaultValue = "all")  String type,
//          @RequestParam(name = "value", defaultValue = "all")  String value
//    ){
//
//        switch (type.toLowerCase().trim()){
//            case "all":
//                return ResponseEntity.ok(studentService.findAll());
//            case "firstname":
//                return ResponseEntity.ok(studentService.findAllByName(value));
//            case "id":
//                return ResponseEntity.ok(studentService.findById(value));
//            default:
//                return ResponseEntity.badRequest().body("Invalid Type");
//        }
//    }
    @GetMapping("/api/students")
    public ResponseEntity<?> genericFind(
          @RequestParam(name = "name", required = false)  String name,
          @RequestParam(name = "id", required = false)  String id
    ){

        ResponseEntity<Collection<Student>> response = ResponseEntity.badRequest().build();
        HashSet<Student> matches = new HashSet<>();

        if (id != null){
            matches.add(studentService.findById(id));
        } else if (name != null){
            matches.addAll(studentService.findAllByName(name));
        } else {
            matches.addAll(studentService.findAll());
        }

        return matches.isEmpty() ? response : ResponseEntity.ok(matches);

    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") String studentId,
                                          @RequestBody Student student ){

        if (studentId.equals(student.getStudentId())){

            Student updatedStudent = studentService.update(student);

            return ResponseEntity.ok().body(updatedStudent);
        }else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String studentId){

        studentService.delete(studentId);

        return ResponseEntity.ok().build();

    }

}
