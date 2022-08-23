package com.qa.projectManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.projectManagementApp.entities.Actionlist;

@Repository
public interface ActionListRepo extends JpaRepository<Actionlist, Long>{

	
}
