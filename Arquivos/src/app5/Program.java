package app5;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a file path");
        String strPath = sc.nextLine();

        File path = new File(strPath);
        //printa somente o nome do arq e ignora o restante do caminho
        System.out.println("getName: " + path.getName());

        //printa o caminho do arq ignorando o nome
        System.out.println("getParent: " + path.getParent());

        //printa o caminho e nome completo do arq
        System.out.println("getPath: " + path.getPath());
        sc.close();
    }
}
