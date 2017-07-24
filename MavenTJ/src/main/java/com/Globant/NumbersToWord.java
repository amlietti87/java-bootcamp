/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import java.math.BigDecimal;

/**
 *
 * @author andreslietti
 */
public class NumbersToWord {

    private final String[] specialNames = {
        "",
        " thousand",
        " million",};

    private final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };

    private final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };

    // Here we convert the number less than one thousand to words.
    public String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;

        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }

        if (number == 0) {
            return current;
        }
        return numNames[number] + " hundred" + current;

    }

    // Here i recive the total amount and convert to text.
    public String convert(double amount) {

        int whole = takeipart(amount);
        String decimal = takefpart(amount);

        if (whole == 0) {
            return "Zero and " + decimal + " dollars";
        }

        String current = "";
        int place = 0;
        int i = 0;

        do {
            int n = whole % 1000;
            if (n != 0) {
                String ntw = convertLessThanOneThousand(n);
                current = ntw + specialNames[place] + current;
            }
            place++;

            whole /= 1000;

        } while (whole > 0);

        return (current + " and " + decimal + " dollars").trim();

    }
    
    // This method separate the decimal part of amount
    String takefpart(double amount) {
        String str = String.valueOf(amount);
        int decNumber = Integer.parseInt(str.substring(str.indexOf('.') + 1));
        return decNumber + "/100";
    }
    
    // This method separate the integer part of amount
    int takeipart(double amount) {
        String str = String.valueOf(amount);
        int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
        return intNumber;
    }

}
