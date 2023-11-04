package com.tns.placementManagementSystem.restFullAPIs.service;


import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.Certificate;
import com.tns.placementManagementSystem.restFullAPIs.repository.CertificateRepository;
@Service
@Transactional
public class CertificateService //CRUD
{
 @Autowired
 private CertificateRepository repo;// no new operator
 
 public List<Certificate> listAll() //RETRIEVE
 {
 return repo.findAll();
 }
 
 public void save(Certificate certificate) //CREATE OR INSERT
 {
 repo.save(certificate);
 }
 
 public Certificate get(Long id) //RETRIEVE ON THE BASIS OF ID
 {
 return repo.findById(id).get();
 }
 
 public void delete(Long id) 
 {
 repo.deleteById(id);
 }
}