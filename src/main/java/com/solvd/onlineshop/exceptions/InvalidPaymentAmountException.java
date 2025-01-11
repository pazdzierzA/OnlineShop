package com.solvd.onlineshop.exceptions;

public class InvalidPaymentAmountException extends PaymentProcessingException {

	private static final long serialVersionUID = 1L;

	private double invalidAmount;

	public InvalidPaymentAmountException(String transactionId, double invalidAmount, String message) {
		super(transactionId, message);
		this.invalidAmount = invalidAmount;
	}

	public double getInvalidAmount() {
		return invalidAmount;
	}

}
