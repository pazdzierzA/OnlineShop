package com.solvd.onlineshop.models.people.employees;

import java.time.LocalDate;


public class Keyboarder extends Employee {

	private String password;
	private Boolean loggedIn;

	public Keyboarder() {
	}

	public Keyboarder(String firstName, String lastName, String email, LocalDate birthDate, String password) {
		super(firstName, lastName, email, birthDate);
		this.password = password;
		this.loggedIn = false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	@Override
	public void work() {
		System.out.println("Adding products to system");
	}

}
