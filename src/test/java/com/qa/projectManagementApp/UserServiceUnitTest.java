package com.qa.projectManagementApp;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.repo.UserRepo;
import com.qa.projectManagementApp.service.UserService;

@SpringBootTest
public class UserServiceUnitTest {
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepo repo;
	
	@Test
	void testCreate() {
		final User TEST_USER= new User(0, "Safluke", "Ahmed","saf_2356@outlook.com", null ,null, "root", null);
		final User TEST_SAVED_USER=new User( 1L, "Safluke", "Ahmed","saf_2356@outlook.com", "Active" ,LocalDateTime.now(), "root", "USER");
		// WHEN
		Mockito.when(this.repo.save(TEST_USER)).thenReturn((TEST_SAVED_USER));
		// THEN
	     Assertions.assertThat(this.service.addUser(TEST_USER)).isEqualTo(TEST_SAVED_USER);
	  // verify that our repo was accessed exactly once
	     Mockito.verify(this.repo, Mockito.times(1)).save(TEST_USER);
	}
	

}
