package org.lecture.System;

import java.util.Scanner;


/**
 * ShoppingSystemDriver class to drive the shopping system application.
 * It provides a menu interface for users to interact with the shopping system.
 */
public class ShoppingSystemDriver {
    public static final Scanner scanner = new Scanner(System.in);
    private static final ShoppingSystem shoppingSystem = ShoppingSystem.getInstance();

    public static void main(String[] args) {
        showMenu();
    }

    /**
     * Displays the menu and handles user input to interact with the shopping system.
     */
    private static void showMenu() {
        boolean isRunning = true;
        while (isRunning) {
            String title = """
                       _____ _                                      _____           _                \s
                      / ____| |                     (_)            / ____|         | |               \s
                     | (___ | |__   ___  _ __  _ __  _ _ __   __ _| (___  _   _ ___| |_ ___ _ __ ___ \s
                      \\___ \\| '_ \\ / _ \\| '_ \\| '_ \\| | '_ \\ / _` |\\___ \\| | | / __| __/ _ \\ '_ ` _ \\\s
                      ____) | | | | (_) | |_) | |_) | | | | | (_| |____) | |_| \\__ \\ ||  __/ | | | | |
                     |_____/|_| |_|\\___/| .__/| .__/|_|_| |_|\\__, |_____/ \\__, |___/\\__\\___|_| |_| |_|
                                        | |   | |             __/ |        __/ |                     \s
                                        |_|   |_|            |___/        |___/                      \s                   
                    """;
            String menu = """
                    1 - Profile
                    2 - Buy products
                    3 - View cart
                    4 - Pay
                    5 - Remove from cart
                                    
                    Q - quit
                    """;
            System.out.println(title + "\n" + menu);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    shoppingSystem.viewProfile();
                    break;
                case "2":
                    shoppingSystem.buyProducts();
                    break;
                case "3":
                    shoppingSystem.viewCart();
                    break;
                case "4":
                    shoppingSystem.payment();
                    break;
                case "5":
                    shoppingSystem.removeItemsFromCart();
                    break;
                case "q", "Q":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
