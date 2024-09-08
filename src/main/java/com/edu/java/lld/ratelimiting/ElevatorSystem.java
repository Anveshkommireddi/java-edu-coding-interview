package com.edu.java.lld.ratelimiting;

import java.util.*;

enum Direction {
	UP, DOWN, NONE
}

enum ElevatorStatus {
	MOVING, STOPPED, IDLE
}

class Request {
	private int floor;
	private Direction direction;

	public Request(int floor, Direction direction) {
		this.floor = floor;
		this.direction = direction;
	}

	public int getFloor() {
		return floor;
	}

	public Direction getDirection() {
		return direction;
	}
}

class Elevator {
	private int id;
	private int currentFloor;
	private Direction direction;
	private ElevatorStatus status;

	public Elevator(int id) {
		this.id = id;
		this.currentFloor = 0; // Start from ground floor
		this.direction = Direction.NONE;
		this.status = ElevatorStatus.IDLE;
	}

	public void moveToFloor(int floor) {
		if (floor > currentFloor) {
			direction = Direction.UP;
		} else if (floor < currentFloor) {
			direction = Direction.DOWN;
		} else {
			direction = Direction.NONE;
		}
		status = ElevatorStatus.MOVING;
		// Simulate moving to the floor
		currentFloor = floor;
		status = ElevatorStatus.STOPPED;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public ElevatorStatus getStatus() {
		return status;
	}

	public void setStatus(ElevatorStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Elevator " + id + " at floor " + currentFloor + " moving " + direction;
	}
}

interface ElevatorStrategy {
	Elevator selectElevator(List<Elevator> elevators, Request request);
}

class NearestElevatorStrategy implements ElevatorStrategy {
	@Override
	public Elevator selectElevator(List<Elevator> elevators, Request request) {
		Elevator selectedElevator = null;
		int minDistance = Integer.MAX_VALUE;
		for (Elevator elevator : elevators) {
			int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
			if (distance < minDistance && (elevator.getStatus() == ElevatorStatus.IDLE
					|| elevator.getDirection() == request.getDirection())) {
				minDistance = distance;
				selectedElevator = elevator;
			}
		}
		return selectedElevator;
	}
}

class ElevatorController {
	private List<Elevator> elevators;
	private ElevatorStrategy strategy;

	public ElevatorController(int numberOfElevators, ElevatorStrategy strategy) {
		this.elevators = new ArrayList<>();
		this.strategy = strategy;
		for (int i = 1; i <= numberOfElevators; i++) {
			elevators.add(new Elevator(i));
		}
	}

	public void handleRequest(Request request) {
		Elevator elevator = strategy.selectElevator(elevators, request);
		if (elevator != null) {
			elevator.moveToFloor(request.getFloor());
			System.out.println("Elevator " + elevator + " assigned to floor " + request.getFloor());
		} else {
			System.out.println("No elevator available for the request at floor " + request.getFloor());
		}
	}

	public void printElevatorStatuses() {
		for (Elevator elevator : elevators) {
			System.out.println(elevator);
		}
	}
}

public class ElevatorSystem {
	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(3, new NearestElevatorStrategy());

		// Simulating requests
		controller.handleRequest(new Request(3, Direction.UP));
		controller.handleRequest(new Request(5, Direction.DOWN));
		controller.handleRequest(new Request(1, Direction.UP));

		// Print the status of all elevators
		controller.printElevatorStatuses();
	}
}
