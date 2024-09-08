package com.edu.java.lld.ratelimiting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

enum SeatStatus {
	AVAILABLE, BOOKED
}

class Seat {
	private int seatNumber;
	private SeatStatus status;

	public Seat(int seatNumber) {
		this.seatNumber = seatNumber;
		this.status = SeatStatus.AVAILABLE;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}
}

class TrainSchedule {
	private LocalDate date;
	private LocalTime departureTime;
	private List<Seat> seats;

	public TrainSchedule(LocalDate date, LocalTime departureTime, int seatCount) {
		this.date = date;
		this.departureTime = departureTime;
		this.seats = new ArrayList<>();
		for (int i = 1; i <= seatCount; i++) {
			seats.add(new Seat(i));
		}
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public Seat getAvailableSeat() {
		for (Seat seat : seats) {
			if (seat.getStatus() == SeatStatus.AVAILABLE) {
				return seat;
			}
		}
		return null;
	}
}

class Train {
	private int trainNumber;
	private String trainName;
	private List<TrainSchedule> schedules;

	public Train(int trainNumber, String trainName) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.schedules = new ArrayList<>();
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public List<TrainSchedule> getSchedules() {
		return schedules;
	}

	public void addSchedule(TrainSchedule schedule) {
		schedules.add(schedule);
	}

	public TrainSchedule getSchedule(LocalDate date, LocalTime time) {
		for (TrainSchedule schedule : schedules) {
			if (schedule.getDate().equals(date) && schedule.getDepartureTime().equals(time)) {
				return schedule;
			}
		}
		return null;
	}
}

class Passenger {
	private String name;
	private int age;
	private String contact;

	public Passenger(String name, int age, String contact) {
		this.name = name;
		this.age = age;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getContact() {
		return contact;
	}
}

class Booking {
	private static int bookingCounter = 1;
	private int bookingId;
	private Passenger passenger;
	private Train train;
	private TrainSchedule schedule;
	private Seat seat;
	private boolean isCancelled;

	public Booking(Passenger passenger, Train train, TrainSchedule schedule, Seat seat) {
		this.bookingId = bookingCounter++;
		this.passenger = passenger;
		this.train = train;
		this.schedule = schedule;
		this.seat = seat;
		this.isCancelled = false;
	}

	public int getBookingId() {
		return bookingId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public Train getTrain() {
		return train;
	}

	public TrainSchedule getSchedule() {
		return schedule;
	}

	public Seat getSeat() {
		return seat;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void cancelBooking() {
		isCancelled = true;
		seat.setStatus(SeatStatus.AVAILABLE);
	}
}

class RailwayReservationSystem {
	private static RailwayReservationSystem instance;
	private List<Train> trains;
	private Map<Integer, Booking> bookings;

	private RailwayReservationSystem() {
		trains = new ArrayList<>();
		bookings = new HashMap<>();
	}

	public static synchronized RailwayReservationSystem getInstance() {
		if (instance == null) {
			instance = new RailwayReservationSystem();
		}
		return instance;
	}

	public void addTrain(Train train) {
		trains.add(train);
	}

	public Train getTrain(int trainNumber) {
		for (Train train : trains) {
			if (train.getTrainNumber() == trainNumber) {
				return train;
			}
		}
		return null;
	}

	public Booking bookTicket(Passenger passenger, int trainNumber, LocalDate date, LocalTime time) {
		Train train = getTrain(trainNumber);
		if (train == null) {
			System.out.println("Train not found.");
			return null;
		}

		TrainSchedule schedule = train.getSchedule(date, time);
		if (schedule == null) {
			System.out.println("Schedule not found for the specified date and time.");
			return null;
		}

		Seat availableSeat = schedule.getAvailableSeat();
		if (availableSeat == null) {
			System.out.println("No available seats.");
			return null;
		}

		availableSeat.setStatus(SeatStatus.BOOKED);
		Booking booking = new Booking(passenger, train, schedule, availableSeat);
		bookings.put(booking.getBookingId(), booking);
		return booking;
	}

	public void cancelTicket(int bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null && !booking.isCancelled()) {
			booking.cancelBooking();
			System.out.println("Booking " + bookingId + " has been cancelled.");
		} else {
			System.out.println("Booking not found or already cancelled.");
		}
	}

	public void printBookingDetails(int bookingId) {
		Booking booking = bookings.get(bookingId);
		if (booking != null) {
			System.out.println("Booking ID: " + booking.getBookingId());
			System.out.println("Passenger: " + booking.getPassenger().getName());
			System.out.println("Train: " + booking.getTrain().getTrainName());
			System.out.println("Departure: " + booking.getSchedule().getDate() + " at "
					+ booking.getSchedule().getDepartureTime());
			System.out.println("Seat: " + booking.getSeat().getSeatNumber());
			System.out.println("Cancelled: " + booking.isCancelled());
		} else {
			System.out.println("Booking not found.");
		}
	}
}

public class RailwayReservationSystemTest {
	public static void main(String[] args) {
		RailwayReservationSystem system = RailwayReservationSystem.getInstance();

		// Adding trains and schedules
		Train train1 = new Train(101, "Express Train");
		train1.addSchedule(new TrainSchedule(LocalDate.of(2024, 9, 1), LocalTime.of(10, 0), 10));
		train1.addSchedule(new TrainSchedule(LocalDate.of(2024, 9, 2), LocalTime.of(10, 0), 10));
		system.addTrain(train1);

		// Booking tickets
		Passenger passenger1 = new Passenger("John Doe", 30, "1234567890");
		Booking booking1 = system.bookTicket(passenger1, 101, LocalDate.of(2024, 9, 1), LocalTime.of(10, 0));
		if (booking1 != null) {
			system.printBookingDetails(booking1.getBookingId());
		}

		// Cancelling ticket
		system.cancelTicket(booking1.getBookingId());
		system.printBookingDetails(booking1.getBookingId());
	}
}
