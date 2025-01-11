package com.solvd.onlineshop.validators;

import com.solvd.onlineshop.interfaces.IValidator;

public class PasswordValidator implements IValidator<String> {

	@Override
	public boolean isValid(String password) {
		if (password == null || password.isEmpty()) {
			return false;
		}
		if(password.length() < 8){
			return false;
		}
		return true;
	}
}
