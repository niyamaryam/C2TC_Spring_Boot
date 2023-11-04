package com.tns.placementManagementSystem.restFullAPIs.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.CollegeNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.College;
import com.tns.placementManagementSystem.restFullAPIs.repository.CollegeRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.CollegeService;

@RestController

public class CollegeController 
{
//DEPENDENCY INJECTION USING AUTOWIRING
 @Autowired
 private CollegeService service;//reference variable
 @Autowired
 private CollegeRepository repo;
 
 
 // RESTful API methods for Retrieval operations
 @GetMapping("/college")     
 public List<College> list() 
 {
 return service.listAll();
 }
 
 @GetMapping("/college/{id}")
 public ResponseEntity<College> get(@PathVariable Long id) 
 {
 try
 {
 College college = service.get(id);
 return new ResponseEntity<College>(college, HttpStatus.OK);
 } 

 catch(CollegeNotFound ex)
 {
	
	 return new ResponseEntity<College>( HttpStatus.NOT_FOUND);
 }
 }
 
 //create or insert

 @PostMapping("/college")
 public void add(@RequestBody College college) 
 {
 service.save(college);
 }
 
 

 @PutMapping("/college/{id}")
 public ResponseEntity<?> update(@RequestBody College college, @PathVariable Long id) 
 {
 try
 {
 College existStudent = service.get(id);
 service.save(college);
 return new ResponseEntity<>(HttpStatus.OK);
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 } 
 }

 @DeleteMapping("/college/{id}")
 public void delete(@PathVariable Long id) //extracting ID from the URL
 {
 service.delete(id);
 }
}