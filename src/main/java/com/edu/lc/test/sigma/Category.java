package com.edu.lc.test.sigma;

import java.util.ArrayList;
import java.util.List;

public class Category implements ICategory {

	int id;

	String name;

	List<Product> products;

	public Category(int id, String name) {
		this.name = name;
		this.id = id;
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		if (null != product) {
			products.add(product);
		}
	}

}
