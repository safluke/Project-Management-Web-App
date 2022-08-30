package com.qa.projectManagementApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Access Error: Request made for an account with a different User ID")
public class UserRequestMatchException extends NullPointerException{

}

