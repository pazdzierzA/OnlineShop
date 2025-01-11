package com.solvd.onlineshop.models.payments;

import java.util.Objects;


public class PayPalPayment extends Payment{

	private String email;

	public PayPalPayment() {

	}

	public PayPalPayment(Double paymentTotal, String email) {
		super(paymentTotal);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(this.hashCode() != obj.hashCode())
			return false;
		PayPalPayment other = (PayPalPayment) obj;
		
		return Objects.equals(email, other.email);
	}

}
