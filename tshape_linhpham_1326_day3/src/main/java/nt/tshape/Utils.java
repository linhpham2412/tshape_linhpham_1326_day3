package nt.tshape;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Utils {
    public static String generateTestEmail(){
        Random emailRandIndex = new Random();
        return emailRandIndex.nextInt()+"@mail.com";
    }

    public static String generateTestCustomerName(int noOfCharsToGenerate) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = noOfCharsToGenerate;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
