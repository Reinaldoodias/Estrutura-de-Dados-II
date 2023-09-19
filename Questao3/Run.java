/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao3;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author 20221si0029
 */
public class Run {
    public static void main(String[] args){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\Questao3\\Dados.txt"));
            ListaDE<Integer> lista = new ListaDE<>();
            String line;
            while((line=leitor.readLine())!=null){
                String[] inteiros = line.split(",");
                for(int i=0;i<inteiros.length;i++){
                    lista.Inserir_Elemento_Final(Integer.parseInt(inteiros[i]));
                } 
            }
            lista.ordenar();
            if(lista.Tamanho()%2==0){
                int direita = lista.chamar_Obter_posicao(lista.Tamanho()/2, 0);
                int esquerda  = lista.chamar_Obter_posicao((lista.Tamanho()/2)-1, 0);
                double media = (double)(direita + esquerda)/2;
                System.out.println("Mediana: " + media);
            }else{
                System.out.println(lista.chamar_Obter_posicao(lista.Tamanho()/2, 0));
            }
            
            
            
            
        }catch(Exception e){
            throw new RuntimeException("Erro na leitura certifique-se que você seguiu as diretrizes");
        }
    }
    

}
