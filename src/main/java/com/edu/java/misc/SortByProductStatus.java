package com.edu.java.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByProductStatus {

	public static void main(String[] args) {

		Product p1 = new Product("P1", "Available");
		Product p2 = new Product("P2", "Not Available");
		Product p3 = new Product("P3", "Not Available");
		Product p4 = new Product("P4", "Partially Available");
		Product p5 = new Product("P5", "Partially Available");
		Product p6 = new Product("P6", "Not Available");
		Product p7 = new Product("P7", "Available");
		Product p8 = new Product("P8", "Not Available");
		Product p9 = new Product("P9", "Partially Available");

		List<Product> productsList = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9);

		Comparator<Product> statusComparator = (product1, product2) -> {
			String status1 = product1.getStatus();
			String status2 = product2.getStatus();
			if (status1.equals("Available") && !status2.equals("Available")) {
				return -1;
			} else if (!status1.equals("Available") && status2.equals("Available")) {
				return 1;
			} else if (status1.equals("Partially Available") && status2.equals("Not Available")) {
				return -1;
			} else if (status1.equals("Not Available") && status2.equals("Partially Available")) {
				return 1;
			} else {
				return status1.compareTo(status2);
			}
		};

		Collections.sort(productsList, statusComparator);

		System.out.println(productsList);

	}

}

class Product {

	private String productName;

	private String status;

	public Product() {
	}

	public Product(String productName, String status) {
		this.productName = productName;
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", status=" + status + "]";
	}
}
