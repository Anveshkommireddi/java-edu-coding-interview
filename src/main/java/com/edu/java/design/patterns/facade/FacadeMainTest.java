package com.edu.java.design.patterns.facade;

public class FacadeMainTest {

	public static void main(String[] args) {

		DVDPlayer dvdPlayer = new DVDPlayer();
		Projector projector = new Projector();
		Screen screen = new Screen();
		SoundSystem soundSystem = new SoundSystem();

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, screen, soundSystem);

		// Watch a movie
		homeTheater.watchMovie("Inception");

		// End the movie
		homeTheater.endMovie();
	}

}
