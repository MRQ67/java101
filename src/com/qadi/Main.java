package com.qadi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your income: ");
        int income = input.nextInt();
        String classname = income > 1000 ? "First" : "Economy";
        System.out.println("Your class is " + classname);
    }
}