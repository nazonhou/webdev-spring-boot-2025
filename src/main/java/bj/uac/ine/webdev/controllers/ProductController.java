package bj.uac.ine.webdev.controllers;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
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

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDto createProductDto
    ) {
        return productService.updateProduct(id, createProductDto);
    }

    @DeleteMapping("{id}")
    public Product deleteProduct(
            @PathVariable Long id
    ) {
        return productService.deleteProduct(id);
    }

    @GetMapping("filter")
    public List<Product> filterByName(
            @RequestParam String name
    ) {
        return productService.getProductsStartingWith(name);
    }

    @GetMapping("pages")
    public Page<Product> filterByName(
            @RequestParam String name,
            @RequestParam String perPage,
            @RequestParam String page
    ) {
        Pageable pageable = PageRequest.of(
                Integer.valueOf(page),
                Integer.valueOf(perPage),
                Sort.by(Sort.Order.desc("price"))
        );

        return productService.getProductsPageStartingWith(
                name,
                pageable
        );
    }
}
