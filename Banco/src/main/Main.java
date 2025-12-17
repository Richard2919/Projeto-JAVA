package main;

import entitis.Account;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account;
        System.out.println("Enter account number: ");
        int numero = scanner.nextInt();
        System.out.println("Enter account holder: ");
        scanner.nextLine();
        String titular = scanner.nextLine();
        System.out.println("Is there na initial deposit (y/n)?");
        char resposta = scanner.next().charAt(0);

        if(resposta == 'y'){
            System.out.println("Enter initial deposit value: ");
            double depositoInicial = scanner.nextDouble();
            account = new Account(numero, titular, depositoInicial);
        }else{
            account = new Account(numero, titular);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account);

        System.out.println();

        System.out.print("Enter a deposit value: ");
        double valorDeposito = scanner.nextDouble();
        account.deposito(valorDeposito);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.print("Enter a withdraw value: ");
        double valorSaque = scanner.nextDouble();
        account.saque(valorSaque);
        System.out.println("Updated account data: ");
        System.out.println(account);




        scanner.close();
    }
}