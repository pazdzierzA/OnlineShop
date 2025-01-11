package com.solvd.onlineshop.lambdas;

@FunctionalInterface
public interface ProductValidator<T> {
	  Boolean validate(T product);
}

