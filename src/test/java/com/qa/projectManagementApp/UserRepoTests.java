package com.qa.projectManagementApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.repo.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTests {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("saf_2356@outlook.com");
		user.setFirstname("Safluke");
		user.setLastname("Ahmed");
		user.setPassword("Test");
		
		User savedUser = repo.save(user);
		User existUser =entityManager.find(User.class, savedUser.getUserid());
				assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		
		
		
	}
}
;