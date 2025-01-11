package com.solvd.onlineshop.validators;

public final class LoginValidator {

	public static boolean validateLogin(final String email, final String password, final String inputEmail,
			final String inputPassword) {

		return email.equals(inputEmail) && password.equals(inputPassword);
	}

}
