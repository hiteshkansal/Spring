package com.learning;

public class TrackCoach implements Coach {

	public TrackCoach() {

	}

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public TrackCoach(FortuneService theFS) {
		this.fortuneService = theFS;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " + fortuneService.getFortune();
	}

	// add init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside startup method");
	}

	// add destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside cleanup method");
	}
}
