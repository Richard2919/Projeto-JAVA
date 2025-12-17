import java.util.Arrays;

public class Vetor04 {
    public static void main(String[] args) {
        int vet[] = {3,4,6,34,8};
        for (int v:vet){
            System.out.println(v + " ");
        }
        System.out.println(" ");
        int p = Arrays.binarySearch(vet, 6);
        System.out.println("Encontrei o valor na posição " + p);
    }
}
