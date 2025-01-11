package com.solvd.onlineshop.exceptions;

public class PaymentMismatchException extends PaymentProcessingException {

	private static final long serialVersionUID = 1L;
	private double expectedAmount;
	private double providedAmount;

	public PaymentMismatchException(String transactionId, double expectedAmount, double providedAmount,
			String message) {
		super(transactionId, message);
		this.expectedAmount = expectedAmount;
		this.providedAmount = providedAmount;
	}

	public double getExpectedAmount() {
		return expectedAmount;
	}

	public double getProvidedAmount() {
		return providedAmount;
	}
}
