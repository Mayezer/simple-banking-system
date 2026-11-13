package com.projeto_estudo.sistema_bancario.simple_banking_with_oop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {

    Scanner scan = new Scanner(System.in);

    private int id;
    private String type; // CC e CP
    private String name;
    private double balance;
    private boolean status;

    public int getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public double getBalance() {
        return this.balance;
    }
    public boolean getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void openAccount() {
        this.status = true;
        while (true) {
            System.out.print("Account type - [CC/CP]: ");
            this.type = scan.nextLine();
            if (this.type.equalsIgnoreCase("CC")) {
                this.balance = this.balance + 50.00;
                break;
            } else if (this.type.equalsIgnoreCase("CP")) {
                this.balance = this.balance + 150.00;
                break;
            } else {
                System.out.println("\nINVALID Option!\n");
            }
        }

        System.out.print("Name: ");
        this.name = scan.nextLine();

        System.out.println("\nAccount opened successfully, claim this bonus: " + this.balance + " | " + this.name + "\n");
    }

    public void closeAccount() {
        if (this.status == true) {
            while (true) {
                if (this.balance < 0) {
                    System.out.println("\nYou have a negative balance; pay what you owe first!\n");
                    break;
                } else if (this.balance > 0) {
                    System.out.println("\nWithdraw all your money so you can close the account!\n");
                    break;
                } else {
                    System.out.println("Do you really want to close your account [Y/N]: ");
                    String confirmation = scan.nextLine();

                    while (true) {
                        if (confirmation.equalsIgnoreCase("Y")) {
                            this.status = false;
                            System.out.println("\nAccount closed successfully!\n");
                            break;
                        } else if (confirmation.equalsIgnoreCase("N")) {
                            System.out.println("\nAccount not closed; thank you for your trust.\n");
                            break;
                        } else {
                            System.out.println("\nInvalid option!\n");
                        }
                    }
                }
            }
        } else {
            System.out.println("\nAccount status: Inactive.\n");
        }
    }

    public void deposit() {
        if (this.status == true) {
            while (true) {
                try {
                    System.out.print("How much would you like to deposit: ");
                    double depositValue = scan.nextDouble();
                    scan.nextLine();

                    if (depositValue < 0) {
                        System.out.println("\nYou cannot deposit negative amounts!\n");
                        continue;
                    } else if (depositValue == 0) {
                        System.out.println("\nYou cannot deposit zero!\n");
                        continue;
                    } else {
                        this.balance = this.balance + depositValue;
                        System.out.println("\nDeposit successfully made, your balance: " + this.balance + "\n");
                        break;
                    }
                } catch (InputMismatchException exception){
                    scan.next();
                    System.out.println("\nUse a comma. Example: 00,00\n");
                    continue;
                }
            }
        } else {
            System.out.println("\nAccount status: Inactive.\n");
        }
    }

    public void toWithdraw() {
        if (this.status == true) {
            while (true) {
                if (this.balance < 0) {
                    System.out.println("\nYour account has a negative balance. Pay what you owe first!\n");
                    break;
                } else if (this.balance == 0) {
                    System.out.println("\nYour account balance is zero!\n");
                    break;
                }

                try {
                    System.out.print("How much would you like to withdraw: ");
                    double toWithdrawValue = scan.nextDouble();
                    scan.nextLine();

                    if (toWithdrawValue < 0) {
                        System.out.println("\nDon't use negative numbers!\n");
                        continue;
                    } else if (toWithdrawValue == 0) {
                        System.out.println("\nWe cannot withdraw zero!\n");
                        continue;
                    } else if (toWithdrawValue > this.balance) {
                        System.out.println("\nYou don't have all that money in your account, balance: " + this.balance + "\n");
                        continue;
                    } else {
                        this.balance = this.balance - toWithdrawValue;
                        System.out.println("\nWithdrawal successfully completed, your balance: " + this.balance + "\n");
                        break;
                    }
                } catch (InputMismatchException exception) {
                    scan.next();
                    System.out.println("\nUse a comma. Example: 00,00\n");
                    continue;
                }
            }
        } else {
            System.out.println("\nAccount status: Inactive.\n");
        }
    }

    public void monthlyPayment() {
        if (this.status == true) {
            while (true) {
                System.out.print("Would you like to pay your fee in advance [Y/N]: ");
                String choices = scan.nextLine();
                if (choices.equalsIgnoreCase("Y")) {
                    if (this.type.equalsIgnoreCase("CC")) {
                        this.balance = this.balance - 20.00;
                        System.out.println("\nMonthly fee charged, your balance: " + this.balance + "\n");
                        break;
                    } else if (this.type.equalsIgnoreCase("CP")) {
                        this.balance = this.balance - 12.00;
                        System.out.println("\nMonthly fee charged, your balance: " + this.balance + "\n");
                        break;
                    } else {
                        System.out.println("\nAccount does not exist!\n");
                        break;
                    }
                } else if (choices.equalsIgnoreCase("N")) {
                    System.out.println(
                            """
                            \n-------------- Learn more about the fees ---------------
                            The monthly fee for a checking account (CC) is: R$ 20
                            And the monthly fee for a savings account (CP) is: R$ 12
                            """);
                    break;
                } else {
                    System.out.println("\nInvalid option!\n");
                }
            }
        }
    }

    public void accountStatus() {
        if (this.status == true) {
            System.out.println(
                    "\n----- Account Status -----" +
                    "\nAccount type: " + this.type + "\n" +
                    "Name: " + this.name + "\n" +
                    "Balance: " + this.balance + "\n");
        } else {
            System.out.println("\nAccount status: Inactive.\n");
        }
    }
}
