package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readInput("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) readInput("Annual Interest Rate: ", 1, 30);
        byte period = (byte) readInput("Period (Years): ", 1, 30);

        mortgageCalculator(principal, annualInterestRate, period);
        monthlyPayment(principal, annualInterestRate, period);
    }

    public static double readInput(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + + max);
        }
        return value;
    }

    public static void mortgageCalculator(int principal, float annualInterestRate, byte period ){

        float  monthlyInterestRate = (annualInterestRate / PERCENT / MONTHS_IN_YEAR );
        int months = period * MONTHS_IN_YEAR;

        double mortgage = principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), months ))/(Math.pow((1 + monthlyInterestRate), months ) - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage\n--------");
        System.out.println("Monthly payment: " + formattedMortgage);
    }

    private static void monthlyPayment(int principal, float annualInterestRate, byte period ) {
        // Balance amount
        // L => Loan amount (principal)
        // C => monthlyInterest
        // p => Number of payments we have made
        // n => NUmber of payments. For 10 year it will be 1120 payments
        // B = L[(1+C)^n-(1+C)^p]/[(1+C)^n-1]

        float  monthlyInterestRate = (annualInterestRate / PERCENT / MONTHS_IN_YEAR );
        int totalPayments = period * MONTHS_IN_YEAR;
        double balance;

        System.out.println("Payment schedule\n-----------------");
        for(int i = 1; i <= totalPayments; i++) {
            balance = principal * ((Math.pow((1 + monthlyInterestRate), totalPayments)) - (Math.pow((1 + monthlyInterestRate), i))) / ((Math.pow((1 + monthlyInterestRate), totalPayments)) - 1);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println("After " + i + " payment, Remaining balance is " + formattedBalance);
        }
    }
}
