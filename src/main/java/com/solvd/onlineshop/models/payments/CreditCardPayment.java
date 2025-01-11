package com.solvd.onlineshop.models.payments;

import java.util.Objects;

public class CreditCardPayment extends Payment{

	private String cardHolder;
	private String cardNumber;
	private String cvv;

	public CreditCardPayment(Double paymentTotal, String cardHolder, String cardNumber, String cvv) {
		super(paymentTotal);
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.cvv = cvv;

	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardHolder, cardNumber, cvv);
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
		if (this.hashCode() != obj.hashCode()) 
			return false;
		CreditCardPayment other = (CreditCardPayment) obj;

		return Objects.equals(cardHolder, other.cardHolder) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(cvv, other.cvv);
	}

}
