package bj.uac.ine.webdev.services;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(CreateProductDto createProductDto);

    List<Product> getProducts();

    Optional<Product> getProduct(Long id);

    Product updateProduct(Long id, CreateProductDto createProductDto);

    Product deleteProduct(Long id);

    List<Product> getProductsStartingWith(String name);

    Page<Product> getProductsPageStartingWith(String name, Pageable pageable);
}
