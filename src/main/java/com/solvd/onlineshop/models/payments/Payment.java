package com.solvd.onlineshop.models.payments;

import java.time.LocalDate;
import java.util.Objects;
import java.util.*;

public abstract class Payment {

	private String transactionId;
	private Double paymentTotal;
	private String paymentDate;

	public Payment() {

	}

	public Payment(Double total) {
		this.transactionId = UUID.randomUUID().toString();
		this.paymentTotal = total;
		this.paymentDate = LocalDate.now().toString();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(Double total) {
		this.paymentTotal = total;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(paymentDate, paymentTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		Payment other = (Payment) obj;
	
		return Objects.equals(paymentDate, other.paymentDate) && Objects.equals(paymentTotal, other.paymentTotal);
	}

}
