public class Conta {

    private float saldo;
    private String nome;
    private  int agencia;

    public Conta(){

    }

    public Conta(String nome, int agencia, float saldo){

        this.nome = nome;
        this.agencia = agencia;
        this.saldo = saldo;

    }

    public float getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void imprime(){

        System.out.println(nome);
        System.out.println(agencia);
        System.out.println(saldo     );
    }
}
