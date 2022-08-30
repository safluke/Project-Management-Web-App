package com.qa.projectManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.projectManagementApp.entities.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

}
