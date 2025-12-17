import java.util.Scanner;
public class Forca {
    public static void main(String[] args) {

        String palavraSecreta = "banana";

        char[] palavraEscondida = new char [palavraSecreta.length()];

        for (int i = 0; i < palavraSecreta.length(); i++){
            palavraEscondida[i] = '_';
        }

        int tentativas = 6;

        Scanner scanner = new Scanner(System.in);

        while (tentativas > 0){

            System.out.println("Palavra secreta: " + new String(palavraEscondida));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.println("Digite uma letra: ");

            char letra = scanner.next().charAt(0);

            Boolean letraEncontrada = false;

            for (int i = 0; i < palavraSecreta.length(); i++){
                if (palavraSecreta.charAt(i) == letra){
                    palavraEscondida[i] = letra;
                    letraEncontrada = true;
                }
            }
            if (!letraEncontrada){
                tentativas--;
                System.out.println("Letra incorreta! Tentativas restante: " + tentativas);
            }
            if (new String(palavraEscondida).equals(palavraSecreta)){
                System.out.println("Parabéns! Você advinhou, a palavra era: " + palavraSecreta);
                break;
            }
            if (tentativas == 0){
                System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
            }
        }
            scanner.close();
        }
    }
