package entitis;

public class Account {

    private int numero;
    private double saldo;
    private String titular;


    public Account(int numero, String titular, double depositoInicial) {
        this.numero = numero;
        this.titular = titular;
        deposito(depositoInicial);
    }

    public Account(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void deposito(double quantidade){
        saldo += quantidade;
    }

    public void saque(double quantidade){ //saque
        saldo -= quantidade + 5.0;

    }

    public String toString(){
        return "Account "
                + numero
                + ", Holder: "
                + titular
                + ", Balance: $"
                + String.format("%.2f", saldo);
    }

}
