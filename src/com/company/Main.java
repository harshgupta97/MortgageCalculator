package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principle: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat() / PERCENT;
        // Divide by 100 then 12 to get monthly interest rate
        float monthlyInterestRate = (annualInterestRate / MONTHS_IN_YEAR);

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        // Converting years in months
        int months = period * MONTHS_IN_YEAR;

        // Formula
        double mortgage = principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), months ))/(Math.pow((1 + monthlyInterestRate), months ) - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);
    }
}
