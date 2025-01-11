package com.solvd.onlineshop.models.warehouses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.models.people.employees.Employee;
import com.solvd.onlineshop.models.products.ElectronicProduct;
import com.solvd.onlineshop.models.products.Product;

public class Warehouse {
	private final static Logger logger = LogManager.getLogger(Warehouse.class.getName());
	private List<Product> products = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();

	public Warehouse() {
	}

	public Warehouse(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public <T extends Employee> void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public <T extends Employee> void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public <T extends Product> void addProduct(T product) {
		products.add(product);
	}

	public <T extends Product> void removeProduct(T product) {
		products.remove(product);
	}

	public Product getProduct(String id) {
		return products.stream().filter(product -> product.getProductID().equals(id)).findFirst()
				.orElseThrow(() -> new NoSuchElementException("No product found with ID: " + id));
	}

	public void showProductsByName() {
		// lambda function consumer
		Consumer<Product> showProductName = product -> logger.debug(product.getName());
		products.forEach(showProductName);
		}
	
	public Integer countProductsByCategory(String productCategory) {
		// lambda function supplier
		// stream & filter
	    Supplier<Long> count = () -> products.stream()
	                                         .filter(product -> product.getCategory().equalsIgnoreCase(productCategory))
	                                         .count();
	    return count.get().intValue();
	}
	
	public void showProductsBelowPrice(Double maxPrice) {
		//lambda fuction predicate
	    Predicate<Product> isBelowPrice = product -> product.getPrice() <= maxPrice;
	    
	    // stream & filter & forEach
	    products.stream()
	            .filter(isBelowPrice)
	            .forEach(product -> logger.debug("Product: " + product.getName() + ", Price: $" + product.getPrice()));
	}
	
	public void showEmployees() {
		//lambda function BiConsumer
		BiConsumer<String,String> employeeData = (employeeFirstName, employeeLastName) -> logger.debug(employeeFirstName + employeeLastName);
		employees.forEach(employee -> employeeData.accept(employee.getFirstName(), employee.getLastName()));
	}
	
	public void productNameAndPrice() {
	// stream & map & collect
		Map<String,Double> productMap = products.stream().collect(Collectors.toMap(Product::getName, Product::getPrice));
		logger.debug(productMap);

	}
	
	public void sortProductDescOrder() {
	// stream & collect & forEach
		List<Product> listProduct = products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
		listProduct.forEach(product -> logger.debug("Product: " + product.getName() + ", Price: " + product.getPrice()+ " $" ));
	}
	
	public void onlyElectronicProduct() {
	// stream & filter & collection & foreach
	List<Product> electronicProducts = products.stream()
            .filter(product -> product.getClass().equals(ElectronicProduct.class))
            .collect(Collectors.toList());
	electronicProducts.forEach( product -> logger.debug("Product: " + product.getName() + " " + product.getBrand()));
	}
}