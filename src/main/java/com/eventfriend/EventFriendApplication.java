package com.eventfriend;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventFriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventFriendApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		
		
	}

}
