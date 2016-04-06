package com.serialcode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Pavel Neizhmak
 */
public class SerialCodeGenerator {

    public static final int CODES_AMOUNT = 60000;
    public static final int CODE_LENGTH = 16;

    public static final String FILE_PATH = "output/code1.csv";

    public static void main(String[] args) {
        Random random = new Random();
        try (FileOutputStream code1 = new FileOutputStream(FILE_PATH)) {
            System.out.println("-----write to code1-----");
            writeToFile(random, code1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void writeToFile(Random random, FileOutputStream fos) {
        IntStream.range(0, CODES_AMOUNT).
                forEach(i -> {
                    try {
                        fos.write(generateRandomString(random, CODE_LENGTH).getBytes());
                        fos.write(System.getProperty("line.separator").getBytes());
                        System.out.println("code " + i + " generated successfully");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static String generateRandomString(Random random, int length) {
        return random.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
