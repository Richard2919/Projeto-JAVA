//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma operação: ");
        System.out.println("1 - Soma ");
        System.out.println("2 - Subtração ");
        System.out.println("3 - Multiplicação ");
        System.out.println("4 - Divisão ");

        int escolha = scanner.nextInt();

        System.out.println("Digite o primeiro numero: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite o segundo numero: ");
        double num2 = scanner.nextDouble();

        double resultado = 0;

        switch (escolha){
            case 1:
                resultado = num1 + num2;
                System.out.println("O resultado da soma é: " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("O resultado da subtração é: " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("O resultado da multiplicação é: " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("O resultado da divisão é: " + resultado);

                } else {
                    System.out.println("Erro: divisão por zero!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}