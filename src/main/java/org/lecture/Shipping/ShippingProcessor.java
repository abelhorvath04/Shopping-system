package org.lecture.Shipping;

public class ShippingProcessor {
    private ShippingStrategy shippingStrategy;

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void processShipping(String type, double price) {
        shippingStrategy.ship(type, price);
    }

}
