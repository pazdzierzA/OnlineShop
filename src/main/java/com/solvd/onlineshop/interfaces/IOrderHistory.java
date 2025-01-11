package com.solvd.onlineshop.interfaces;

import com.solvd.onlineshop.models.orders.Order;
import com.solvd.onlineshop.models.people.clients.Client;

public interface IOrderHistory {
	public void addOrder(Order order);
	public Order getOrder(Integer id);
	public void deleteOrder(Order order);
	public Order getLast();
	public Order getFirst();
	void displayOrderHistory(Client client);

}
