package com.solvd.onlineshop.models.shoppingcarts;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.interfaces.IShoppingCart;
import com.solvd.onlineshop.lambdas.CartTotalCalculator;

import com.solvd.onlineshop.models.products.Product;

import com.solvd.onlineshop.OnlineShop;

public class ShoppingCart implements IShoppingCart {
	private final static Logger logger = LogManager.getLogger(ShoppingCart.class.getName());
	private List<Product> products = new ArrayList<>();
	private Double shoppingCartValue;

	public ShoppingCart() {

	}

	public ShoppingCart(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;

	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getShoppingCartValue() {
		return shoppingCartValue;
	}

	public void setShoppingCartValue(Double total) {
		this.shoppingCartValue = total;
	}

	public void sumToTotal() {
		final String currency = OnlineShop.CURRENCY;
		Double totalBasketValue = calculateBasket(products);
		setShoppingCartValue(totalBasketValue);
		logger.info("Basket total: {} {}", shoppingCartValue, currency);
	}

	public void addProduct(Product product) {
		products.add(product);
		logger.debug("{} has been added to the cart.", product.getName());
	}

	public void removeProduct(Product product) {
		products.remove(product);
		logger.debug("{} has been removed to the cart.", product.getName());
	}

	public void clearShoopingCart() {
		products.removeAll(products);
		logger.debug("Shopping cart has been cleared.");
	}

	// custom lambda
	private Double calculateBasket(List<Product> products) {
		// stream & mapToDouble
		CartTotalCalculator<Product> totalCalculator = items -> items.stream().mapToDouble(Product::getPrice).sum();
		return totalCalculator.calculateTotal(products);

	}

}
