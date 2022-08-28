package com.qa.projectManagementApp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.projectManagementApp.entities.Actionlist;
import com.qa.projectManagementApp.repo.ActionListRepo;
import com.qa.projectManagementApp.service.ActionListService;
@SpringBootTest
public class ActionServiceUnitTest {
		
	@Autowired
	private ActionListService service;
	
	@MockBean
	private ActionListRepo repo;
	
	@Test
	void testCreate() {
		final Actionlist TEST_ACTIONLIST= new Actionlist(0, 5, LocalDate.now(), "content", null, LocalDate.now(), null, null);
		final Actionlist TEST_SAVED_ACTIONLIST=new Actionlist(1L, 0, LocalDate.now(), "content", "Not Started", LocalDate.now(), LocalDate.now(), LocalDate.now());
		// WHEN
		Mockito.when(this.repo.save(TEST_ACTIONLIST)).thenReturn((TEST_SAVED_ACTIONLIST));
		// THEN
	     Assertions.assertThat(this.service.addActionList(TEST_ACTIONLIST)).isEqualTo(TEST_SAVED_ACTIONLIST);
	  // verify that our repo was accessed exactly once
	     Mockito.verify(this.repo, Mockito.times(1)).save(TEST_ACTIONLIST);
	}
		


}
