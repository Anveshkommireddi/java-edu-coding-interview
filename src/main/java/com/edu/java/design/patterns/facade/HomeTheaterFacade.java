package com.edu.java.design.patterns.facade;

public class HomeTheaterFacade {

	private DVDPlayer dvdPlayer;
	private Projector projector;
	private Screen screen;
	private SoundSystem soundSystem;

	public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, Screen screen, SoundSystem soundSystem) {
		this.dvdPlayer = dvdPlayer;
		this.projector = projector;
		this.screen = screen;
		this.soundSystem = soundSystem;
	}

	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		screen.up();
		projector.on();
		projector.setInput(dvdPlayer);
		dvdPlayer.on();
		dvdPlayer.play(movie);
		soundSystem.on();
		soundSystem.setVolume(10);
	}

	public void endMovie() {
		System.out.println("Shutting down the home theater...");
		soundSystem.off();
		dvdPlayer.off();
		projector.off();
		screen.down();
	}

	public void increaseVolume() {
		int currentVolume = soundSystem.getVolume();
		soundSystem.setVolume(currentVolume + 5);
		System.out.println("Volume increased to: " + soundSystem.getVolume());
	}

}
