package com.solvd.onlineshop.processes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.exceptions.InvalidPaymentAmountException;
import com.solvd.onlineshop.exceptions.PaymentMismatchException;
import com.solvd.onlineshop.interfaces.IShoppingCart;
import com.solvd.onlineshop.models.deliveries.Delivery;
import com.solvd.onlineshop.models.orders.Order;
import com.solvd.onlineshop.models.payments.Payment;

public class ProcessPayment implements com.solvd.onlineshop.interfaces.IProcessPayment {
	private final static Logger logger = LogManager.getLogger(Order.class.getName());

	public void processPayment(Payment payment, IShoppingCart shoppingCart, Delivery delivery, String currency)
			throws com.solvd.onlineshop.exceptions.PaymentProcessingException {
		Double expectedTotal = shoppingCart.getShoppingCartValue() + delivery.getDeliveryPrice();
		Double paymentTotal = payment.getPaymentTotal();
		if (paymentTotal <= 0) {
			logger.error("Invalid payment amount detected for transaction ID: {}. Amount: {}",
					payment.getTransactionId(), paymentTotal);
			throw new InvalidPaymentAmountException(payment.getTransactionId(), payment.getPaymentTotal(),
					"Invalid amount for payment of transaction");
		} else if (!expectedTotal.equals(paymentTotal)) {
			logger.error("Payment mismatch for transaction ID: {}. Expected: {}{}, Actual: {}{}",
					payment.getTransactionId(), expectedTotal, currency, paymentTotal, currency);
			throw new PaymentMismatchException(payment.getTransactionId(), expectedTotal, payment.getPaymentTotal(),
					"Payment amount doesn't match shopping cart total");
		} else {
			logger.info("Payment processed successfully for transaction ID: {}. Total payment: {}{}",
					payment.getTransactionId(), paymentTotal, currency);
			printMessage(payment.getTransactionId(), payment.getPaymentTotal(), currency, payment.getClass().getName());
		}
	}

	private static final void printMessage(String paymentId, Double totalPayment, String currencyPayment,
			String className) {
		logger.debug("Payment ID: {}, Total payment: {}{}, Payment method: {}", paymentId, totalPayment,
				currencyPayment, className);
	}

}