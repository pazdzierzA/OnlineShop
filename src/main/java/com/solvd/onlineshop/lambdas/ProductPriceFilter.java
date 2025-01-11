package com.solvd.onlineshop.lambdas;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.onlineshop.models.products.Product;


public class ProductPriceFilter {
	private static final Logger logger = LogManager.getLogger(ProductPriceFilter.class);
	
	
	public static void processAndFilterProducts(List<Product> products, Double minPrice, Double maxPrice) {
        ProductFilter<Product> priceFilter = (min, max, productList) ->
            productList.stream().anyMatch(product -> product.getPrice() >= min && product.getPrice() <= max);

       // stream & filter & forEach
        products.stream()
                .filter(product -> priceFilter.test(minPrice, maxPrice, List.of(product)))
                .forEach(product -> logger.info(product.toString())); 
    }
}
