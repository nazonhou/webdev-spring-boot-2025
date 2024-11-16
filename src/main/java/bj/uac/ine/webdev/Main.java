package bj.uac.ine.webdev;

import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;

import java.util.Collection;

@Log
public class Main implements CommandLineRunner {
    private ProductRepository productRepository;

    public Main(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

        Collection<Product> products = productRepository.findAll();

        for (Product product : products) {
            log.info(product.toString());
        }
    }
}
