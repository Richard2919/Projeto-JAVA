package app6;

import app6.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter a file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);

        // TESTE 1 – ver se o arquivo existe
        System.out.println("Arquivo existe? " + sourceFile.exists());

        String sourceFolderStr = sourceFile.getParent();

        // TESTE 2 – ver a pasta pai
        System.out.println("Pasta pai: " + sourceFolderStr);

        // Criar pasta out
        File outDir = new File(sourceFolderStr + "\\out");
        boolean success = outDir.mkdir();

        System.out.println("Pasta out criada? " + success);

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine();
            while (itemCsv != null) {

                String[] fields = itemCsv.split(",");

                String name = fields[0].trim();
                double price = Double.parseDouble(fields[1].trim());
                int quantity = Integer.parseInt(fields[2].trim());

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                for (Product item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }
                System.out.println("Arquivo criado em: " + targetFileStr);
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        sc.close();
    }
}
