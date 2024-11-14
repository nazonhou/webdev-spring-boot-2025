package bj.uac.ine.webdev.models;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String color;
    private double price;
    private int quantity;
}
