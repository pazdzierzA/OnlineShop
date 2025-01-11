package com.solvd.onlineshop.models.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.onlineshop.enums.Gender;
import com.solvd.onlineshop.enums.ProductBrand;

public class ClothingProduct extends Product {
	private final static Logger logger = LogManager.getLogger(ClothingProduct.class.getName());
	private Enum<?> size;
	private Gender gender;
	private String material;
	private String season;

	public ClothingProduct() {

	}

	public ClothingProduct(ProductBrand brand, String name, Double price, String description, String color, String category,
			Enum<?> size, Gender gender, String material, String season) {
		super(brand, name, price, description, color, category);
		this.size = size;
		this.gender = gender;
		this.material = material;
		this.season = season;
	}

	public Enum<?> getSize() {
		return size;
	}

	public void setSize(Enum<?> size) {
		this.size = size;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public void demoProduct() {
		logger.debug("Showing 3D wizualization of product");
		//System.out.println("This product has 3D wizualization.");
	}

	@Override
	public String toString() {
		return "ClothingProduct [size=" + size + ", gender=" + gender + ", material=" + material + ", season=" + season
				+ ", getProductID()=" + getProductID() + ", getName()=" + getName() + ", getBrand()=" + getBrand()
				+ ", getPrice()=" + getPrice() + ", getDescription()=" + getDescription() + ", getColor()=" + getColor()
				+ ", getCategory()=" + getCategory() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
