package com.solvd.onlineshop.models.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.enums.ProductBrand;

public class FurnitureProduct extends Product {
	private final static Logger logger = LogManager.getLogger(FurnitureProduct.class.getName());
	private String material;
	private Integer height;
	private Integer width;
	private String destiny;

	public FurnitureProduct() {

	}

	public FurnitureProduct(ProductBrand brand, String name, Double price, String description, String color, String category,
			String material, Integer height, Integer width, String destiny){
		super(brand, name, price, description, color, category);
		this.material = material;
		this.height = height;
		this.width = width;
		this.destiny = destiny;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	@Override
	public void demoProduct() {
		logger.debug("Showing 3D wizualization of product");
		//System.out.println("Displaying a 3D wizualization of this product features.");
	}

	@Override
	public String toString() {
		return "FurnitureProduct [material=" + material + ", height=" + height + ", width=" + width + ", destiny="
				+ destiny + ", getProductID()=" + getProductID() + ", getName()=" + getName() + ", getBrand()="
				+ getBrand() + ", getPrice()=" + getPrice() + ", getDescription()=" + getDescription() + ", getColor()="
				+ getColor() + ", getCategory()=" + getCategory() + "]";
	}
	
}
