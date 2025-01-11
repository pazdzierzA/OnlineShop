package com.solvd.onlineshop.models.people.employees;

import java.time.LocalDate;

public class Warehouseman extends Employee  {

	public Warehouseman() {
	}

	public Warehouseman(String firstName, String lastName, String email, LocalDate birthDate) {
		super(firstName, lastName, email, birthDate);
	}

	@Override
	public void work() {
		System.out.println("Managing products in the warehouse");
	}

}
