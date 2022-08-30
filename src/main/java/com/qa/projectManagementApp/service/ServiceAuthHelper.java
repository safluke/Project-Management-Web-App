package com.qa.projectManagementApp.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.projectManagementApp.Exception.UserRequestMatchException;
import com.qa.projectManagementApp.entities.Actionlist;
import com.qa.projectManagementApp.entities.Login;
import com.qa.projectManagementApp.repo.ActionListRepo;
import com.qa.projectManagementApp.repo.UserRepo;

@Service
public class ServiceAuthHelper {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ActionListRepo actionlistrepo;


	// decodes
	public boolean checkCredentialsObject(String authorizationHeader, Actionlist actionList) {
		String encode = authorizationHeader.split(" ")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(encode);
		String decodedString = new String(decodedBytes);
		String authEmail = decodedString.split(":")[0];
		System.out.println(authEmail);
		System.out.println(actionList.getUserid());
		if (userRepo.findUserByIdAndEmailJPQL((authEmail), actionList.getUserid()) == null) {
			throw new UserRequestMatchException();
		} else {
			return true;
		}
	}

	public boolean checkCredentialsActionId(String authorizationHeader, long actionid) {
		String encode = authorizationHeader.split(" ")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(encode);
		String decodedString = new String(decodedBytes);
		String authEmail = decodedString.split(":")[0];
		System.out.println(authEmail);
		System.out.println(actionlistrepo.findUseridbyActionidJPQL(actionid));
		String useridstring = actionlistrepo.findUseridbyActionidJPQL(actionid).toString().split("userid=")[1].split(",")[0];
		int userid =Integer.parseInt(useridstring);
		System.out.println(userid);
		if (userRepo.findUserByIdAndEmailJPQL((authEmail), userid) == null) {
			throw new UserRequestMatchException();
		} else {
			return true;
		}
	}

	public boolean checkCredentialsUserId(String authorizationHeader, int userid) {
		String encode = authorizationHeader.split(" ")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(encode);
		String decodedString = new String(decodedBytes);
		String authEmail = decodedString.split(":")[0];
		System.out.println(authEmail);
		System.out.println(userid);
		if (userRepo.findUserByIdAndEmailJPQL((authEmail), userid) == null) {
			throw new UserRequestMatchException();
		} else {
			return true;
		}
		
	}
	
	public boolean checkCredentialsLogin(String authorizationHeader, Login login) {
		String encode = authorizationHeader.split(" ")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(encode);
		String decodedString = new String(decodedBytes);
		String authEmail = decodedString.split(":")[0];
		System.out.println(authEmail);
		System.out.println(login.getUserid());
		if (userRepo.findUserByIdAndEmailJPQL((authEmail), login.getUserid()) == null) {
			throw new UserRequestMatchException();
		} else {
			return true;
		}
	}
}
