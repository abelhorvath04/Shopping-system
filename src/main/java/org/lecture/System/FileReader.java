package org.lecture.System;

import com.google.gson.Gson;
import org.lecture.Shopping.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    Path p = Paths.get("src", "main", "resources", "users.json");

    public List<User> FileReader() {

        List<User> users = new ArrayList<>();

        if (Files.notExists(p)) {
            System.err.println("Path not found " + p);
            return null;
        }

        try (BufferedReader reader = Files.newBufferedReader(p)) {

            Scanner scanner = new Scanner(reader);
            StringBuilder jsonString = new StringBuilder();

            while (scanner.hasNextLine()) {
                jsonString.append(scanner.nextLine());
            }
            Gson gson = new Gson();
            List<Map<String, String>> userDataList = gson.fromJson(jsonString.toString(), List.class);

            for (Map<String, String> userData : userDataList) {
                String username = userData.get("name");
                String email = userData.get("email");
                String address = userData.get("address");

                User user = new User(username, email, address);
                users.add(user);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return users;
    }


}
