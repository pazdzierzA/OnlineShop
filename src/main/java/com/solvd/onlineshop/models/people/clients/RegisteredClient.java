package com.solvd.onlineshop.models.people.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.models.persondetails.Address;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;

public class RegisteredClient extends Client {
	private final static Logger logger = LogManager.getLogger(Client.class.getName());
	private String password;
	private Integer loyalityPoints;
	private Boolean loggedIn;

	public RegisteredClient() {
	}

	public RegisteredClient(String firstName, String lastName, String email, Address address, Integer phoneNumber,
			String password, Integer loyaltyPoints) {
		super(firstName, lastName, email, address, phoneNumber);
		this.password = password;
		this.loyalityPoints = loyaltyPoints;
		this.loggedIn = false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoyaltyPoints() {
		return loyalityPoints;
	}

	public void setLoyaltyPoints(Integer loyaltyPoints) {
		this.loyalityPoints = loyaltyPoints;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	@Override
	protected String message() {
		logger.debug("Returning welcome message for the user.");
	    return "Good to see you again";
	}

	@Override
	public void buy(final ShoppingCart shoppingCart) {
		message();
		Integer newLoyalityPoints = getLoyaltyPoints() + this.calculateLoyalityPoints(shoppingCart);
		setLoyaltyPoints(newLoyalityPoints);
		logger.info("Added {}",getLoyaltyPoints(), " to user account");
		//System.out.println("Added " + getLoyaltyPoints().toString() + "to your account");
	}

	@Override
	public String toString() {
		return "RegisteredClient [password=" + password + ", loyalityPoints=" + loyalityPoints + ", getClientId()="
				+ getClientId() + ", getAddress()=" + getAddress() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + "]";
	}

	/*
	 * public void login(String email, String password) { EmailValidator
	 * emailValidator = new EmailValidator(); PasswordValidator passwordValidator =
	 * new PasswordValidator(); if (emailValidator.isValid(email)) { if
	 * (passwordValidator.isValid(password)) { if
	 * (LoginValidator.validateLogin(this.getEmail(), this.getPassword(), email,
	 * password)) { System.out.println("Login on the account"); message();
	 * setLoggedIn(true); } System.out.println("Invalid login attempt for " +
	 * email); } else System.out.println("Field password is empty!"); } else
	 * System.out.println("Invalid email regex!"); }
	 */

	/*
	 * @Override public void logout() { if (loggedIn) { loggedIn = false;
	 * System.out.println("Log out"); } else {
	 * System.out.println("It wasn't logged in"); } }
	 */

	/*
	 * public final void accessAccountSettings() { if (isLoggedIn())
	 * System.out.println("Access to settings account."); }
	 */

	/*
	 * @Override public Boolean isLoggedIn() { return loggedIn; }
	 */

}