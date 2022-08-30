package com.qa.projectManagementApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.projectManagementApp.entities.ActionList;


@Repository
public interface ActionListRepo extends JpaRepository<ActionList, Long>{

	List<ActionList> findByUserid(int userid);

	
	@Query("SELECT p from Actionlist p WHERE p.userid = ?1")
	List<ActionList> findActionlistByUseridJPQL(int userid);
	
	@Query("SELECT p from Actionlist p WHERE p.actionid = ?1")
	ActionList findUseridbyActionidJPQL(long actionid);
	
	
}
