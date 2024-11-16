package bj.uac.ine.webdev.controllers;

import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }
}
