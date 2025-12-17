import java.util.Arrays;

public class Vetor03 {
    public static void main(String[] args) {
        double v[] = {3.5, 6, 2.3, 9.9, -5.8};
        Arrays.sort(v);
        for (double valor: v){
            System.out.println(valor + " ");
        }
    }
}
