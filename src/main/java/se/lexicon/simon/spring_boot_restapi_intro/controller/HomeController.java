package se.lexicon.simon.spring_boot_restapi_intro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

//    @RequestMapping(name = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String helloWorld(){
        return "<h1> Hello World - Message from home Controller! </h1>";
    }

    @GetMapping("/message")
    public ResponseEntity<String> responseString(
            @RequestParam(value = "message", defaultValue = "default Message from HomeController") String message){

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping
    public ResponseEntity<Void> foo(){

        return ResponseEntity.notFound().build();
    }

}
