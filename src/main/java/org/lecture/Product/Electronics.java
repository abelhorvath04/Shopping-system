package org.lecture.Product;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Electronics implements Product{
    private String category;
    private double price;

    public Electronics(String category, double price) {
        this.category = category;
        this.price = price;
    }
    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
