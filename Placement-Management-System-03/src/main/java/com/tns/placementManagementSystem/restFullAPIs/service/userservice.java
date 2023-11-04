package com.tns.placementManagementSystem.restFullAPIs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.placementManagementSystem.restFullAPIs.entity.user;
import com.tns.placementManagementSystem.restFullAPIs.repository.userRepository;

import jakarta.transaction.Transactional;

import java.util.List;
@Service
@Transactional
public class userservice //CRUD
{
 @Autowired
	
	    private userRepository repo;//no new operator

	    public List<user> listAll() //RETRIVE
	    {
	        return repo.findAll();
	    }
        
	    public void save(user user) //CREATE ORINSERT
	    {
	    	 repo.save(user);
	    }
	    public user get(Integer id)//RETRIVE ON THE BASIS OF ID
	    {
	     return repo.findById(id).get();	
	    }
	    
	    public void delete (Integer id)
	    {
	    	repo.deleteById(id);
	    }
}