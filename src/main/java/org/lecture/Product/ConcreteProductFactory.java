package org.lecture.Product;

public class ConcreteProductFactory extends ProductFactory {
    @Override
    public Product createProduct(String productType, String category) {
        double price = 0.0;

        switch (category) {
            case "smartphone" -> price = 699.99;
            case "laptop" -> price = 1599.99;
            case "shirt" -> price = 39.99;
            case "pant" -> price = 79.99;
            case "novel" -> price = 29.99;
            case "textbook" -> price = 29.99;
        }

        switch (productType) {
            case "electronics":
                return new Electronics(category, price);
            case "clothing":
                return new Clothing(category, price);
            case "books":
                return new Books(category, price);
            default:
                throw new IllegalArgumentException("Unknown product type: " + productType);
        }
    }
}
