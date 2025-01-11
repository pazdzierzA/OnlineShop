package com.solvd.onlineshop.discounts;

import java.util.function.UnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.exceptions.InvalidProductDiscountRateException;
import com.solvd.onlineshop.exceptions.InvalidProductPriceException;
import com.solvd.onlineshop.interfaces.Discountable;
import com.solvd.onlineshop.models.products.Product;

public class ProductDiscount implements Discountable<Product> {
	private final static Logger logger = LogManager.getLogger(ProductDiscount.class.getName());
	private Double discountRate;

	public ProductDiscount(Double discountRate) {
		this.discountRate = discountRate;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public void applyDiscount(Product product) throws InvalidProductDiscountRateException {
		Double productPrice = product.getPrice();
		if (discountRate <= 0) {
			logger.warn("Invalid discount rate: {}. Discount rate must be greater than 0.", discountRate);
			throw new InvalidProductDiscountRateException(discountRate, "is smaller or equal zero");
		}
		if (discountRate >= 1) {
			logger.warn("Invalid discount rate: {}. Discount rate must be less than 1.", discountRate);
			throw new InvalidProductDiscountRateException(discountRate, "is bigger or equal one");
		}

		try {
			// lambda function unary operator
			UnaryOperator<Double> reducedPriceByDiscountRate = price -> price * discountRate;
			Double discountedPrice = reducedPriceByDiscountRate.apply(productPrice);
			Double discount = calculateDiscount(productPrice);
			product.setPrice(discountedPrice);
			logger.info("Discount of {} applied to product {}. New price: {}", discount, product, product.getPrice());
		} catch (InvalidProductPriceException e) {
			logger.error("Invalid product price applied to object: {}. Error: {}", product, e.getMessage(), e);
		}
	}

	private double calculateDiscount(Double productPrice) {
		return productPrice * discountRate;
	}

}
