package org.lecture.Shopping;

import org.junit.jupiter.api.Test;
import org.lecture.Product.ConcreteProductFactory;
import org.lecture.Product.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    public void addItem() {
        List<Product> products = new ArrayList<>();
        ConcreteProductFactory concreteProductFactory = new ConcreteProductFactory();
        Product laptop = concreteProductFactory.createProduct("electronics","laptop");
        Product smartphone = concreteProductFactory.createProduct("electronics","smartphone");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(products, laptop);
        shoppingCart.addItem(products, smartphone);
        assertEquals(products.size(), 2);
    }

    @Test
    public void removeItem() {
        List<Product> products = new ArrayList<>();
        ConcreteProductFactory concreteProductFactory = new ConcreteProductFactory();
        Product laptop = concreteProductFactory.createProduct("electronics","laptop");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(products, laptop);
        shoppingCart.removeItem(products, laptop);
        assertEquals(products.size(), 0);
    }
}