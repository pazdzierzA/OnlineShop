package com.solvd.onlineshop.processes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.interfaces.Loginable;
import com.solvd.onlineshop.validators.EmailValidator;
import com.solvd.onlineshop.validators.LoginValidator;
import com.solvd.onlineshop.validators.PasswordValidator;

public class ProcessLogin implements Loginable {
	private static final Logger logger = LogManager.getLogger(ProcessLogin.class.getName());
	
	@Override
	public Boolean login(String userEmail, String userPassword, String inputEmail, String inputPassword) {
		EmailValidator emailValidator = new EmailValidator();
		PasswordValidator passwordValidator = new PasswordValidator();
		
		 if (!emailValidator.isValid(inputEmail)) {
	            logger.warn("Invalid email format: {}", inputEmail);
	            return false;
	        }

	        if (!passwordValidator.isValid(inputPassword)) {
	            logger.warn("Invalid password format for email: {}", inputEmail);
	            return false;
	        }

	        if (!LoginValidator.validateLogin(userEmail, userPassword, inputEmail, inputPassword)) {
	            logger.info("Login attempt failed for email: {}", inputEmail);
	            return false;
	        }

	        logger.info("Login successful for email: {}", inputEmail);
	        return true;
	    }
	}
