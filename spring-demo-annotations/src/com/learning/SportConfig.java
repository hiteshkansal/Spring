package com.learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.learning")	//comment out for not scanning component
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define method for sad fortune service
	//Function name is bean id
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	
	//define bean for swim coach and inject dependency
	@Bean
	public Coach swimCoach(){
		return new SwimCoach(sadFortuneService());
	}
}
