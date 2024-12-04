package bj.uac.ine.webdev.services;

import bj.uac.ine.webdev.models.Cart;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartService {
    private final PaymentService paymentService;

    public void validateCommand(Cart cart) {
        double totalAmount = 0;

//        for (Integer productId : cart.getProducts().keySet()) {
//            totalAmount += cart.getProducts().get(productId) *
//                    productRepository.findById(productId).getPrice();
//        }

        paymentService.pay(totalAmount, cart.getClient().getPhoneNumber());
    }
}
