package com.tns.placementManagementSystem.restFullAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.placementManagementSystem.restFullAPIs.entity.College;

@Repository 
public interface CollegeRepository extends JpaRepository<College, Long> //Entity class
{

}