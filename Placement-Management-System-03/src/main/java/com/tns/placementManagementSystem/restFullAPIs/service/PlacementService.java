package com.tns.placementManagementSystem.restFullAPIs.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.Placement;
import com.tns.placementManagementSystem.restFullAPIs.repository.PlacementRepository;
@Service
@Transactional
public class PlacementService {
	@Autowired
	 private PlacementRepository repo;// no new operator
	 
	 public List<Placement> listAll() //RETRIEVE
	 {
	 return repo.findAll();
	 }
	 
	 public void save(Placement placement) //CREATE OR INSERT
	 {
	 repo.save(placement);
	 }
	 
	 public Placement get(Long id) //RETRIEVE ON THE BASIS OF ID
	 {
	 return repo.findById(id).get();
	 }
	 
	 public void delete(Long id) 
	 {
	 repo.deleteById(id);
	 }
	}
