package bj.uac.ine.webdev;

import bj.uac.ine.webdev.models.Cart;
import bj.uac.ine.webdev.models.Client;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.services.CartService;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class WebdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdevApplication.class, args);
    }

}
