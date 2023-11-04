package com.tns.placementManagementSystem.restFullAPIs.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.Student;
import com.tns.placementManagementSystem.restFullAPIs.repository.StudentRepository;
@Service
@Transactional
public class StudentService
{
 @Autowired
 private StudentRepository repo;// no new operator
 
 public List<Student> listAll() //RETRIEVE
 {
 return repo.findAll();
 
 }
 
 public void save(Student s) //CREATE OR INSERT
 {
 repo.save(s);
 }
 
 public Student get(Long id) //RETRIEVE ON THE BASIS OF ID
 {
 return repo.findById(id).get();
 }
 
 public void delete(Long id) 
 {
 repo.deleteById(id);
 }
}
