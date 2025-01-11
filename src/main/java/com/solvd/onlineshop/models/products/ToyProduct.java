package com.solvd.onlineshop.models.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.enums.ProductBrand;

public class ToyProduct extends Product {
	private final static Logger logger = LogManager.getLogger(ToyProduct.class.getName());
	private Boolean batteryRequired;
	private Boolean soundsEffects;
	private String warrantyPeriod;
	private Boolean lightEffects;
	private String safetyCertification;

	public ToyProduct() {

	}

	public ToyProduct(ProductBrand brand, String name, Double price, String description, String color, String category,
			Boolean batteryRequired, Boolean soundsEffects, String warrantyPeriod, Boolean lightEffects,
			String safetyCertification)  {
		super(brand, name, price, description, color, category);
		this.batteryRequired = batteryRequired;
		this.soundsEffects = soundsEffects;
		this.warrantyPeriod = warrantyPeriod;
		this.lightEffects = lightEffects;
		this.safetyCertification = safetyCertification;

	}

	public Boolean isBatteryRequired() {
		return batteryRequired;
	}

	public void setBatteryRequired(Boolean batteryRequired) {
		this.batteryRequired = batteryRequired;
	}

	public Boolean isSoundsEffects() {
		return soundsEffects;
	}

	public void setSoundsEffects(Boolean soundsEffects) {
		this.soundsEffects = soundsEffects;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Boolean isLightEffects() {
		return lightEffects;
	}

	public void setLightEffects(Boolean lightEffects) {
		this.lightEffects = lightEffects;
	}

	public String getSafetyCertification() {
		return safetyCertification;
	}

	public void setSafetyCertification(String safetyCertification) {
		this.safetyCertification = safetyCertification;
	}
	
	@Override
	public void demoProduct() {
		logger.debug("Showing 3D wizualization of product");
		//System.out.println("This product has 3D wizualization.");
	}
	
	@Override
	public String toString() {
		return "ToyProduct [batteryRequired=" + batteryRequired + ", soundsEffects=" + soundsEffects
				+ ", warrantyPeriod=" + warrantyPeriod + ", lightEffects=" + lightEffects + ", safetyCertification="
				+ safetyCertification + ", getProductID()=" + getProductID() + ", getName()=" + getName()
				+ ", getBrand()=" + getBrand() + ", getPrice()=" + getPrice() + ", getDescription()=" + getDescription()
				+ ", getColor()=" + getColor() + ", getCategory()=" + getCategory() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
