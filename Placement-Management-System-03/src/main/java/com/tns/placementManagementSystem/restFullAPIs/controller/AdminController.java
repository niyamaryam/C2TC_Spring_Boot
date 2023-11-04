package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.AdminNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.Admin;
import com.tns.placementManagementSystem.restFullAPIs.entity.Student;
import com.tns.placementManagementSystem.restFullAPIs.repository.AdminRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.AdminService;

@RestController
public class AdminController {
	//DEPENDENCY INJECTION USING AUTOWIRING
	 @Autowired
	 private AdminService service;//reference variable
	 @Autowired
	 private AdminRepository repo;
	 
	 
	 // RESTful API methods for Retrieval operations
	 @GetMapping("/admin")     
	 public List<Admin> list() 
	 {
	 return service.listAll();
	 }
	 
	 @GetMapping("/admin/{id}")
	 public ResponseEntity<Admin> get(@PathVariable long id) 
	 {
	 try
	 {
	 Admin admin = service.get(id);
	 return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	 } 

	 catch(AdminNotFound ex)
	 {
		
		 return new ResponseEntity<Admin>( HttpStatus.NOT_FOUND);
	 }
	 }
	 
	 //create or insert

	 @PostMapping("/admin")
	 public void add(@RequestBody Admin admin) 
	 {
	 service.save(admin);
	 }
	 
	 

	 @PutMapping("/admin/{id}")
	 public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Long id) 
	 {
	 try
	 {
	 Admin existAdmin = service.get(id);
	 service.save(admin);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }

	 @DeleteMapping("/admin/{id}")
	 public void delete(@PathVariable Long id) //extracting ID from the URL
	 {
	 service.delete(id);
	 }
	}
	