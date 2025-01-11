package com.solvd.onlineshop.models.people.employees;

import java.time.LocalDate;

import com.solvd.onlineshop.models.people.Person;

public abstract class Employee extends Person {
	private LocalDate birthDate;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String email, LocalDate birthDate) {
		super(firstName, lastName, email);
		this.birthDate = birthDate;

	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public abstract void work();
}
