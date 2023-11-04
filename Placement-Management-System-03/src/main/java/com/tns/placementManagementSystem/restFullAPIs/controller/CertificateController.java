package com.tns.placementManagementSystem.restFullAPIs.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.exceptions.CertificateNotFound;
import com.tns.placementManagementSystem.restFullAPIs.entity.Certificate;
import com.tns.placementManagementSystem.restFullAPIs.repository.CertificateRepository;
import com.tns.placementManagementSystem.restFullAPIs.service.CertificateService;

@RestController

@CrossOrigin(origins="*")
public class CertificateController 
{//DEPENDENCY INJECTION USING AUTOWIRING
 @Autowired
 private CertificateService service;//reference variable
 private CertificateRepository repo;


    CertificateController(CertificateRepository repo) {
        this.repo = repo;
    }
 
 
 // RESTful API methods for Retrieval operations
 @GetMapping("/certificates")     
 public List<Certificate> list() 
 {
 return service.listAll();
 }
 
 @GetMapping("/certificates/{id}")
 public ResponseEntity<Certificate> get(@PathVariable Long id) 
 {
 try
 {
 Certificate certificate = service.get(id);
 return new ResponseEntity<Certificate>(certificate, HttpStatus.OK);
 } 

 catch(CertificateNotFound ex)
 {
	
	 return new ResponseEntity<Certificate>( HttpStatus.NOT_FOUND);
 }
 }
 
 //create or insert

 @PostMapping("/certificates")
 public void add(@RequestBody Certificate certificate) 
 {
 service.save(certificate);
 }
 
 

 @PutMapping("/certificates/{id}")
 public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable Long id) 
 {
 try
 {
 Certificate existCertificate = service.get(id);
 service.save(certificate);
 return new ResponseEntity<>(HttpStatus.OK);
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 } 
 }

 @DeleteMapping("/certificates/{id}")
 public void delete(@PathVariable Long id) //extracting ID from the URL
 {
 service.delete(id);
 }
}