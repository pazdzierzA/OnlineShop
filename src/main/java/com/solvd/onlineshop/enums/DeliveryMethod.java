package com.solvd.onlineshop.enums;

public enum DeliveryMethod {
	DELIVERY_MAN("Delivery via a courier to your address"),
	PICKUP_POINT("Pick up your order from a designated location");
	
	
	private final String description;
	
	private DeliveryMethod( String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}

