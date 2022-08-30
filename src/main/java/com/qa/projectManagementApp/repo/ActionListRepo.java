package com.qa.projectManagementApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.projectManagementApp.entities.Actionlist;



@Repository
public interface ActionListRepo extends JpaRepository<Actionlist, Long>{

	List<Actionlist> findByUserid(int userid);

	
	@Query("SELECT p from Actionlist p WHERE p.userid = ?1")
	List<Actionlist> findActionlistByUseridJPQL(int userid);
	
	@Query("SELECT p from Actionlist p WHERE p.actionid = ?1")
	Actionlist findUseridbyActionidJPQL(long actionid);
	
	
}
