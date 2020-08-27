package com.company;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
    }

    public void printMortgage(){
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage\n--------");
        System.out.println("Monthly payment: " + formattedMortgage);

    }

    public void printPaymentSchedule(){
        System.out.println("Payment schedule\n-----------------");
        calculator.monthlyPayment();
    }
}
