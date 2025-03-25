	package com.bootReact.Spring_Boot_and_React_CRUD_Operation;

	import io.github.cdimascio.dotenv.Dotenv;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	@SpringBootApplication
	public class SpringBootAndReactCrudOperationApplication {

		public static void main(String[] args) {
//
//			Dotenv dotenv = Dotenv.load(); // Loads the .env file
//			dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
			SpringApplication.run(SpringBootAndReactCrudOperationApplication.class, args);
		}

	}
