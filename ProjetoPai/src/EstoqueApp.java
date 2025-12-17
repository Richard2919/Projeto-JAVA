import java.util.ArrayList;
import java.util.Scanner;

public class EstoqueApp {

    // Classe Item estática
    static class Item {
        String nome;
        int quantidade;
        double preco;

        Item(String nome, int quantidade, double preco) {
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
        }

        double valorTotal() {
            return quantidade * preco;
        }
    }

    // Variáveis do sistema
    static ArrayList<Item> estoque = new ArrayList<>();
    static ArrayList<String> anotacoes = new ArrayList<>();
    static double saldo = 0.0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Registrar item");
            System.out.println("2 - Saída de item");
            System.out.println("3 - Listar estoque");
            System.out.println("4 - Anotações");
            System.out.println("5 - Ver saldo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: registrarItem(); break;
                case 2: saidaItem(); break;
                case 3: listarEstoque(); break;
                case 4: menuAnotacoes(); break;
                case 5: System.out.println("Saldo atual: R$ " + saldo); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void registrarItem() {
        System.out.print("Nome do item: ");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        System.out.print("Preço unitário: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        Item novo = new Item(nome, qtd, preco);
        estoque.add(novo);
        saldo -= (qtd * preco); // compra reduz saldo
        System.out.println("Item registrado com sucesso!");
    }

    static void saidaItem() {
        System.out.print("Nome do item para saída: ");
        String nome = sc.nextLine();
        for (Item i : estoque) {
            if (i.nome.equalsIgnoreCase(nome)) {
                System.out.print("Quantidade a retirar: ");
                int qtd = sc.nextInt();
                sc.nextLine();
                if (qtd <= i.quantidade) {
                    i.quantidade -= qtd;
                    saldo += (qtd * i.preco); // saída aumenta saldo
                    System.out.println("Saída registrada!");
                } else {
                    System.out.println("Quantidade insuficiente em estoque.");
                }
                return;
            }
        }
        System.out.println("Item não encontrado!");
    }

    static void listarEstoque() {
        System.out.println("\n--- ESTOQUE ---");
        for (Item i : estoque) {
            System.out.println(i.nome + " | Qtd: " + i.quantidade + " | Preço: R$" + i.preco);
        }
    }

    static void menuAnotacoes() {
        int op;
        do {
            System.out.println("\n--- ANOTAÇÕES ---");
            System.out.println("1 - Nova anotação");
            System.out.println("2 - Listar anotações");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Digite a anotação: ");
                String nota = sc.nextLine();
                anotacoes.add(nota);
                System.out.println("Anotação salva!");
            } else if (op == 2) {
                System.out.println("\n--- ANOTAÇÕES SALVAS ---");
                for (String n : anotacoes) {
                    System.out.println("- " + n);
                }
            }
        } while (op != 0);
    }
}
