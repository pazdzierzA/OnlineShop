package com.solvd.onlineshop.discounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.onlineshop.exceptions.InvalidProductDiscountRateException;
import com.solvd.onlineshop.exceptions.InvalidProductPriceException;
import com.solvd.onlineshop.interfaces.Discountable;


public class DiscountManager<T> {
	private final static Logger logger = LogManager.getLogger(DiscountManager.class.getName());
	private final Discountable<T> discountStrategy;

	public DiscountManager(Discountable<T> discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public void applyDiscount(T object) {
		try {
			discountStrategy.applyDiscount(object);
		} catch (InvalidProductDiscountRateException e) {
			logger.error("Invalid discount rate applied to object: {}. Error: {}", object, e.getMessage(),e);
			e.printStackTrace();
		} catch (InvalidProductPriceException e) {
			logger.error("Invalid product price detected for object: {}. Error: {}", object, e.getMessage(), e);
			e.printStackTrace();
		}

	}
}
