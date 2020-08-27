package com.company;

import java.text.NumberFormat;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte period;

    public MortgageCalculator (int principal, float annualInterestRate, byte period ){
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public double calculateMortgage(){
        // Balance amount
        // L => Loan amount (principal)
        // C => monthlyInterest
        // p => Number of payments we have made
        // n => NUmber of payments. For 10 year it will be 1120 payments
        // B = L[(1+C)^n-(1+C)^p]/[(1+C)^n-1]

        float monthlyInterestRate = getMonthlyInterestRate();
        int NumberOfPayments = getNumberOfPayments();

        return principal * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), NumberOfPayments )) / (Math.pow((1 + monthlyInterestRate), NumberOfPayments ) - 1));
    }

    public void monthlyPayment() {
        // Balance amount
        // L => Loan amount (principal)
        // C => monthlyInterest
        // p => Number of payments we have made
        // n => NUmber of payments. For 10 year it will be 1120 payments
        // B = L[(1+C)^n-(1+C)^p]/[(1+C)^n-1]

        float monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        for(int i = 1; i <= numberOfPayments; i++) {
            double balance = principal * ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - (Math.pow((1 + monthlyInterestRate), i))) / ((Math.pow((1 + monthlyInterestRate), numberOfPayments)) - 1);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println("After " + i + " payment, Remaining balance is " + formattedBalance);
        }
    }

    private int getNumberOfPayments() {
        return period * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
