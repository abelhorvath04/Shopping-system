package org.lecture.System;

import com.google.gson.Gson;
import org.lecture.Shopping.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriter {

    public static void fileWriter (Path p, List<User> users) {
        Gson gson = new Gson();
        String json = gson.toJson(users);

        try (BufferedWriter bw = Files.newBufferedWriter(p)) {
            bw.write(json);
            System.out.println("Success on the path: " + p);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}