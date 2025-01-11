package com.solvd.onlineshop.models.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.enums.ProductBrand;

public class ElectronicProduct extends Product {
	private final static Logger logger = LogManager.getLogger(ElectronicProduct.class.getName());
	private Integer power;
	private String modelNumber;
	private Boolean blueetoothConnection;
	private Boolean wifiConnection;
	private Integer batteryLife;

	public ElectronicProduct() {

	}

	public ElectronicProduct(ProductBrand brand, String name, Double price, String description, String color, String category,
			Integer power, String modelNumber, Boolean blueetoothConnection, Boolean wifiConnection,
			Integer batteryLife) {
		super(brand, name, price, description, color, category);
		this.power = power;
		this.modelNumber = modelNumber;
		this.blueetoothConnection = blueetoothConnection;
		this.wifiConnection = wifiConnection;
		this.batteryLife = batteryLife;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public boolean isBlueetoothConnection() {
		return blueetoothConnection;
	}

	public void setBlueetoothConnection(boolean blueetoothConnection) {
		this.blueetoothConnection = blueetoothConnection;
	}

	public boolean isWifiConnection() {
		return wifiConnection;
	}

	public void setWifiConnection(boolean wifiConnection) {
		this.wifiConnection = wifiConnection;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	@Override
	public void demoProduct() {
		logger.debug("No demo product is available for display.");
		//System.out.println("This product does not support demo functionality.");
	}
	
	@Override
	public String toString() {
		return "ElectronicProduct [power=" + power + ", modelNumber=" + modelNumber + ", blueetoothConnection="
				+ blueetoothConnection + ", wifiConnection=" + wifiConnection + ", batteryLife=" + batteryLife
				+ ", getProductID()=" + getProductID() + ", getName()=" + getName() + ", getBrand()=" + getBrand()
				+ ", getPrice()=" + getPrice() + ", getDescription()=" + getDescription() + ", getColor()=" + getColor()
				+ ", getCategory()=" + getCategory() + "]";
	}
}