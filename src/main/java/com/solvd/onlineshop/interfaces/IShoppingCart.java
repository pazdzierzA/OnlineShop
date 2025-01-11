package com.solvd.onlineshop.interfaces;

import com.solvd.onlineshop.models.products.Product;

public interface IShoppingCart{
	void sumToTotal();
	void addProduct(Product product);
	void removeProduct(Product product);
	void clearShoopingCart();
	Double getShoppingCartValue();
}
