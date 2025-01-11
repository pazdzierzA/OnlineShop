package com.solvd.onlineshop.exceptions;

public abstract class  PaymentProcessingException extends Exception {

	private static final long serialVersionUID = 1L;
	private String transactionId;

	public PaymentProcessingException(String transactionId, String message) {
		super(message);
		this.transactionId=transactionId;
	}

	public PaymentProcessingException(String message) {
		super(message);

	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}
