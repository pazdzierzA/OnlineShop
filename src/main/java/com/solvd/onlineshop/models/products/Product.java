package com.solvd.onlineshop.models.products;
import java.util.UUID;

import com.solvd.onlineshop.enums.ProductBrand;
import com.solvd.onlineshop.exceptions.InvalidProductPriceException;

public abstract class Product {

	private String productID;
	private ProductBrand brand;
	private String name;
	private Double price;
	private String description;
	private String color;
	private String category;
	private Double discountRate;

	public Product() {
	}

	public Product(ProductBrand brand, String name, Double price, String description, String color, String category) {
		this.productID = UUID.randomUUID().toString();
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.description = description;
		this.color = color;
		this.category = category;
		this.discountRate = 0.0;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	

	public void setPrice(Double price) throws InvalidProductPriceException {
		if (price < 0) {
			throw new InvalidProductPriceException(name, price, "You can't have price value less than 0");
		}
		this.price = price;

	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProductBrand getBrand() {
		return brand;
	}

	public void setBrand(ProductBrand brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	public abstract void demoProduct();
	

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", brand=" + brand + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", color=" + color + ", category=" + category + "]";
	}
	


}