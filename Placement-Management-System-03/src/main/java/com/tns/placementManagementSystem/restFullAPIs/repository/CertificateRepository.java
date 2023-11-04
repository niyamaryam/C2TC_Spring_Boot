package com.tns.placementManagementSystem.restFullAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.placementManagementSystem.restFullAPIs.entity.Certificate;
public interface CertificateRepository extends JpaRepository<Certificate, Long> //Entity class
{
	
}