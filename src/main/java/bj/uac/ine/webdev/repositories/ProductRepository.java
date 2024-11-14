package bj.uac.ine.webdev.repositories;

import bj.uac.ine.webdev.models.Product;

import java.util.Collection;
import java.util.Map;

public class ProductRepository {
    private Map<Integer, Product> products;

    public void addProduct(Product product) {
        int productId = products.size() + 1;
        product.setId(productId);
        products.put(productId, product);
    }

    public void removeProduct(int productId) {
        products.remove(productId);
    }

    public Collection<Product> findAll() {
        return products.values();
    }

    public Product findById(int productId) {
        return products.get(productId);
    }
}
