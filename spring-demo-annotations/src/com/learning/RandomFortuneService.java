package com.learning;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] fortunes = {"You are going to be Lucky!", "You are going to be UnLucky", "Usual day"};
	
	//create a random number generator
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		String fortune = fortunes[rand.nextInt(fortunes.length)]; 
		return fortune;
	}

}
