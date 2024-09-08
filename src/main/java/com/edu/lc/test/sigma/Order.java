package com.edu.lc.test.sigma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order implements IOrder {

	int id;

	String name;

	List<Category> categories;

	public Order(int id, String name) {
		this.name = name;
		this.id = id;
		this.categories = new ArrayList<>();
	}

	public void addCategory(Category category) {
		if (null != category) {
			categories.add(category);
		}
	}

	public String getMaxProuductPriceValue() {
		List<Product> productsRes = categories.stream().flatMap(category -> category.products.stream())
				.sorted((prod1, prod2) -> {
					double diff = prod2.price - prod1.price;
					if (diff > 0) {
						return 1;
					} else if (diff < 0) {
						return -1;
					} else {
						return prod1.name.compareTo(prod2.name);
					}
				}).limit(1).collect(Collectors.toList());
		return productsRes.get(0).name;
	}

}
