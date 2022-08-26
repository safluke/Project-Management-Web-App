package com.qa.projectManagementApp;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.projectManagementApp.entities.Login;
import com.qa.projectManagementApp.repo.LoginRepo;
import com.qa.projectManagementApp.service.LoginService;

@SpringBootTest
public class LoginServiceUnitTest {
	
	@Autowired
	private LoginService service;
	
	@MockBean
	private LoginRepo repo;
	
	@Test
	void testCreate() {
		final Login TEST_LOGIN= new Login(0, 5, null, null);
		final Login TEST_SAVED_LOGIN=new Login(1l, 5, "Online", LocalDateTime.now());
		// WHEN
		Mockito.when(this.repo.save(TEST_LOGIN)).thenReturn((TEST_SAVED_LOGIN));
		// THEN
	     Assertions.assertThat(this.service.addLogin(TEST_LOGIN)).isEqualTo(TEST_SAVED_LOGIN);
	  // verify that our repo was accessed exactly once
	     Mockito.verify(this.repo, Mockito.times(1)).save(TEST_LOGIN);
	}

}
