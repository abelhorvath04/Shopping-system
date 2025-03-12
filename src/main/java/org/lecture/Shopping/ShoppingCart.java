package org.lecture.Shopping;

import lombok.ToString;
import org.lecture.Product.Product;

import java.util.List;

@ToString
public class ShoppingCart {
    public static void addItem(List<Product> products, Product product) {
        products.add(product);
    }

    public void removeItem(List<Product> products, Product product) {
        products.remove(product);
    }

    public void displayItems(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
