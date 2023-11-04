package com.tns.placementManagementSystem.restFullAPIs.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.Admin;
import com.tns.placementManagementSystem.restFullAPIs.repository.AdminRepository;
@Service
@Transactional
public class AdminService {
	@Autowired
	 private AdminRepository repo;// no new operator

	 public List<Admin> listAll() //RETRIEVE
	 {
	 return repo.findAll();
	 }
	 
	 public void save(Admin admin) //CREATE OR INSERT
	 {
	 repo.save(admin);
	 }
	 
	 public Admin get(Long id) //RETRIEVE ON THE BASIS OF ID
	 {
		 return repo.findById(id).get();
	 }
	 
	 public void delete(Long id) 
	 {
	 repo.deleteById(id);
	 }
	}
