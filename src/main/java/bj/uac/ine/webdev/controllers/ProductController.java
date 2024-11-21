package bj.uac.ine.webdev.controllers;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto createProductDto) {
        Product product = Product.builder()
                .name(createProductDto.getName())
                .color(createProductDto.getColor())
                .quantity(createProductDto.getQuantity())
                .price(createProductDto.getPrice())
                .build();

        return new ResponseEntity<>(productRepository.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        Product product = productRepository.findById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Product> filterProducts(@RequestParam String query) {
        return productRepository.filterProducts(query);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody CreateProductDto createProductDto
    ) {
        return productRepository.updateProduct(id, createProductDto);
    }

    @DeleteMapping("{id}")
    public Product removeProduct(@PathVariable int id){
        return productRepository.removeProduct(id);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, String>> handleHttpClientErrorException(
            HttpClientErrorException exception
    ){
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }
}
