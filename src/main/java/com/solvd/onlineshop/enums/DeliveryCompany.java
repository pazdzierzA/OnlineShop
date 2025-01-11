package com.solvd.onlineshop.enums;

import java.util.Map;

public enum DeliveryCompany {

	INPOST("InPost", Map.of(DeliveryMethod.DELIVERY_MAN, 10.0, DeliveryMethod.PICKUP_POINT, 5.0)),
	DHL("DHL", Map.of(DeliveryMethod.DELIVERY_MAN, 15.0, DeliveryMethod.PICKUP_POINT, 9.0)),
	UPS("UPS", Map.of(DeliveryMethod.DELIVERY_MAN, 12.0));

	private final String companyName;
	private final Map<DeliveryMethod, Double> methodCost;

	private DeliveryCompany(String companyName, Map<DeliveryMethod, Double> methodCost) {
		this.methodCost = methodCost;
		this.companyName = companyName;
	}

	public Map<DeliveryMethod, Double> getMethodCosts() {
		return methodCost;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Boolean supports(DeliveryMethod method) {
		return methodCost.containsKey(method);
	}

	public Double getCost(DeliveryMethod method) throws IllegalArgumentException {
		if (!supports(method)) {
			throw new IllegalArgumentException("Company " + this + " doesn't have  " + method);
		} else
			return methodCost.get(method);
	}

}
