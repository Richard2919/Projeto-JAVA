package app;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Shape> list = new ArrayList<>();

        System.out.println("Enter the number of shapes: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char ch = sc.next().charAt(0);
            System.out.println("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());
            if(ch == 'r'){
                System.out.println("Width: ");
                double width = sc.nextDouble();
                System.out.println("Height: ");
                double height = sc.nextDouble();
                list.add(new Rectangle(color, width, height));
            }else{
                System.out.println("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.println("SHAPE AREAS: ");
        for (Shape shape : list){
            System.out.println(shape.area());
        }

        sc.close();
    }
}