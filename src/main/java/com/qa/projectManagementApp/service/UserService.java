package com.qa.projectManagementApp.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.DTO.UserDTO;
import com.qa.projectManagementApp.DTO.checkUserDTO;
import com.qa.projectManagementApp.Exception.UserNotFoundException;
import com.qa.projectManagementApp.Security.CustomUserDetails;
import com.qa.projectManagementApp.entities.User;
import com.qa.projectManagementApp.repo.UserRepo;



@Service
public class UserService implements UserDetailsService {
	

	private UserRepo repo;
	private ModelMapper mapper;
	
	public UserService(UserRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private UserDTO mapToDTO(User user) {
        return this.mapper.map(user, UserDTO.class);
    }
	
	private checkUserDTO mapToDTOcheck(User user) {
        return this.mapper.map(user, checkUserDTO.class);
    }


	public List<User> getAllUsers() {
		return this.repo.findAll();
	}
	
	public User addUser(User user) {
		boolean check = isValidEmailAddress(user.getEmail());
		if (check) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return repo.save(user);
		
		}else {
			return user;}
				
	}
	
	public UserDTO getUserByEmail(String email) {
		User found = this.repo.findUserByEmailJPQL(email);
		if (found == null) { throw new UserNotFoundException();}
		else {return this.mapToDTO(found);}
}
	
	public checkUserDTO checkUserByEmail(String email) {
		User found = this.repo.findUserByEmailJPQL(email);
		if (found == null) { throw new UserNotFoundException();}
		else {return this.mapToDTOcheck(found);}
}
	
	
	
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

    
 	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = repo.findByEmail(email);

		if (user==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		return new CustomUserDetails(user);
	}
}