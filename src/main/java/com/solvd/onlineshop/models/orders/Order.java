package com.solvd.onlineshop.models.orders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.enums.OrderStatus;
import com.solvd.onlineshop.exceptions.PaymentProcessingException;
import com.solvd.onlineshop.interfaces.IProcessPayment;
import com.solvd.onlineshop.interfaces.IShoppingCart;
import com.solvd.onlineshop.models.deliveries.Delivery;
import com.solvd.onlineshop.models.payments.Payment;
import com.solvd.onlineshop.models.people.clients.Client;
import com.solvd.onlineshop.processes.ProcessPayment;

public class Order {
	private final static Logger logger = LogManager.getLogger(Order.class.getName());
	private String orderId;
	private Client client;
	private IShoppingCart shoppingCart;
	private Payment payment;
	private Delivery delivery;
	private OrderStatus status;

	public Order() {

	}

	public Order(Client client, IShoppingCart shoppingCart, Payment payment, Delivery delivery) {
		this.orderId = java.util.UUID.randomUUID().toString();
		this.client = client;
		this.shoppingCart = shoppingCart;
		this.payment = payment;
		this.delivery = delivery;
	}
	
	public Order(IShoppingCart shoppingCart) {
		this.orderId = java.util.UUID.randomUUID().toString();
		this.shoppingCart = shoppingCart;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderID) {
		this.orderId = orderID;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
		printStatus();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public final void processOrder(String currency) {
		try {
			IProcessPayment processPayment = new ProcessPayment();
			processPayment.processPayment(payment, shoppingCart, delivery, currency);
			setStatus(OrderStatus.PLACED);
			logger.debug("Processing order:{}", orderId);
			setStatus(OrderStatus.COMPLETED);
		} catch (PaymentProcessingException e) {
			logger.error("Payment is failed, because of '{}'.", e);
			setStatus(OrderStatus.CANCELED);
			logger.debug("Order '{}' is canceled");
		} finally {
			logger.debug("Processing order: '{}' is ended",orderId);
		}
	}

	public final void shipOrder() {
		String formattedMethodDelivery = delivery.getDeliveryMethod().toString().toLowerCase().replace("_", " ");
		logger.debug("Delivering order of number: '{}' by '{}' via '{}'", getOrderId(), delivery.getDeliveryCompany(), formattedMethodDelivery);
		setStatus(OrderStatus.DELIVERING);
	}

	private final void printStatus() {
		logger.info("Status changed");
		logger.debug("Order status changed to {}", getStatus());
	}

}