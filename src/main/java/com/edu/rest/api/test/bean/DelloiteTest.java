package com.edu.rest.api.test.bean;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelloiteTest {
	
	public static void main(String[] args) {
		//*
		//**
		//***
		//**
		//*
		
		//*
		//**
		//**
		//*
//	  2  --(n-1 space)

//	 2 2

//	2 2 2

// 2 2 2 2

//2 2 2 2 2
		

		
		//n -- 5/2 -- 2 (0, 1, 2) (5-3, 5-4)
		int n = 4;
		int mid = n/2;
		for(int idx = 0; idx < n; idx++) {
			if(idx <= mid) {
				for(int starCount = 0; starCount <= idx; starCount++) {
					System.out.print("*");
				}
			} else {
				for(int starCount = 0; starCount < n-idx; starCount++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		//first name - naga 
		//
		int minPrice = 1;
		List<Product> products = Arrays.asList(new Product(), new Product());
		products.stream().filter(product -> product.name.startsWith("naga"))
		                 .filter(product -> product.price >= minPrice);
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		
		                 
	}
	
	

}

class Product  {
	String name;
	int price;
}
