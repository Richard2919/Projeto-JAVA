public class infoPessoal {
    private String cidade = "Mococa";
    private String nome = "Roberto";
    private int idade = 20;

    public void Mostrar (){
        System.out.println( "Nome: " + nome + ", idade: " + idade + ", cidade: " + cidade);
    }

    public static void main(String[] args) {
        infoPessoal pessoa = new infoPessoal();

        pessoa.Mostrar();
    }
}
