package com.tns.placementManagementSystem.restFullAPIs.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.userNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.user;
import com.tns.placementManagementSystem.restFullAPIs.repository.userRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.userservice;

@RestController


public class usercontroller 
{//DEPENDENCY INJECTION USING AUTOWIRING
 @Autowired
 private userservice service;//reference variable
 @Autowired
 private userRepository repo;
 
 
 // RESTful API methods for Retrieval operations
 @GetMapping("/user")     
 public List<user> list() 
 {
 return service.listAll();
 }
 
 @GetMapping("/user/{id}")
 public ResponseEntity<user> get(@PathVariable Integer id) 
 {
 try
 {
 user user = service.get(id);
 return new ResponseEntity<user>(user, HttpStatus.OK);
 } 

 catch(userNotFound ex)
 {
	
	 return new ResponseEntity<user>( HttpStatus.NOT_FOUND);
 }
 }
 
 //create or insert

 @PostMapping("/user")
 public void add(@RequestBody user user) 
 {
 service.save(user);
 }
 
 

 @PutMapping("/user/{id}")
 public ResponseEntity<?> update(@RequestBody user user, @PathVariable Integer id) 
 {
 try
 {
 user existuser = service.get(id);
 service.save(user);
 return new ResponseEntity<>(HttpStatus.OK);
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 } 
 }

 @DeleteMapping("/user/{id}")
 public void delete(@PathVariable Integer id) //extracting ID from the URL
 {
 service.delete(id);
 }
}