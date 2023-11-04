package com.tns.placementManagementSystem.restFullAPIs.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.College;
import com.tns.placementManagementSystem.restFullAPIs.repository.CollegeRepository;
@Service
@Transactional
public class CollegeService //CRUD
{
 @Autowired
 private CollegeRepository repo;// no new operator
 
 public List<College> listAll() //RETRIEVE
 {
 return repo.findAll();
 }
 
 public void save(College college) //CREATE OR INSERT
 {
 repo.save(college);
 }
 
 public College get(Long id) //RETRIEVE ON THE BASIS OF ID
 {
 return repo.findById(id).get();
 }
 
 public void delete(Long id) 
 {
 repo.deleteById(id);
 }
}
