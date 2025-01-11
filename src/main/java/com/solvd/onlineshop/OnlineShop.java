package com.solvd.onlineshop;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.onlineshop.discounts.DiscountManager;
import com.solvd.onlineshop.discounts.ProductDiscount;
import com.solvd.onlineshop.discounts.ShoppingCartDiscount;
import com.solvd.onlineshop.models.deliveries.Delivery;
import com.solvd.onlineshop.models.orders.Order;
import com.solvd.onlineshop.models.people.clients.RegisteredClient;
import com.solvd.onlineshop.models.people.clients.UnregisteredClient;
import com.solvd.onlineshop.models.people.employees.Employee;
import com.solvd.onlineshop.models.people.employees.Keyboarder;
import com.solvd.onlineshop.models.people.employees.Packer;
import com.solvd.onlineshop.models.people.employees.Warehouseman;
import com.solvd.onlineshop.models.products.Product;
import com.solvd.onlineshop.models.shoppingcarts.ShoppingCart;
import com.solvd.onlineshop.models.warehouses.Warehouse;

public class OnlineShop {
	
	public final static String CURRENCY = "$";
	private static final Logger logger = LogManager.getLogger(OnlineShop.class);
	private String shopName;
	private Warehouse warehouse;
	private ShoppingCart shoppingCart;
	private Order order;
	private Delivery delivery;
	private UnregisteredClient unregisteredClient;
	private RegisteredClient registeredClient;

	static {
		logger.info("Online Shop");
	}

	public OnlineShop() {

	}

	public OnlineShop(String shopName) {
		this.shopName = shopName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;

	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void addProduct(Product product) {
		warehouse.addProduct(product);
	}

	public void addKeyboarderEmployee(Keyboarder keyboarder) {
		warehouse.addEmployee(keyboarder);
	}

	public void addWarehousemanEmployee(Warehouseman warehouseman) {
		warehouse.addEmployee(warehouseman);
	}

	public void addPackerEmployee(Packer packer) {
		warehouse.addEmployee(packer);
	}

	public void addEmployee(List<Employee> employees) {
		warehouse.setEmployees(employees);
	}

	public void addProductToShoppingCart(Product product) {
		String productId = product.getProductID();
		Product addedProduct = warehouse.getProduct(productId);
		shoppingCart.addProduct(addedProduct);
	}

	public void sumShoppingCartValue() {
		shoppingCart.sumToTotal();
	}
	public void checkout() {
		if (unregisteredClient == null) {
			registeredClient.getLoggedIn();
			registeredClient.buy(shoppingCart);
		}
		if (registeredClient == null)
			unregisteredClient.buy(shoppingCart);
		order.processOrder(CURRENCY);
		List<Product> cartProducts = shoppingCart.getProducts();
		for (Product cartProduct : cartProducts) {
			warehouse.removeProduct(cartProduct);
		}
		shoppingCart.clearShoopingCart();
	}

	public void applyCartDiscount() {
		DiscountManager<ShoppingCart> cartDiscountManager = new DiscountManager<>(new ShoppingCartDiscount());
		cartDiscountManager.applyDiscount(shoppingCart);
	}

	public void applyProductDiscount(Product product, double discountPercentage) {
		DiscountManager<Product> productDiscountManager = new DiscountManager<>(
				new ProductDiscount(discountPercentage));
		productDiscountManager.applyDiscount(product);
	}

	public void shipOrder() {
		order.shipOrder();
	}

	public void setOrder(Order order) {
		this.order = order;

	}

	public UnregisteredClient getUnregisteredClient() {
		return unregisteredClient;
	}

	public void setUnregisteredClient(UnregisteredClient unregisteredClient) {
		this.unregisteredClient = unregisteredClient;
	}

	public RegisteredClient getRegisteredClient() {
		return registeredClient;
	}

	public void setRegisteredClient(RegisteredClient registeredClient) {
		this.registeredClient = registeredClient;
	}

}
