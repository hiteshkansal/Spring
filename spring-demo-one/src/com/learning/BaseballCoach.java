package com.learning;

public class BaseballCoach implements Coach {

	public BaseballCoach() {

	}

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFS) {
		fortuneService = theFS;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune services to get fortune
		return fortuneService.getFortune();
	}
}
