package bj.uac.ine.webdev.controllers;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Collection<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto createProductDto) {
        return new ResponseEntity<>(productService.createProduct(createProductDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        Optional<Product> product = productService.getProduct(productId);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

//    @GetMapping("/filter")
//    @ResponseStatus(HttpStatus.OK)
//    public Collection<Product> filterProducts(@RequestParam String query) {
//        return productRepository.filterProducts(query);
//    }
//
//    @PutMapping("/{id}")
//    public Product updateProduct(
//            @PathVariable int id,
//            @RequestBody CreateProductDto createProductDto
//    ) {
//        return productRepository.updateProduct(id, createProductDto);
//    }
//
//    @DeleteMapping("{id}")
//    public Product removeProduct(@PathVariable int id){
//        return productRepository.removeProduct(id);
//    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, String>> handleHttpClientErrorException(
            HttpClientErrorException exception
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }
}
