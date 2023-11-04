package com.tns.placementManagementSystem.restFullAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.placementManagementSystem.restFullAPIs.entity.user;

public interface userRepository extends JpaRepository<user ,Integer>//Entity class
{

}