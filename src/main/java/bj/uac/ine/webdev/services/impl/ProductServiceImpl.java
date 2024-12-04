package bj.uac.ine.webdev.services.impl;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(CreateProductDto createProductDto) {
        Product product = Product.builder()
                .name(createProductDto.name())
                .price(createProductDto.price())
                .quantity(createProductDto.quantity())
                .color(createProductDto.color())
                .build();

        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

}
