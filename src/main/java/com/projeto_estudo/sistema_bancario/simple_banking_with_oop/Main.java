package com.projeto_estudo.sistema_bancario.simple_banking_with_oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BankAccount accountOne = new BankAccount();

        System.out.println("--------------------");
        System.out.println("*  BANKING SYSTEM  *");
        System.out.println("--------------------\n");

        while (true) {
            System.out.println(
                """
                1. Create an account
                2. Deposit money
                3. Withdraw money
                4. Account status
                5. Monthly fee
                0. Close account
                """);
            try {
                System.out.print("What is your choice: ");
                int choices = scan.nextInt();
                scan.nextLine();

                if (choices == 1) {
                    accountOne.openAccount();
                } else if (choices == 2) {
                    accountOne.deposit();
                } else if (choices == 3) {
                    accountOne.toWithdraw();
                } else if (choices == 4) {
                    accountOne.accountStatus();
                } else if (choices == 5) {
                    accountOne.monthlyPayment();
                } else if (choices == 0) {
                    accountOne.closeAccount();
                    System.out.println("\nExiting the program. Thanks for testing!");
                    break;
                } else {
                    System.out.println("\nInvalid option!\n");
                    continue;
                }
            } catch (InputMismatchException exception){
                scan.next();
                System.out.println("\nUse the available options!\n");
                continue;
            }
        }
    }
}
