package com.solvd.onlineshop.models.orders;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.onlineshop.interfaces.IOrderHistory;
import com.solvd.onlineshop.models.people.clients.Client;

public class OrderHistory implements IOrderHistory {
	private final static Logger logger = LogManager.getLogger(OrderHistory.class.getName());
	private LinkedList<Order> orderHistory = new LinkedList<>();

	public OrderHistory() {

	}

	public LinkedList<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(LinkedList<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}

	@Override
	public void addOrder(Order order) {
		orderHistory.add(order);

	}

	@Override
	public Order getOrder(Integer id) {
		return orderHistory.get(id);

	}

	@Override
	public void deleteOrder(Order order) {
		orderHistory.remove();
	}

	@Override
	public void displayOrderHistory(Client client) {
		String customerName= client.getFirstName() + client.getLastName();
		logger.debug("Displaying customer's : {} order history", customerName);
		for (Order order : orderHistory) {
			System.out.println(order);
		}

	}

	@Override
	public Order getLast() {
		return orderHistory.getLast();

	}

	@Override
	public Order getFirst() {
		return orderHistory.getFirst();

	}
}
