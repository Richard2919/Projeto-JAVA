//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma conversão: ");
        System.out.println("1 - Metros para Quilometros");
        System.out.println("2 - Quilometros para metros");
        System.out.println("3 - Celsius para Fahrenheit");
        System.out.println("4 - Fahrenheit para Celsius");

        int opcao = scanner.nextInt();

        double valor, resultado;

        switch (opcao){
            case 1:
                System.out.println("Digite o valor em metros: ");
                valor = scanner.nextDouble();
                resultado = valor / 1000;
                System.out.println(valor + " metros é igual a " + resultado + " em quilometros");
                break;
            case 2:
                System.out.println("Digite o valor em quilometros: ");
                valor = scanner.nextDouble();
                resultado = valor * 1000;
                System.out.println(valor + " quilometros é igual a " + resultado + " metros");
                break;
            case 3:
                System.out.println("Digite o valor em Celsius: ");
                valor = scanner.nextDouble();
                resultado = (valor * 9/5) + 32;
                System.out.println(valor + " Celsius é igual a " +resultado + " em Fahrenheit");
                break;
            case 4:
                System.out.println("Digite o valor em Fahrenheit: ");
                valor = scanner.nextDouble();
                resultado = (valor - 32) * 5/9;
                System.out.println(valor + " Fahrenheit é igual a " +resultado + " em Celsius");
                break;
            default:
                System.out.println("Error: valor inválido, tente novamente.");
                break;
        }

        scanner.close();
    }
}