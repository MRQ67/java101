package com.qadi;

import java.util.Scanner;

public class Strin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String str = input.nextLine().trim().toUpperCase();
        System.out.println("You name is " + str);
    }
}