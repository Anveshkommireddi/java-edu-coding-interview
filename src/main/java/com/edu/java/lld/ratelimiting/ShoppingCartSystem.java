package com.edu.java.lld.ratelimiting;

import java.util.ArrayList;
import java.util.List;

//Class representing an Item in the store
class Item {
	private String id;
	private String name;
	private double price;

	public Item(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " (Price: $" + price + ")";
	}
}

//Class representing an item in the cart
class CartItem {
	private Item item;
	private int quantity;

	public CartItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return item.getPrice() * quantity;
	}
}

//Interface for different types of discounts
interface Discount {
	double applyDiscount(double total);
}

//Concrete discount class for a percentage discount
class PercentageDiscount implements Discount {
	private double percentage;

	public PercentageDiscount(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public double applyDiscount(double total) {
		return total * (1 - percentage / 100);
	}
}

//Cart class implementing the Composite pattern to manage cart items and discounts
class Cart {
	private List<CartItem> items = new ArrayList<>();
	private List<Discount> discounts = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	// Add item to the cart
	public void addItem(Item item, int quantity) {
		for (CartItem cartItem : items) {
			if (cartItem.getItem().getId().equals(item.getId())) {
				cartItem = new CartItem(cartItem.getItem(), cartItem.getQuantity() + quantity);
				notifyObservers();
				return;
			}
		}
		items.add(new CartItem(item, quantity));
		notifyObservers();
	}

	// Remove item from the cart
	public void removeItem(String itemId) {
		items.removeIf(cartItem -> cartItem.getItem().getId().equals(itemId));
		notifyObservers();
	}

	// Apply a discount to the cart
	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}

	// Calculate total price after applying discounts
	public double calculateTotalPrice() {
		double total = 0.0;
		for (CartItem cartItem : items) {
			total += cartItem.getTotalPrice();
		}
		for (Discount discount : discounts) {
			total = discount.applyDiscount(total);
		}
		return total;
	}

	// Observer pattern to notify changes in the cart
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Cart Items:\n");
		for (CartItem cartItem : items) {
			sb.append(cartItem.getItem()).append(" x ").append(cartItem.getQuantity()).append("\n");
		}
		sb.append("Total Price: $").append(calculateTotalPrice()).append("\n");
		return sb.toString();
	}
}

//Observer interface to get notified on cart changes
interface Observer {
	void update();
}

//Concrete observer class
class CartObserver implements Observer {
	@Override
	public void update() {
		System.out.println("Cart has been updated.");
	}
}

//Main class to demonstrate the functionality
public class ShoppingCartSystem {
	public static void main(String[] args) {
		Cart cart = new Cart();
		Observer observer = new CartObserver();
		cart.addObserver(observer);

		Item item1 = new Item("1", "Laptop", 1000.0);
		Item item2 = new Item("2", "Smartphone", 500.0);

		cart.addItem(item1, 1);
		cart.addItem(item2, 2);

		System.out.println(cart);

		Discount discount = new PercentageDiscount(10);
		cart.addDiscount(discount);

		System.out.println("After applying discount:");
		System.out.println(cart);

		cart.removeItem("1");
		System.out.println("After removing item:");
		System.out.println(cart);
	}
}
