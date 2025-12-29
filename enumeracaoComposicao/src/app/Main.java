package app;

import entitis.Department;
import entitis.HourContract;
import entitis.Worker;
import entitisEnum.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department´s name: ");
        String departmentsName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String nameWorker = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base salary: ");
        Double salaryB = sc.nextDouble();

        Worker worker = new Worker(nameWorker, WorkerLevel.valueOf(workerLevel), salaryB, new Department(departmentsName));

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Enter contract #" + 1 + "data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/yyyy)");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for" + monthAndYear + ": " + worker.income(year, month));

        sc.close();
    }
}