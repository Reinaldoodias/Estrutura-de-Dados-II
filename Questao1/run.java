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
       ManipulacaoEstrutura manipulation = new ManipulacaoEstrutura();
        try{
            BufferedReader arquivo = new BufferedReader(new FileReader("src\\main\\java\\Questao1\\exec.txt"));
            String titulo = manipulation.Titulo(arquivo);
            switch(titulo){
                case "LISTA":
                    manipulation.Listas(arquivo);
                    break;
                case "FILA":
                    manipulation.Filas(arquivo);
                    break;
                case "PILHA":
                    manipulation.Pilhas(arquivo);
                    break;
                case "ARVORE":
                    manipulation.Arvores(arquivo);
                    break;
            }
       
        }catch(IOException e){
            e.printStackTrace();
        }

       

        
        
    }
}
