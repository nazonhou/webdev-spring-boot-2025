package bj.uac.ine.webdev;

import bj.uac.ine.webdev.models.Cart;
import bj.uac.ine.webdev.models.Client;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.CartService;
import bj.uac.ine.webdev.services.PaymentService;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
@Log
public class WebdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdevApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            ProductRepository productRepository,
            CartService cartService
    ) {
        return args -> {
            Product iphone16Black = Product.builder()
                    .name("IPhone 16")
                    .color("Black")
                    .price(1000.0)
                    .quantity(4)
                    .build();

            Product samsungSmartTvGray = Product.builder()
                    .name("Smart TV Samsung")
                    .color("Gray")
                    .price(5000.0)
                    .quantity(2)
                    .build();

            productRepository.addProduct(iphone16Black);
            productRepository.addProduct(samsungSmartTvGray);

            Client client = Client.builder().name("John Doe").phoneNumber("9087865654").build();

            Cart cart = Cart.builder().client(client).build();
            cart.addProduct(iphone16Black, 1);
            cart.addProduct(samsungSmartTvGray, 2);

            cartService.validateCommand(cart);
        };
    }
}
