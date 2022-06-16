package com.example.demo.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ReadWriteInTextFileManager {

    public static void writeIntoFile(String authorizeToken, String refreshToken) {

        try (
            FileWriter file = new FileWriter("tokens.txt")) {
            String[] tokenData = new String[2];
            tokenData[0] = authorizeToken;
            tokenData[1] = refreshToken;
            file.write(tokenData[0]);
            file.write("\n");
            file.write(tokenData[1]);
            file.flush();   // or file.close()
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String fileContent = "";
        try {
            // create a reader
            FileReader reader = new FileReader(fileName);

            // read every characer
            int ch;

            while ((ch = reader.read()) != -1) {
//                System.out.print((char) ch);
                fileContent += ch;
            }

            // close the reader
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileContent;
    }

    // token1.setAccessToken(accessTokenData);
    // token1.setRefreshToken(refreshTokenData);
    // ..
    // ReadWriteInTextFileManager.writeIntoFile(token1.getAccessToken(), token1.getRefreshToken());
    // ReadWriteInTextFileManager.readFromFile(fileName);
}



// read json to string
//    File resource = new ClassPathResource("token.json").getFile();
//    String text = new String(Files.readAllBytes(resource.toPath()));
