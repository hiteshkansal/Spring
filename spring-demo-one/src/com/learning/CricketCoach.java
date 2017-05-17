package com.learning;

public class CricketCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	//add new field for email and team
	private String email;
	private String team;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setter email method");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside team setter method");
		this.team = team;
	}

	public CricketCoach(){
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 1 hour on Fieding practice";
	}

	@Override
	public String getDailyFortune() {
		return "Cricket is fun. "+ fortuneService.getFortune();
	}

}
