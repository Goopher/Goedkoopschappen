package nl.goedkoopschappen.goedkoopschappen;

import javafx.application.Application;
import nl.goedkoopschappen.goedkoopschappen.dao.IProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class GoedkoopschappenApplication {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private String query;


	public static void main(String[] args) {
		SpringApplication.run(GoedkoopschappenApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(IProductDAO repository) {
		return (args) -> {
			// save a couple of customers

			// fetch all products
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Product product : repository.findByProductNameContaining("chocola")) {
				log.info(product.toString());
			}
			log.info("");
		};
	}
}
