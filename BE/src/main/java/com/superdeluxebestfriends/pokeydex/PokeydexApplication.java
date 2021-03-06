package com.superdeluxebestfriends.pokeydex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
@ComponentScan("com.superdeluxebestfriends.pokeydex.dao")
public class PokeydexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeydexApplication.class, args);
	}

}
