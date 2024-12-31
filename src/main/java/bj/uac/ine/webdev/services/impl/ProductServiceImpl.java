package bj.uac.ine.webdev.services.impl;

import bj.uac.ine.webdev.dtos.CreateProductDto;
import bj.uac.ine.webdev.exceptions.EntityNotFoundException;
import bj.uac.ine.webdev.models.Product;
import bj.uac.ine.webdev.repositories.ProductRepository;
import bj.uac.ine.webdev.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

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
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new EntityNotFoundException(
                    "Product",
                    "id",
                    id.toString()
            );
        }

        return product.get();
    }

    @Override
    public Product updateProduct(Long id, CreateProductDto createProductDto) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new HttpClientErrorException("Product with ID " + id + " does not exists", HttpStatus.NOT_FOUND, "Not found", null, null, null);
        }

        product.get().setQuantity(createProductDto.quantity());
        product.get().setName(createProductDto.name());
        product.get().setPrice(createProductDto.price());
        product.get().setColor(createProductDto.color());

        return productRepository.save(product.get());
    }

    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new HttpClientErrorException("Product with ID " + id + " does not exists", HttpStatus.NOT_FOUND, "Not found", null, null, null);
        }

        productRepository.delete(product.get());

        return product.get();
    }

    @Override
    public List<Product> getProductsStartingWith(String name) {
        return productRepository.getProductsByNameStartingWithOrderByPriceDesc(name, "blue", Sort.by(Sort.Order.desc("price")));
    }

    @Override
    public Page<Product> getProductsPageStartingWith(String name, Pageable pageable) {
        return productRepository.getProductsPageByNameStartingWithOrderByPriceDesc(name, "blue", pageable);
    }

}
