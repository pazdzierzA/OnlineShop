package com.solvd.onlineshop.models.payments;

import java.util.Objects;


public class BankTransferPayment extends Payment{

	private String bankClientAccoutNumber;
	private String bankShopAccoutNumber;

	public BankTransferPayment() {

	}

	public BankTransferPayment(Double paymentTotal, String bankClientAccoutNumber, String bankShopAccoutNumber) {
		super(paymentTotal);
		this.bankClientAccoutNumber = bankClientAccoutNumber;
		this.bankShopAccoutNumber = bankShopAccoutNumber;
	}

	// getters&setters
	public String getBankAccoutNumber() {
		return bankClientAccoutNumber;
	}

	public void setBankAccoutNumber(String bankAccoutNumber) {
		this.bankClientAccoutNumber = bankAccoutNumber;
	}

	public String getBankShopAccoutNumber() {
		return bankShopAccoutNumber;
	}

	public void setBankShopAccoutNumber(String bankShopAccoutNumber) {
		this.bankShopAccoutNumber = bankShopAccoutNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bankClientAccoutNumber, bankShopAccoutNumber);
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
		BankTransferPayment other = (BankTransferPayment) obj;

		return Objects.equals(bankClientAccoutNumber, other.bankClientAccoutNumber)
				&& Objects.equals(bankShopAccoutNumber, other.bankShopAccoutNumber);
	}

}
