package com.solvd.onlineshop.models.deliveries;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.OnlineShop;
import com.solvd.onlineshop.enums.DeliveryCompany;
import com.solvd.onlineshop.enums.DeliveryMethod;

public class Delivery {

	private final static Logger logger = LogManager.getLogger(Delivery.class.getName());
	private DeliveryCompany deliveryCompany;
	private DeliveryMethod deliveryMethod;
	private Double deliveryPrice;
	private String deliveryTime;
	

	public Delivery() {

	}

	public Delivery(DeliveryCompany deliveryCompany, DeliveryMethod deliveryMethod, String timeDelivery, Double basketValue) {
		this.deliveryCompany = deliveryCompany;
		this.deliveryMethod = deliveryMethod;
		this.deliveryTime = timeDelivery;
		this.deliveryPrice = calculateDeliveryCost(basketValue);
	}
	
	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	public DeliveryCompany getDeliveryCompany() {
		return deliveryCompany;
	}

	public void setDeliveryCompany(DeliveryCompany deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
			this.deliveryMethod = deliveryMethod;
	}

	public String getTimeDelivery() {
		return deliveryTime;
	}

	public void setdDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	private Double calculateDeliveryCost(final Double basketValue) {
		Double deliveryPrice = basketValue > 100 ? (double) 0 : (double) deliveryCompany.getCost(deliveryMethod);
		logger.debug("Calculated delivery price: {}{}", deliveryPrice, OnlineShop.CURRENCY);
		return deliveryPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deliveryCompany, deliveryMethod, deliveryPrice, deliveryTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(this.hashCode() != obj.hashCode())
			return false;
		Delivery other = (Delivery) obj;
	
		return Objects.equals(deliveryCompany, other.deliveryCompany) && deliveryMethod == other.deliveryMethod
				&& Objects.equals(deliveryPrice, other.deliveryPrice)
				&& Objects.equals(deliveryTime, other.deliveryTime);
	}

}
