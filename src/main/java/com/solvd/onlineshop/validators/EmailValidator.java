package com.solvd.onlineshop.validators;

import com.solvd.onlineshop.interfaces.IValidator;

public class EmailValidator implements IValidator<String> {
	@Override
	public boolean isValid(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}
		String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
		return email.matches(emailRegex);
	}
}
