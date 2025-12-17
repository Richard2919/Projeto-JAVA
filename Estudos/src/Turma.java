import java.util.Scanner;

class TesteTurma{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        System.out.println("Digite sua nota: ");
        float nota = scanner.nextFloat();

        System.out.println("Sua nota " + nota);

        if (nota >= 7){
            System.out.println("Você está aprovado!");
        }else{
            System.out.println("Você está reprovado.");
        }


        scanner.close();
    }
}
