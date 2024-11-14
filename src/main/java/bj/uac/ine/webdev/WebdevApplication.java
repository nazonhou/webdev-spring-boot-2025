package bj.uac.ine.webdev;

import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.CartService;
import bj.uac.ine.webdev.services.PaymentService;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class WebdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdevApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Application start");
        };
    }
}
