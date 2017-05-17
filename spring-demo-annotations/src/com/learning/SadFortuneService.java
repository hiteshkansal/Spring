package com.learning;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad Day!!!";
	}

}
