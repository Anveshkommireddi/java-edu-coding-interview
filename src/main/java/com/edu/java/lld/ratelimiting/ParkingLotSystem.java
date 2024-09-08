package com.edu.java.lld.ratelimiting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum VehicleType {
	MOTORCYCLE, CAR, TRUCK
}

enum ParkingSpotType {
	SMALL, MEDIUM, LARGE
}

abstract class Vehicle {
	private String licensePlate;
	private VehicleType type;

	public Vehicle(String licensePlate, VehicleType type) {
		this.licensePlate = licensePlate;
		this.type = type;
	}

	public VehicleType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(licensePlate, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(licensePlate, other.licensePlate) && type == other.type;
	}
	
}

class Motorcycle extends Vehicle {
	public Motorcycle(String licensePlate) {
		super(licensePlate, VehicleType.MOTORCYCLE);
	}
}

class Car extends Vehicle {
	public Car(String licensePlate) {
		super(licensePlate, VehicleType.CAR);
	}
}

class Truck extends Vehicle {
	public Truck(String licensePlate) {
		super(licensePlate, VehicleType.TRUCK);
	}
}

abstract class ParkingSpot {
	private String id;
	private boolean isOccupied;
	private Vehicle currentVehicle;
	private ParkingSpotType spotType;

	public ParkingSpot(String id, ParkingSpotType spotType) {
		this.id = id;
		this.spotType = spotType;
		this.isOccupied = false;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.currentVehicle = vehicle;
		this.isOccupied = true;
	}

	public void removeVehicle() {
		this.currentVehicle = null;
		this.isOccupied = false;
	}

	public ParkingSpotType getSpotType() {
		return spotType;
	}
}

class SmallSpot extends ParkingSpot {
	public SmallSpot(String id) {
		super(id, ParkingSpotType.SMALL);
	}
}

class MediumSpot extends ParkingSpot {
	public MediumSpot(String id) {
		super(id, ParkingSpotType.MEDIUM);
	}
}

class LargeSpot extends ParkingSpot {
	public LargeSpot(String id) {
		super(id, ParkingSpotType.LARGE);
	}
}

interface ParkingFeeStrategy {
	double calculateFee(long parkingDuration);
}

class MotorcycleFeeStrategy implements ParkingFeeStrategy {
	public double calculateFee(long parkingDuration) {
		return parkingDuration * 1.0; // Example rate
	}
}

class CarFeeStrategy implements ParkingFeeStrategy {
	public double calculateFee(long parkingDuration) {
		return parkingDuration * 2.0; // Example rate
	}
}

class TruckFeeStrategy implements ParkingFeeStrategy {
	public double calculateFee(long parkingDuration) {
		return parkingDuration * 3.0; // Example rate
	}
}

class ParkingLot {
	private final Map<ParkingSpotType, List<ParkingSpot>> availableSpots;
	private final Map<String, ParkingSpot> occupiedSpots;
	private final Lock lock;

	public ParkingLot() {
		availableSpots = new HashMap<>();
		occupiedSpots = new HashMap<>();
		lock = new ReentrantLock();

		initializeSpots();
	}

	private void initializeSpots() {
		// Initialize parking spots (for example: 10 small, 10 medium, 10 large)
		availableSpots.put(ParkingSpotType.SMALL, new ArrayList<>());
		availableSpots.put(ParkingSpotType.MEDIUM, new ArrayList<>());
		availableSpots.put(ParkingSpotType.LARGE, new ArrayList<>());

		for (int i = 0; i < 10; i++) {
			availableSpots.get(ParkingSpotType.SMALL).add(new SmallSpot("S" + i));
			availableSpots.get(ParkingSpotType.MEDIUM).add(new MediumSpot("M" + i));
			availableSpots.get(ParkingSpotType.LARGE).add(new LargeSpot("L" + i));
		}
	}

	public boolean parkVehicle(Vehicle vehicle) {
		lock.lock();
		try {
			ParkingSpotType requiredSpotType = getSpotTypeForVehicle(vehicle);
			List<ParkingSpot> spots = availableSpots.get(requiredSpotType);
			if (spots != null && !spots.isEmpty()) {
				ParkingSpot spot = spots.remove(0);
				spot.parkVehicle(vehicle);
				occupiedSpots.put(vehicle.getType() + "-" + vehicle.hashCode(), spot);
				return true;
			}
		} finally {
			lock.unlock();
		}
		return false;
	}

	public boolean leaveParkingSpot(Vehicle vehicle) {
		lock.lock();
		try {
			String key = vehicle.getType() + "-" + vehicle.hashCode();
			ParkingSpot spot = occupiedSpots.remove(key);
			if (spot != null) {
				spot.removeVehicle();
				availableSpots.get(spot.getSpotType()).add(spot);
				return true;
			}
		} finally {
			lock.unlock();
		}
		return false;
	}

	private ParkingSpotType getSpotTypeForVehicle(Vehicle vehicle) {
		switch (vehicle.getType()) {
		case MOTORCYCLE:
			return ParkingSpotType.SMALL;
		case CAR:
			return ParkingSpotType.MEDIUM;
		case TRUCK:
			return ParkingSpotType.LARGE;
		default:
			throw new IllegalArgumentException("Unknown vehicle type");
		}
	}
}

public class ParkingLotSystem {
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();

		Vehicle motorcycle = new Motorcycle("MOTO-123");
		Vehicle car = new Car("CAR-456");
		Vehicle truck = new Truck("TRUCK-789");

		System.out.println("Parking motorcycle: " + parkingLot.parkVehicle(motorcycle)); // true
		System.out.println("Parking car: " + parkingLot.parkVehicle(car)); // true
		System.out.println("Parking truck: " + parkingLot.parkVehicle(truck)); // true

		System.out.println("Leaving parking spot for car: " + parkingLot.leaveParkingSpot(car)); // true
	}
}
