package bj.uac.ine.webdev.configurations;

import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.CartService;
import bj.uac.ine.webdev.services.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {
    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public CartService cartService(ProductRepository productRepository,
                                   PaymentService paymentService
    ) {
        return new CartService(productRepository, paymentService);
    }
}
