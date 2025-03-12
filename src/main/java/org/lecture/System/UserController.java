package org.lecture.System;

import org.lecture.Shopping.User;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * UserController class to manage user registration and modification.
 */
public class UserController {

    private static final FileReader fileReader = new FileReader();
    private static final Path p = Paths.get("src","main","resources","users.json");

    /**
     * Modifies the details of an existing user.
     * @param user the user to be modified.
     */
    protected static void modifyUser(User user) {
        List<User> users = fileReader.FileReader();
        System.out.println("Which data would you like to update? name/email/address");
        String userChoiceInput = ShoppingSystemDriver.scanner.nextLine();

        switch (userChoiceInput.toLowerCase()) {
            case "name" -> {
                System.out.println("Write your new username");
                String userUpdatedName = ShoppingSystemDriver.scanner.nextLine();
                usernameInputValidation(userUpdatedName);
                user.setName(userUpdatedName);
            }
            case "email" -> {
                System.out.println("Write your new email");
                String userUpdatedEmail = ShoppingSystemDriver.scanner.nextLine();
                userEmailInputValidation(userUpdatedEmail);
                user.setEmail(userUpdatedEmail);
            }
            case "address" -> {
                System.out.println("Write your new address");
                String userUpdatedAddress = ShoppingSystemDriver.scanner.nextLine();
                user.setAddress(userUpdatedAddress);
            }
            default -> System.out.println("Wrong input");
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.set(i, user);
                updateUsersFile(users);
                break;
            }
        }
    }

    /**
     * Updates the users file with the modified list of users.
     * @param users the list of users to be written to the file.
     */
    private static void updateUsersFile(List<User> users) {
        FileWriter.fileWriter(p, users);
        System.out.println("Success");
    }

    /**
     * Registers a new user and adds them to the users file.
     */
    protected static void registerUser() {

        List<User> users = fileReader.FileReader();

        System.out.println("Write username");
        String userNameInput = ShoppingSystemDriver.scanner.nextLine();

        usernameInputValidation(userNameInput);

        System.out.println("Write email");
        String userEmailInput = ShoppingSystemDriver.scanner.nextLine();
        userEmailInputValidation(userEmailInput);

        System.out.println("Write address");
        String userAddressInput = ShoppingSystemDriver.scanner.nextLine();

        User newUser = new User(userNameInput,userEmailInput,userAddressInput);

        users.add(newUser);
        FileWriter.fileWriter(p,users);

    }

    /**
     * Validates the user's email input.
     * @param userEmailInput the email input to be validated.
     */
    private static void userEmailInputValidation(String userEmailInput) {
        while (true) {
            if (userEmailInput.isEmpty()) {
                System.out.println("Empty. Write something!");
                userEmailInput = ShoppingSystemDriver.scanner.nextLine();
            } else if (userEmailInput.length() < 8 || userEmailInput.length() > 40) {
                System.out.println("Too much / too few, please write again");
                userEmailInput = ShoppingSystemDriver.scanner.nextLine();
            } else {
                break;
            }
        }
    }

    /**
     * Validates the user's username input.
     * @param userInput the username input to be validated.
     */
    private static void usernameInputValidation(String userInput) {
        while (true) {
            if (userInput.isEmpty()) {
                System.out.println("Empty. Write something!");
                userInput = ShoppingSystemDriver.scanner.nextLine();
            } else if (userInput.length() > 15) {
                System.out.println("Too much characters, please write shorter");
                userInput = ShoppingSystemDriver.scanner.nextLine();
            } else {
                break;
            }
        }
    }
}
