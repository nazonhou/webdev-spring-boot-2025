package bj.uac.ine.webdev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class Cart {
    private final Map<Integer, Integer> products = new HashMap<>();
    private Client client;

    public void addProduct(Product product, int quantity) {
        this.products.put(product.getId(), quantity);
    }

    public void removeProduct(Product product) {
        this.products.remove(product.getId());
    }
}
