package com.solvd.onlineshop.models.people.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.models.persondetails.Address;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;

public class UnregisteredClient extends Client {
	private final static Logger logger = LogManager.getLogger(UnregisteredClient.class.getName());
	public UnregisteredClient() {
	}

	public UnregisteredClient(String firstName, String lastName, String email, Address address, Integer phoneNumber) {
		super(firstName, lastName, email, address, phoneNumber);
	}

	@Override
	public void buy(final ShoppingCart shoppingCart) {
		message();
		Integer points = this.calculateLoyalityPoints(shoppingCart);
		logger.info("Loyalty points cannot be awarded. Unregistered client attempted to earn points: {}.", points);
		/*System.out
				.println("You don't have account. You can't get your loyality points. If you want add loyalty points: "
						+ points.toString() + ", you have to create account!");*/
	}

	@Override
	public String toString() {
		return "UnregisteredClient [getClientId()=" + getClientId() + ", getAddress()=" + getAddress()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + "]";
	}

	@Override
	protected String message() {
		logger.debug("Unregistered client prompted to create an account.");
	    return "Create an account to enjoy fantastic benefits!";
	}
}
