package bj.uac.ine.webdev.configurations;

import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.PaymentService;
import bj.uac.ine.webdev.services.ProductService;
import bj.uac.ine.webdev.services.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }
}
