package com.solvd.onlineshop.exceptions;

public class InvalidProductDiscountRateException extends Exception {

	private static final long serialVersionUID = 1L;
	private Double discountRateValue;
	public InvalidProductDiscountRateException(Double discountRateValue, String message) {
		super(message);
		this.discountRateValue = discountRateValue;
		
	}
	public Double getDiscountRateValue() {
		return discountRateValue;
	}
	public void setDiscountRateValue(Double discountRateValue) {
		this.discountRateValue = discountRateValue;
	}
	

}
