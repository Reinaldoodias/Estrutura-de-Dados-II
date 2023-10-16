/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao2;

import java.util.ArrayList;
import questao1.TabelaHash;


/**
 *
 * @author Reinaldo Dias
 */
public class Run {
    public static void main(String[] args){
        /*Vetor exemplo:*/
        int[] vetor = {1,1, 2, 147, 10316,3, 4, 5, 7,6, 6, 7, 8, 9, 10, 11, 11, 12, 13, 14, 15, 16, 17, 18,10316, 19, 20, 21};
        int tamanhotabela = (int) (vetor.length + vetor.length/2 + vetor.length/6);
        TabelaHash<Integer, Integer> tabela = new TabelaHash<>(tamanhotabela);
        ArrayList<Integer> duplicados = new ArrayList<>();
        
        for(int i=0;i<vetor.length;i++){
            tabela.inserir_Q2(vetor[i], vetor[i]);
        }
        
        tabela.imprimirTabela();
        System.out.println("\n\nDuplicados" + tabela.duplicados());
       
    }
}
