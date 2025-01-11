package com.solvd.onlineshop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.onlineshop.enums.ApparelSize;
import com.solvd.onlineshop.enums.DeliveryCompany;
import com.solvd.onlineshop.enums.DeliveryMethod;
import com.solvd.onlineshop.enums.Gender;
import com.solvd.onlineshop.enums.ProductBrand;
import com.solvd.onlineshop.models.deliveries.Delivery;
import com.solvd.onlineshop.models.orders.Order;
import com.solvd.onlineshop.models.payments.*;
import com.solvd.onlineshop.models.people.clients.UnregisteredClient;
import com.solvd.onlineshop.models.people.employees.Employee;
import com.solvd.onlineshop.models.people.employees.Keyboarder;
import com.solvd.onlineshop.models.people.employees.Packer;
import com.solvd.onlineshop.models.people.employees.Warehouseman;
import com.solvd.onlineshop.models.persondetails.Address;
import com.solvd.onlineshop.models.products.ClothingProduct;
import com.solvd.onlineshop.models.products.ElectronicProduct;
import com.solvd.onlineshop.models.products.Product;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;
import com.solvd.onlineshop.models.warehouses.Warehouse;
import com.solvd.onlineshop.FileProcessor;
import com.solvd.onlineshop.OnlineShop;
import com.solvd.onlineshop.LinkedList;

public class Main {
	private final static Logger logger = LogManager.getLogger(Main.class.getName());
	public static final void main(String[] args) {
		
		OnlineShop shop = new OnlineShop("The best shop");
		Warehouse warehouse = new Warehouse();
		shop.setWarehouse(warehouse);

		// create employees
		LocalDate dateOfBirthTom = LocalDate.of(1990, 5, 1);
		LocalDate dateOfBirthAdam = LocalDate.of(1997, 6, 7);
		LocalDate dateOfBirthJohn = LocalDate.of(1992, 6, 7);
		Employee warehousemanTom = new Warehouseman("Tom", "Ron", "TomRon@email.com", dateOfBirthTom);
		Packer packerAdam = new Packer("Adam", "Big", "AdamBig@email.com", dateOfBirthAdam);
		Keyboarder keyboarderJohn = new Keyboarder("John", "Sky", "JohnSky@email.com", dateOfBirthJohn, "123#KB");

		// adding employees
		List<Employee> newEmployees = new ArrayList<>();
		newEmployees.add(warehousemanTom);
		newEmployees.add(packerAdam);
		shop.addEmployee(newEmployees);
		shop.addKeyboarderEmployee(keyboarderJohn);
		
	
		// login process
		String inputEmail = null;
		String inputPassword = null;

		try (Scanner scanner = new Scanner(System.in)) {
			logger.info("Input email");
			inputEmail = scanner.nextLine();
			logger.info("Input password");
			inputPassword = scanner.nextLine();
		} catch (Exception e) {
			logger.error("An error occurred: " + e.getMessage());
		
		}

		// create products
		ElectronicProduct laptop = new ElectronicProduct(ProductBrand.LENOVO, "Legion", 4000.99, "Gaming Laptop", "black",
				"laptop", 500, "34C", true, true, 12);

		Product smartphone = new ElectronicProduct(ProductBrand.SAMSUNG, "Galaxy S24 ", 4524.99, "Fast smartphone", "black",
				"smartphone", 50, "LL1", true, true, 18);

		ClothingProduct tShirt = new ClothingProduct(ProductBrand.NIKE, "Nike Sportswear Club", 99.99, "Men's T-shirt", "White",
				"T-shirt", ApparelSize.MEDIUM, Gender.MALE, "Cotton", "Summer");

		Product trousers = new ClothingProduct(ProductBrand.NIKE, "NikeTech", 39.9, "Men's pants", "grey", "trousers", ApparelSize.LARGE, Gender.MALE,
				"Cotton", "Autumn");

		shop.addProduct(trousers);
		shop.addProduct(tShirt);
		shop.addProduct(smartphone);
		shop.addProduct(laptop);
		
		warehouse.onlyElectronicProduct();
		
		// linkedlist
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(90);
		list.displayForward();
		list.remove(20);
		list.insertAt(1, 50);
		list.displayForward();

		Address unRegClientAddress = new Address("street", "123", 2, "10023", "New York");
		UnregisteredClient unRegClient = new UnregisteredClient("Elton", "John", "EltonJohn@email.com",
				unRegClientAddress, 432432432);
		ShoppingCart cartUnregClient = new ShoppingCart();
		shop.setUnregisteredClient(unRegClient);
		shop.setShoppingCart(cartUnregClient);
		
		shop.addProductToShoppingCart(laptop);
		shop.addProductToShoppingCart(tShirt);

		DeliveryMethod methodOfDelivery = DeliveryMethod.PICKUP_POINT;
		DeliveryCompany deliveryCompany = DeliveryCompany.INPOST;
		
		shop.sumShoppingCartValue();
		Delivery inPostDelivery = new Delivery(deliveryCompany, methodOfDelivery, "1 day",
				shop.getShoppingCart().getShoppingCartValue());

		String payerDetails = unRegClient.getFirstName() + " " + unRegClient.getLastName();

		shop.setDelivery(inPostDelivery);
		Payment payment = new CreditCardPayment(4100.98, payerDetails, "11234566778", "012");
		Order order = new Order(unRegClient, cartUnregClient, payment, inPostDelivery);
		shop.setOrder(order);
		shop.checkout();
		shop.shipOrder();
		
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.fileTask("input", "results");
		
		
		//reflection
		Class<?> reflectedClass = null;
		try {
			reflectedClass = Class.forName("com.solvd.onlineshop.models.products.ElectronicProduct");
		} catch (ClassNotFoundException e) {
			logger.error(e);
			
		}
		Constructor<?>[] constructors = reflectedClass.getConstructors();
		Field[] fields = reflectedClass.getDeclaredFields();
		Method[] methods = reflectedClass.getDeclaredMethods();
		Arrays.sort(methods, (m1, m2) -> m1.getName().compareTo(m2.getName()));
		
		 logger.debug("Available Constructors:");
         for (Constructor<?> constructor : constructors) {
             logger.debug("Constructor: " + constructor);
             logger.debug("Parameter Types: " + Arrays.toString(constructor.getParameterTypes()));
         }
         
        constructors[1].setAccessible(true);
			Object productInstance = null;
			try {
				productInstance = constructors[0].newInstance(ProductBrand.SAMSUNG, "Galaxy S23 ", 3999.99, "Fast smartphone", "white",
						"smartphone", 50, "LL1", true, true, 18);
			} catch (InstantiationException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			} catch (IllegalArgumentException e) {
				logger.error(e);
			} catch (InvocationTargetException e) {
				logger.error(e);
			}
			
			logger.debug("Available Fields:");
	            for (Field field : fields) {
	                logger.debug("Field: " + field.getName() + ", Type: " + field.getType());
	        }
	            
			fields[1].setAccessible(true);
			try {
				fields[1].set(productInstance, 56);
			} catch (IllegalArgumentException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			}
			
			logger.debug("Available Methods:");
	            for (Method method : methods) {
	                logger.debug("Method: " + method.getName());
	        }
			methods[11].setAccessible(true);
			methods[7].setAccessible(true);
			
			try {
				methods[7].invoke(productInstance,false);
				logger.debug("Invoking method: " + methods[7].getName() + " on " + productInstance);
			} catch (IllegalAccessException e) {
				logger.error(e);
			} catch (InvocationTargetException e) {
				logger.error(e);
			}
			
			try {
				logger.debug("Product Object: " + methods[11].invoke(productInstance));
			} catch (IllegalAccessException e) {
				logger.error(e);
			} catch (InvocationTargetException e) {
				logger.error(e);
			}	
			
	}
}
