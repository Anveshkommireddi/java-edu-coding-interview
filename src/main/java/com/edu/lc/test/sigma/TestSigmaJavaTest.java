package com.edu.lc.test.sigma;

public class TestSigmaJavaTest {

	public static void main(String[] args) {
		Product p1 = new Product(1, "prod-1", 22.1);
		Product p2 = new Product(1, "prod-2", 22.2);

		Product p3 = new Product(1, "prod-3", 100.2);
		Product p4 = new Product(1, "prod-4", 220);

		Category c1 = new Category(1, "cat-1");
		Category c2 = new Category(2, "cat-2");

		c1.addProduct(p1);
		c1.addProduct(p2);

		c2.addProduct(p3);
		c2.addProduct(p4);

		Order order = new Order(1, "order-1");
		order.addCategory(c1);
		order.addCategory(c2);

		String res = order.getMaxProuductPriceValue();
		System.out.println(res);

	}

}
