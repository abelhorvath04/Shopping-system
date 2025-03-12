package org.lecture.Shipping;

import lombok.Getter;

@Getter
public class StandardShipping implements ShippingStrategy{
    String type;
    double price;

    public StandardShipping(String type, double price) {
        this.type = type;
        this.price = price;
    }
    @Override
    public void ship(String type, double price) {
        System.out.println("The type for shipping is: " + type + " - " + price + " charge.");
    }
}
