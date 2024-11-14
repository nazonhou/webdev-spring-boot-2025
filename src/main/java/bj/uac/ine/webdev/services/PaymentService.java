package bj.uac.ine.webdev.services;

import lombok.extern.java.Log;

@Log
public class PaymentService {
    public void pay(double amount, String clientPhoneNumber) {
        log.info(clientPhoneNumber + " initiate a payment for $" + amount);
    }
}
