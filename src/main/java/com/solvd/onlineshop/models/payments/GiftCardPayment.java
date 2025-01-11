package com.solvd.onlineshop.models.payments;

import java.util.Objects;

public class GiftCardPayment extends Payment {

	private String giftCardCode;

	public GiftCardPayment() {

	}

	public GiftCardPayment(Double paymentTotal, String giftCardCode) {
		super(paymentTotal);
		this.giftCardCode = giftCardCode;
	}

	public String getGiftCardCode() {
		return giftCardCode;
	}

	public void setGiftCardCode(String giftCardCode) {
		this.giftCardCode = giftCardCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(giftCardCode);
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
		GiftCardPayment other = (GiftCardPayment) obj;

		return Objects.equals(giftCardCode, other.giftCardCode);
	}



}
