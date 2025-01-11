package com.solvd.onlineshop.lambdas;

import com.solvd.onlineshop.models.products.ClothingProduct;
import com.solvd.onlineshop.models.products.ElectronicProduct;

public class ProductAffordabilityChecker {
	
	public static  Boolean isElectronicProductAffordable(ElectronicProduct product) {
		ProductValidator<ElectronicProduct> affordableProduct = item -> item.getPrice() < 1500.0;
		return affordableProduct.validate(product);
	
	}
	public static  Boolean isClothingProductAffordable(ClothingProduct product) {
		ProductValidator<ClothingProduct> affordableProduct = item -> item.getPrice() < 100.0;
		return affordableProduct.validate(product);
	
	}
}
