package com.solvd.onlineshop.lambdas;

import java.util.List;

@FunctionalInterface
public interface CartTotalCalculator<T> {
	Double calculateTotal(List<T> items);
}
