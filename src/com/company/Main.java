package com.company;

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readInput("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readInput("Annual Interest Rate: ", 1, 30);
        byte period = (byte) Console.readInput("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterestRate, period);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();

    }
}
