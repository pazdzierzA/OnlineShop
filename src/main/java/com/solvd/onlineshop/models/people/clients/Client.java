package com.solvd.onlineshop.models.people.clients;

import com.solvd.onlineshop.models.people.Person;
import com.solvd.onlineshop.models.persondetails.Address;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;

public abstract class Client extends Person {

	private String ClientId;
	private Address address;
	private Integer phoneNumber;
	

	public Client() {
	}

	public Client(String firstName, String lastName, String email, Address address, Integer phoneNumber) {
		super(firstName, lastName, email);
		this.ClientId = java.util.UUID.randomUUID().toString();
		this.address = address;
		this.phoneNumber = phoneNumber;
	
	}

	public String getClientId() {
		return ClientId;
	}

	public void setClientId(String clientId) {
		ClientId = clientId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public abstract void buy(ShoppingCart shoppingCart);

	protected abstract String message();

	@Override
	public String toString() {
		return "Client [ClientId=" + ClientId + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + "]";
	}

	protected final Integer calculateLoyalityPoints(final ShoppingCart shoppingCart) {
		Double total = shoppingCart.getShoppingCartValue();
		Integer points = (int) (total / 10);
		return points;
	}


}
