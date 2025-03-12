package org.lecture.Shipping;

import lombok.Getter;

@Getter
public class FreeShipping implements ShippingStrategy{
    String type;
    double price;

    public FreeShipping(String type, double price) {
        this.type = type;
        this.price = price;
    }
    @Override
    public void ship(String type, double price) {
        System.out.println("The type for shipping is: " + type + " - " + price + " - Above 10 pieces there is no charge");
    }

}
