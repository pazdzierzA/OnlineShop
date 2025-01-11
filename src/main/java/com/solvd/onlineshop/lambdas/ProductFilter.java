package com.solvd.onlineshop.lambdas;

import java.util.List;

@FunctionalInterface
public interface ProductFilter<T> {
	Boolean test(Double minPrice, Double maxPrice, List<T> product);
}