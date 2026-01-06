//FIleWriter e BufferedWriter usados para escrever no arquivo

package app3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        String[] lines = new String[]{"Boa tarde", "Bom dia", "Boa noite"};
        String path = "C:\\Windows\\Temp\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ // add o (path, true) para add informações no final do arq
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
