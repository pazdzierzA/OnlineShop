package com.solvd.onlineshop.discounts;

import java.util.function.UnaryOperator;

import com.solvd.onlineshop.exceptions.InvalidProductDiscountRateException;
import com.solvd.onlineshop.interfaces.Discountable;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;

public class ShoppingCartDiscount implements Discountable<ShoppingCart> {

	private static Double discountRate = 0.1;

	public ShoppingCartDiscount() {

	}

	@Override
	public void applyDiscount(ShoppingCart shoppingCart) throws InvalidProductDiscountRateException {
		Double shoppingCartValue = shoppingCart.getShoppingCartValue();
		if (discountRate <= 0) {
			throw new InvalidProductDiscountRateException(discountRate, "is smaller or equal zero");
		}
		if (discountRate >= 1) {
			throw new InvalidProductDiscountRateException(discountRate, "is bigger or equal one");
		}
		// lambda function unary operator
		UnaryOperator<Double> reducedValueByDiscountRate = price -> price * discountRate;
		Double discountedShoppingCartValue = reducedValueByDiscountRate.apply(shoppingCartValue);
		shoppingCart.setShoppingCartValue(discountedShoppingCartValue);
	}
}
