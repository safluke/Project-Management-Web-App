package com.qa.projectManagementApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Account does not exist with that E-mail :(")
public class UserNotFoundException extends NullPointerException{
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 2304181817015989070L;

}
