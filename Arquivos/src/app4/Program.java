package app4;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        //printa todas as pastas
        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("Folders: ");
        for(File folder : folders){
            System.out.println(folder);
        }


        //printa todos os arquivos
        File[] files = path.listFiles(File::isFile);
        System.out.println("Files: ");
        for (File file : files){
            System.out.println(file);
        }

        //cria um "sub pasta" chamada subdir
        boolean success = new File(strPath + "\\sudir").mkdir();
        System.out.println("Directory created successfully: " + success);



        sc.close();
    }
}
