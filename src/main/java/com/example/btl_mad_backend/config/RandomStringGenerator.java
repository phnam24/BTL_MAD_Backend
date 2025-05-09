package com.example.btl_mad_backend.config;

// Java program generate a random AlphaNumeric String
// using Math.random() method

import org.springframework.context.annotation.Bean;

public class RandomStringGenerator {

    @Bean
    // function to generate a random string of length n
    static String getAlphaNumericString(int n)
    {

// choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

// create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

// generate a random number between
// 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

// add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
