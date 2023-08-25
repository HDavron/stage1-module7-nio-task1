package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = file.toPath();
        String name;
        String age;
        String email;
        String phone;
        try (BufferedReader br = Files.newBufferedReader(path)){
            name = br.readLine();
            age = br.readLine();
            email = br.readLine();
            phone = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(substr(name), Integer.parseInt(substr(age)), substr(email), Long.parseLong(substr(phone)));
    }

    public String substr(String text) {
        return text.replaceAll(".*: ", "");
    }
}
