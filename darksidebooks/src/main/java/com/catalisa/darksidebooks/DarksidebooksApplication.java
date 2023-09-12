package com.catalisa.darksidebooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DarksidebooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarksidebooksApplication.class, args);
		System.out.println("1234; "+ new BCryptPasswordEncoder().encode("1234"));
		System.out.println("2222; " + new BCryptPasswordEncoder().encode("2222"));
	}

}
