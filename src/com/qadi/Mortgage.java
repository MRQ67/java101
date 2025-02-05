package com.qadi;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    int principal;
    int years;
    double rate;

    public Mortgage(int principal, int years, double rate) {
        this.principal = principal;
        this.years = years;
        this.rate = rate;
    }

    public int getPayment() {
        double monthlyRate = rate / 1200;
        double monthlyPayment = principal * monthlyRate / (1 - (1 / Math.pow(1 + monthlyRate, years * 12)));
        return (int) Math.round(monthlyPayment);
    }

    public static void main(String[] args) {
        // prompt user for input
        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            if (scanner.hasNextInt()) {
                principal = scanner.nextInt();
                scanner.nextLine();
                if (principal >= 1000 && principal <= 1000000) {
                    break;
                } else if (principal < 1000) {
                    System.out.println("Principal must be at least $1,000.");
                } else {
                    System.out.println("Principal must be at most $1,000,000.");
                }
            }
            else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.nextLine();
            }
             // clear the invalid input
        }

        double rates;
        while (true) {
            System.out.print("Interest Rate: ");
            if (scanner.hasNextDouble()) {
                rates = scanner.nextDouble();
                if (rates > 0 && rates <= 30) {
                    break;
                } else if (rates < 0) {
                    System.out.println("Interest rate must be at least 0.");
                } else {
                    System.out.println("Interest rate must be at most 30.");

                }
            }
            System.out.println("Invalid input. Please enter a positive number.");
            scanner.nextLine(); // clear the invalid input
        }

        int year;
        while (true) {
            System.out.print("Years: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year > 0 && year <= 30) {
                    break;
                } else if (year < 0) {
                    System.out.println("Years must be at least 1.");
                } else {
                    System.out.println("Years must be at most 30.");

                }
            }
            System.out.println("Invalid input. Please enter a positive integer.");
            scanner.nextLine(); // clear the invalid input
        }

        // create new mortgage object
        Mortgage mortgage = new Mortgage(principal, year, rates);

        // calculate payment
        double payment = mortgage.getPayment();

        // print payment in currency format
        String formattedPayment = NumberFormat.getCurrencyInstance().format(payment);
        System.out.print("Payment: " + formattedPayment);
    }
}
