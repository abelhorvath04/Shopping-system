package org.lecture.Product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    @Test
    public void createProduct() {
        ConcreteProductFactory concreteProductFactory = new ConcreteProductFactory();
        Product laptop = concreteProductFactory.createProduct("electronics", "laptop");
        double testPrice = 1599.99;
        assertEquals(laptop.getPrice(), testPrice);
    }

    @Test
    public void unknownProductTypeThrowsIAEException() {
        ConcreteProductFactory concreteProductFactory = new ConcreteProductFactory();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> concreteProductFactory.createProduct("test","test"));
        assertEquals("Unknown product type: " + "test", exception.getMessage());
    }
}
