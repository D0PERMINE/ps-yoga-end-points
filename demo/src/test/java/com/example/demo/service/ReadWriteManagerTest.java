package com.example.demo.service;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadWriteManagerTest {
    private final String fileName = "tokens.txt";

    @Test
    void testWriteAndRead(){
        String testAccesToken= "abcdefg";
        String testRefreshToken= "asdfghj";
        ReadWriteInTextFileManager.writeIntoFile(testAccesToken,testRefreshToken);
        String tokenStrings = ReadWriteInTextFileManager.readFromFile(fileName);
        System.out.println(tokenStrings);
        Assertions.assertEquals(testAccesToken + testRefreshToken, tokenStrings);
    }
}
