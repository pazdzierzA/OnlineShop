package com.solvd.onlineshop.interfaces;

import com.solvd.onlineshop.exceptions.PaymentProcessingException;
import com.solvd.onlineshop.models.deliveries.Delivery;
import com.solvd.onlineshop.models.payments.Payment;


public interface IProcessPayment {
	
	void processPayment(Payment payment, IShoppingCart shoppingCart, Delivery delivery, String currency) throws PaymentProcessingException;
}