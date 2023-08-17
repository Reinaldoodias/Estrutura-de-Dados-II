/*
 * 
 */

package Questao1;
import java.io.BufferedReader;
import Questao1.ListaDE;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Reinaldo Dias
 */
public class run {

    public static void main(String[] args) {
        ManipulacaoEstrutura reader = new ManipulacaoEstrutura();
        try{
            BufferedReader arquivo= new BufferedReader(new FileReader("C:\\Users\\Reinaldo Dias\\Documents\\NetBeansProjects\\reinaldodias_ATV01 _ED II\\src\\main\\java\\Questao1\\exec.txt.txt"));
            String titulo = reader.Titulo(arquivo);
            switch(titulo){
                case "LISTA":
                    reader.Listas(arquivo);
                    break;
                case "FILA":
                    reader.Filas(arquivo);
                    break;
                case "PILHA":
                    reader.Pilhas(arquivo);
                    break;
            }
       
        }catch(IOException e){
            e.printStackTrace();
        }
       
       

        
        
    }
}
