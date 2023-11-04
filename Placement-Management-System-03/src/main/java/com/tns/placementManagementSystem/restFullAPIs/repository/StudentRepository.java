package com.tns.placementManagementSystem.restFullAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.placementManagementSystem.restFullAPIs.entity.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student, Long> //Entity class
{

}