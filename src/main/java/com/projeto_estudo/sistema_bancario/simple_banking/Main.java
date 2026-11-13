package com.projeto_estudo.sistema_bancario.simple_banking;

import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		double balance = 0;
		boolean isRunning = true;

		while (isRunning) {
			System.out.println("-------------------");
			System.out.println("* BANKING PROGRAM *");
			System.out.println("-------------------");

			System.out.println("1. Show Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");

			System.out.println("-------------------");

			System.out.print("Enter your Choice: ");
			int choice = scan.nextInt();

			switch (choice) {
				case 1:
					showBalance(balance);
					break;
				case 2:
					balance += deposit();
					break;
				case 3:
					balance -= withdraw(balance);
					break;
				case 4:
					isRunning = false;
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}

		System.out.println("-------------------------------");
		System.out.println("* THANK YOU! HAVE A NICE DAY! *");
		System.out.println("-------------------------------");

		scan.close();
	}

	static void showBalance(double balance) {
		System.out.printf("$%.2f%n", balance);
	}

	static double deposit() {
		double amount;

		System.out.print("Enter an amount to be deposited: ");
		amount = scan.nextDouble();

		if (amount < 0) {
			System.out.println("Amount can't be negative!");
			return 0;
		}

		return amount;
	}

	static double withdraw(double balance) {
		double amount;

		System.out.print("Enter amount to be withdraw: ");
		amount = scan.nextDouble();

		if (amount > balance) {
			System.out.println("Insufficient funds!");
			return  0;
		} else if (amount < 0) {
			System.out.println("Amount can't be negative!");
			return 0;
		}

		return amount;
	}
}
