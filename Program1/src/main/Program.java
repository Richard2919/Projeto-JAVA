package main;

import conversion.CurrencyConverter;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the dollar price? ");
        double cotacao = sc.nextDouble();

        System.out.println("How many dollars will be bought? ");
        double valorEmDolar = sc.nextDouble();

        double resultado = CurrencyConverter.dollarToReal(cotacao, valorEmDolar);

        System.out.println("Amount to be paid in reais = " + resultado);


        sc.close();
        }
    }
