package com.tns.placementManagementSystem.restFullAPIs.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.placementManagementSystem.restFullAPIs.entity.Placement;

public interface PlacementRepository extends JpaRepository<Placement,Long> {
}