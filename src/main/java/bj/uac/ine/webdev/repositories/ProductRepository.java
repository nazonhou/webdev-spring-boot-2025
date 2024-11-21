package bj.uac.ine.webdev.repositories;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();

    public Product addProduct(Product product) {
        int productId = products.size() + 1;
        product.setId(productId);
        products.put(productId, product);
        return product;
    }

    public Product removeProduct(int productId) {
        Product product = products.get(productId);

        if (product == null) {
            throw HttpClientErrorException.create(
                    "Product with id " + productId + " not found",
                    HttpStatusCode.valueOf(404),
                    null,
                    null,
                    null,
                    null
            );
        }

        products.remove(productId);

        return product;
    }

    public Collection<Product> findAll() {
        return products.values();
    }

    public Product findById(int productId) {
        return products.get(productId);
    }

    public Collection<Product> filterProducts(String query) {
        return products.values()
                .stream().filter(product -> product.getName().contains(query))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Product updateProduct(int productId, CreateProductDto createProductDto) {
        Product product = products.get(productId);

        if (product == null) {
            throw HttpClientErrorException.create(
                    "Product with id " + productId + " not found",
                    HttpStatusCode.valueOf(404),
                    null,
                    null,
                    null,
                    null
            );
        }

        product.setName(createProductDto.getName());
        product.setColor(createProductDto.getColor());
        product.setPrice(createProductDto.getPrice());
        product.setQuantity(createProductDto.getQuantity());

        return products.put(productId, product);
    }
}
