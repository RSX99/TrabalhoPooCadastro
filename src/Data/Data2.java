package Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data2 {
	
	public static void Armazena(ArrayList<Integer> lista) {  
        try {  
            String caminho = "C:\teste2.txt";  
            FileWriter escrita = new FileWriter(caminho);  
            BufferedWriter escritor = new BufferedWriter(escrita);  
  
            for(int i=0;i< lista.size();i++){  
                escritor.write(lista.get(i).toString());  
                escritor.newLine();  
            }  
              
            escritor.flush();  
            escritor.close();  
            escrita.close();  
              
        } catch (Exception e) {  
            System.out.println("Erro ao criar arquivo!!"); 
        }  
    }  
}  



