/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Reinaldo Dias
 */
public class Run {
    public static void main(String[] args){
        ArvoreBin<Integer> arvore = new ArvoreBin<>();
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\questao3\\entrada.txt"));
            String line;
            
            while((line=leitor.readLine())!=null){
                String[] numeros = line.split(" ");
                for(int con=0;con<=numeros.length-1;con++){
                    int num = Integer.parseInt(numeros[con]); 
                    arvore.Inserir_Elemento(num);
                }
            }
            
           }catch(IOException e){
                e.printStackTrace();
            }
        
        arvore.Tela(1);
        System.out.println(arvore.retornaProfundidade_Min());

        

    }
}
