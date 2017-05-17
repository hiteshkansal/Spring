package com.learning;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component	//Default bean id will be class name with 1st character as lower case eg: tennisCoach
@Component("tennisCoach")
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired	//Field injection
	@Qualifier("randomFortuneService")	//tell which implementation of this interface to use.
	private FortuneService fortuneService;
	
	
	
	//define a default constructor
	public TennisCoach(){
		System.out.println("TennisCoach default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doStartup(){
		System.out.println("inside startup method.");
	}
	
	//define my destroy method
	@PreDestroy
	public void doCleanup(){
		System.out.println("inside destroy method.");
	}
	
	/*@Autowired
	public TennisCoach(FortuneService theFS){
		fortuneService = theFS;
	}*/
	
	//creating a setter method for injection
	//Can also be any method for injection. just add @Autowired annotation.
	/*@Autowired
	public void setFortuneService(FortuneService theFS){
		System.out.println("TennisCoach inside setFortuneService()");
		fortuneService = theFS;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
