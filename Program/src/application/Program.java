package application;

import entitis.Product;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        Product product = new Product(name,price);

        product.setName("Computador");
        System.out.println("Updated name: " + product.getName());
        product.setPrice(1200.00);
        System.out.println("Updated price: " + product.getPrice());

        System.out.println();
        System.out.println("Product data: " + product);

        System.out.println();

        System.out.print("Enter the number of products to be added in stock: ");
        int quatity = scanner.nextInt();
        product.addProducts(quatity);

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be remove in stock: ");
        quatity = scanner.nextInt();
        product.removeProducts(quatity);

        System.out.println();
        System.out.println("Updated data: " + product);

            scanner.close();
        }
    }
