package com.solvd.onlineshop.models.people.employees;

import java.time.LocalDate;


public class Packer extends Employee {

	public Packer() {
	}

	public Packer(String firstName, String lastName, String email, LocalDate birthDate) {
		super(firstName, lastName, email, birthDate);
	}

	@Override
	public void work() {
		System.out.println("Packing products");
	}
	
}
