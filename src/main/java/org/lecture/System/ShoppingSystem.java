package org.lecture.System;

import org.lecture.Product.ConcreteProductFactory;
import org.lecture.Product.Product;
import org.lecture.Shipping.ExpeditedShipping;
import org.lecture.Shipping.FreeShipping;
import org.lecture.Shipping.ShippingProcessor;
import org.lecture.Shipping.StandardShipping;
import org.lecture.Shopping.ShoppingCart;
import org.lecture.Shopping.User;

import java.util.ArrayList;
import java.util.List;

public class ShoppingSystem {

    private static ShoppingSystem instance;
    private static final ConcreteProductFactory concreteProductFactory = new ConcreteProductFactory();
    private static final ShoppingCart shoppingCart = new ShoppingCart();
    private static final ShippingProcessor shippingProcessor = new ShippingProcessor();
    private static final FileReader fileReader = new FileReader();
    private static List<User> users = fileReader.FileReader();
    private static List<Product> products = new ArrayList<>();
    private static ExpeditedShipping expeditedShipping = new ExpeditedShipping("expedited", 35.99);
    private static FreeShipping freeShipping = new FreeShipping("", 0.0);
    private static final StandardShipping standardShipping = new StandardShipping("", 9.99);

    /**
     * ShoppingSystem class to manage the shopping operations including viewing profile, buying products, viewing cart, payment, and removing items from the cart.
     * It is built with Singleton Design Pattern.
     */
    private ShoppingSystem() {

    }

    /**
     * Gets the singleton instance of the ShoppingSystem.
     * @return the singleton instance of ShoppingSystem.
     */
    public static ShoppingSystem getInstance() {
        if (instance == null) {
            instance = new ShoppingSystem();
        }
        return instance;
    }

    /**
     * Views the user's profile. Allows the user to update their data if desired.
     */
    protected static void viewProfile() {
        users = fileReader.FileReader(); // TODO - frissüljön futásidőben - ez még nem működik
        System.out.println("Write your username");
        String usernameInput = ShoppingSystemDriver.scanner.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(usernameInput)) {
                System.out.println("Name: "
                        + user.getName()
                        + " \nEmail: "
                        + user.getEmail()
                        + " \nAddress: "
                        + user.getAddress());

                System.out.println("Would you like to update your data? Y/N");
                String userChoiceInput = ShoppingSystemDriver.scanner.nextLine();
                switch (userChoiceInput) {
                    case "Y", "y":
                        UserController.modifyUser(user);
                    case "N", "n":
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else {
                System.out.println("Not found. Would you like to register? Y/N");
                String userChoiceInput = ShoppingSystemDriver.scanner.nextLine();
                switch (userChoiceInput) {
                    case "Y", "y":
                        UserController.registerUser();
                    case "N", "n":
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
            break;
        }
    }

    /**
     * Displays the menu for buying products and handles user input to add products to the cart.
     */
    protected static void buyProducts() {
        String buyProductsMenu = """
                To buy a product input the type:
                - electronics
                - clothing
                - books""";
        System.out.println(buyProductsMenu);
        String userChoiceInput = ShoppingSystemDriver.scanner.nextLine();
        String userSubChoiceInput;
        while (true) {
            if (userChoiceInput.equalsIgnoreCase("electronics")) {
                String subMenu = """
                        smartphone / laptop
                        """;
                System.out.println(subMenu);
                userSubChoiceInput = ShoppingSystemDriver.scanner.nextLine();
                if (userSubChoiceInput.equalsIgnoreCase("smartphone") || userSubChoiceInput.equalsIgnoreCase("laptop")) {
                    addProduct(userChoiceInput, userSubChoiceInput);
                } else {
                    System.out.println("Wrong input");
                }
            } else if (userChoiceInput.equalsIgnoreCase("clothing")) {
                String subMenu = """
                        shirt / pant""";
                System.out.println(subMenu);
                userSubChoiceInput = ShoppingSystemDriver.scanner.nextLine();
                if (userSubChoiceInput.equalsIgnoreCase("shirt") || userSubChoiceInput.equalsIgnoreCase("pant")) {
                    addProduct(userChoiceInput, userSubChoiceInput);
                } else {
                    System.out.println("Wrong input");
                }
            } else if (userChoiceInput.equalsIgnoreCase("books")) {
                String subMenu = """
                        novel / textbook""";
                System.out.println(subMenu);
                userSubChoiceInput = ShoppingSystemDriver.scanner.nextLine();
                if (userSubChoiceInput.equalsIgnoreCase("novel") || userSubChoiceInput.equalsIgnoreCase("textbook")) {
                    addProduct(userChoiceInput, userSubChoiceInput);
                } else {
                    System.out.println("Wrong input");
                }
            } else {
                System.out.println("Wrong input");
            }
            break;
        }
    }

    /**
     * Adds a product to the shopping cart based on user input.
     * @param userChoiceInput the main category of the product.
     * @param userSubChoiceInput the specific type of product within the main category.
     */
    private static void addProduct(String userChoiceInput, String userSubChoiceInput) {

        System.out.println("How many " + userSubChoiceInput + "s do you want?");
        int userProductNumber = ShoppingSystemDriver.scanner.nextInt();
        ShoppingSystemDriver.scanner.nextLine();

        while (true) {
            if (userProductNumber <= 0 || userProductNumber > 20) {
                System.out.println("Negative number, zero or more than 20 products. Write again!");
                userProductNumber = ShoppingSystemDriver.scanner.nextInt();
                ShoppingSystemDriver.scanner.nextLine();
            } else {
                for (int i = 0; i < userProductNumber; i++) {
                    shoppingCart.addItem(products, concreteProductFactory.createProduct(userChoiceInput, userSubChoiceInput));
                }
                System.out.println(userProductNumber
                        + " piece/pieces of "
                        + userSubChoiceInput
                        + " is/are added to your cart! - "
                        + products.size()
                        + " piece/pieces of product in your cart");
                break;
            }
        }
    }

    /**
     * Views the contents of the shopping cart.
     */
    protected static void viewCart() {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            shoppingCart.displayItems(products);
        }
    }

    /**
     * Handles the payment process, including selecting a shipping method and calculating the total cost.
     */
    protected static void payment() {

        if (products.isEmpty()) {
            System.out.println("Add something to the cart! It's empty now!");
        } else {
            double sum = 0.0;
            for (Product product : products) {
                sum += product.getPrice();
            }
            System.out.printf("The sum is: %.2f \n", sum);
            String shipmentPayment = """
                                        
                    Free shipping: Above 10 pieces, no charge, delivery within 5 days
                    Expedited shipping: extra 35.99 charge, delivery within 1 day
                    Standard shipping: 9.99 charge, delivery within 7 days
                    """;
            System.out.println("Write shipment's type: free/express/standard \n" + shipmentPayment);

            while (true) {
                String userShippingChoice = ShoppingSystemDriver.scanner.nextLine();
                if (userShippingChoice.equalsIgnoreCase("free")) {
                    if (countProductForFreeShipment()) {
                        break;
                    } else {
                        System.out.println("Write shipment's type: free / expedited / standard \n" + shipmentPayment);
                    }
                } else if (userShippingChoice.equalsIgnoreCase("expedited")) {
                    sum += expeditedShippingMethod();
                    break;
                } else if (userShippingChoice.equalsIgnoreCase("standard")) {
                    sum += standardShippingMethod();
                    break;
                } else {
                    System.out.println("Wrong input - try again!");
                }
            }

            System.out.printf("The sum is now: %.2f \n", sum);
            System.out.println("Would you like to pay now? Y/N");
            String userChoicePay = ShoppingSystemDriver.scanner.nextLine();

            if (userChoicePay.equalsIgnoreCase("y")) {
                System.out.println("Redirecting to the checkout...");
            } else {
                System.out.println("You can come back anytime to checkout!");
            }
        }
    }

    /**
     * Processes the standard shipping method and updates the total cost.
     * @return the cost of standard shipping.
     */
    private static double standardShippingMethod() {
        double shipmentPrice = 0.0;
        shippingProcessor.setShippingStrategy(standardShipping);
        shippingProcessor.processShipping("standard", 9.99);
        shipmentPrice += standardShipping.getPrice();
        return shipmentPrice;
    }

    private static double expeditedShippingMethod() {
        double shipmentPrice = 0.0;
        shippingProcessor.setShippingStrategy(expeditedShipping);
        shippingProcessor.processShipping("expedited", 35.99);
        shipmentPrice += expeditedShipping.getPrice();
        return shipmentPrice;
    }

    /**
     * Checks if the cart is eligible for free shipping based on the number of products.
     * @return true if eligible for free shipping, false otherwise.
     */
    private static boolean countProductForFreeShipment() {
        shippingProcessor.setShippingStrategy(freeShipping);
        if (products.size() < 10) {
            System.out.println("There are not enough products in your cart. Buy more product / choose another method!");
            return false;
        } else {
            shippingProcessor.processShipping("free", 0.00);
            return true;
        }
    }

    /**
     * Removes items from the shopping cart based on user input.
     */
    protected static void removeItemsFromCart() {
        if (products.size() == 0) {
            System.out.println("Your cart is empty");
        } else {
            shoppingCart.displayItems(products);
            System.out.println("Which product would you like to remove?");
            String userChoiceToRemove = ShoppingSystemDriver.scanner.nextLine();
            for (Product product : products) {
                if (product.getCategory().equalsIgnoreCase(userChoiceToRemove)) {
                    shoppingCart.removeItem(products, product);
                    System.out.println("Removed: " + product);
                } else {
                    System.out.println("Something went wrong");
                }
            }
        }
    }
}
