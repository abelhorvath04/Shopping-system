package org.lecture.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(String productType, String category);
}
