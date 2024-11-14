package bj.uac.ine.webdev.models;

import lombok.Getter;

import java.util.Map;

@Getter
public class Cart {
    private Map<Integer, Integer> products;
    private Client client;

    public void addProduct(Product product, int quantity) {
        this.products.put(product.getId(), quantity);
    }

    public void removeProduct(Product product) {
        this.products.remove(product.getId());
    }
}
