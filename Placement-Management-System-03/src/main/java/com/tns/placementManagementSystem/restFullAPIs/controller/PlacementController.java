package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.PlacementNotFound;
import com.example.exceptions.StudentNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.Placement;
import com.tns.placementManagementSystem.restFullAPIs.entity.Student;
import com.tns.placementManagementSystem.restFullAPIs.repository.PlacementRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.PlacementService;

@RestController
public class PlacementController {
	 @Autowired
	 private PlacementService service;//reference variable
	@Autowired
	 private PlacementRepository repo;
	 
	 
	 // RESTful API methods for Retrieval operations
	 @GetMapping("/placement")     
	 public List<Placement> List() 
	 {
	 return  service.listAll();
	 }
	 
	 @GetMapping("/placement/{id}")
	 public ResponseEntity<Placement> get(@PathVariable Long id) 
	 {
	 try
	 
	 {
	 Placement placement = service.get(id);
	 return new ResponseEntity<Placement>(placement, HttpStatus.OK);
	 } 

	 catch(PlacementNotFound ex)
	 {
		
		 return new ResponseEntity<Placement>( HttpStatus.NOT_FOUND);
	 }
	 }
	 
	 //create or insert

	 @PostMapping("/placement")
	 public <service> void add(@RequestBody Placement placement) 
	 {
	 service.save(placement);
	 }
	 @PutMapping("/placement/{id}")
	 public ResponseEntity<?> update(@RequestBody Placement placement, @PathVariable Long id) 
	 {
	 try
	 {
	
	Placement existplacement = service.get(id);
	 service.save(placement);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }

	 @DeleteMapping("/placement/{id}")
	 public void delete(@PathVariable Long id) //extracting ID from the URL
	 {
	 service.delete(id);
	 }
	}