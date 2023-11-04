package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.StudentNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.Student;
import com.tns.placementManagementSystem.restFullAPIs.repository.StudentRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.StudentService;

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
		 return "Welcome to spring boot crud application!!!";
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

