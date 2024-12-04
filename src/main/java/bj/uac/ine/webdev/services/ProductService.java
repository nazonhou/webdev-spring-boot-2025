package bj.uac.ine.webdev.services;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(CreateProductDto createProductDto);
    List<Product> getProducts();
    Optional<Product> getProduct(Long id);
}
