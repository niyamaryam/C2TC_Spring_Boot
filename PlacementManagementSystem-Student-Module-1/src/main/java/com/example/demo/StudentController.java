package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.StudentNotFound;

@RestController

public class StudentController {
	//DEPENDENCY INJECTION USING AUTOWIRING
	 @Autowired
	 private StudentService service;//reference variable
	 @Autowired
	 private StudentRepository repo;
	 
	 
	 // RESTful API methods for Retrieval operations
	 @GetMapping("/")
	 public String index() {
		 return "Welcome to spring boot crud application!!! Hey, everyone! I am Niya Maryam, "
		 		+ "bearing the UID TCO5060320. In the context of our Placement Management System project, "
		 		+ "I will be using a dummy client --> Postman to demonstrate the implementation of "
		 		+ "CRUD (Create, Read, Update, Delete) operations. Without further ado, "
		 		+ "let's embark on this exciting journey into the world of database management and system functionality!!";
	 }
	 
	 @GetMapping("/student")     
	 public List<Student> list() 
	 {
	 return service.listAll();
	 }
	 
	 @GetMapping("/student/{id}")
	 public ResponseEntity<Student> get(@PathVariable Long id) 
	 {
	 try
	 
	 {
	 Student student = service.get(id);
	 return new ResponseEntity<Student>(student, HttpStatus.OK);
	 } 

	 catch(StudentNotFound ex)
	 {
		
		 return new ResponseEntity<Student>( HttpStatus.NOT_FOUND);
	 }
	 }
	 
	 // RESTful API method for Create operation <create or insert>

	 @PostMapping("/student")
	 public void add(@RequestBody Student s) 
	 {
	 service.save(s);
	 }
	 
	// RESTful API method for Update operation

	 @PutMapping("/student/{id}")
	 public ResponseEntity<?> update(@RequestBody Student s, @PathVariable Long id) 
	 {
	 try
	 {
	 Student existStudent = service.get(id);
	 service.save(s);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 
	// RESTful API method for Delete operation

	 @DeleteMapping("/student/{id}")
	 public void delete(@PathVariable Long id) //extracting ID from the URL
	 {
	 service.delete(id);

}
}

