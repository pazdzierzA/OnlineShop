package com.solvd.onlineshop.interfaces;

import com.solvd.onlineshop.exceptions.InvalidProductDiscountRateException;
import com.solvd.onlineshop.exceptions.InvalidProductPriceException;

public interface Discountable<T> {
	void applyDiscount(T object) throws InvalidProductDiscountRateException, InvalidProductPriceException;
}