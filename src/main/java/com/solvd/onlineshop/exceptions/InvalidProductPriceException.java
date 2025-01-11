package com.solvd.onlineshop.exceptions;

public class InvalidProductPriceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Double productPriceValue;
	private String productName;

	
	public InvalidProductPriceException(String productName, Double productPriceValue,String message) {
		super(message);
		this.productName = productName;
		this.productPriceValue =  productPriceValue;
	}

	public Double getProductPriceValue() {
		return productPriceValue;
	}

	public void setProductPriceValue(Double productPriceValue) {
		this.productPriceValue = productPriceValue;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
