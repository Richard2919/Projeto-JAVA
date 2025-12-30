package app;

import entitis.Account;
import entitis.BisnessAccount;
import entitis.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        BisnessAccount account = new BisnessAccount();

        Account acc = new Account(1001, "Alex", 0.0);
        BisnessAccount bacc = new BisnessAccount(1002, "Maria", 0.0, 500.0);

        //upcasting

        Account acc1 = bacc;
        Account acc2 = new BisnessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        // downcasting

        BisnessAccount acc4 = (BisnessAccount)acc2;
        acc4.loan(100.0);

       // BisnessAccount acc5 = (BisnessAccount)acc3; //acc3 é uma SavingsAccount e não Bisness entao da erro
        if(acc3 instanceof BisnessAccount){
            BisnessAccount acc5 = (BisnessAccount)acc3;
            acc5.loan(200);
            System.out.println("Loan!");
        }
        if(acc3 instanceof SavingsAccount){ //verifica se acc é instancia de SavingAccount
            SavingsAccount acc5 = (SavingsAccount)acc3; //aqui ocorre o casting
            acc5.uppdateBalance();
            System.out.println("Update");
        }
    }
}