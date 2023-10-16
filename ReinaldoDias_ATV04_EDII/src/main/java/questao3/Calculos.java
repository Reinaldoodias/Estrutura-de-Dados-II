/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Classe para realizar cálculos aritméticos e aplicar na resolução.
 * @author Reinaldo Dias
 */
public class Calculos {
/**
 * Método para verificar se um número é primo ou não.
 * @param number A quantidade de linhas necessárias para evitar colisões com base em outro cálculo.
 * @return Retorna 'true' se o númeor for primo, ou 'false' caso não for.
 */
    public static boolean isPrime(int number) {
    if (number <= 1) {
        return false;
    }
    if (number <= 3) {
        return true;
    }
    if (number % 2 == 0 || number % 3 == 0) {
        return false;
    }
    for (int i = 5; i * i <= number; i += 6) {
        if (number % i == 0 || number % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}
/**
 * Método que calcula a quantidade de linhas presentes no arquivo 'Entrada.txt' e define uma margem para evitar colisões. 
 * @return Retorna o tamanho primo recomendado com base na 
 */
    public static int tamanhofile(){
        try{
        Path path = Path.of("src\\main\\java\\questao3\\Entrada.txt");
        List<String> linhas = Files.readAllLines(path);
        int quantLinhas = linhas.size();
        return tamanhoTabela(quantLinhas);
        }catch(Exception e){
            System.out.println("Erro" + e.getMessage());
            return 0;
        }
        
    }
/**
 * Método que calcula um tamanho com uma margem considerável para evitar colisões em uma tabela.
 * @param qtdlinhas Parâmetro que representa a quantidade de linhas do arquivo de entrada, ou seja, a quantidade de elementos.
 * @return retorna com base em um cálculo aritmpetica o tamanho com margem para a tabela Hash.
 */
    public static int tamanhoTabela(int qtdlinhas){
        int tamanhoTabela = (qtdlinhas + qtdlinhas/2 + qtdlinhas/6);
        while(!Calculos.isPrime(tamanhoTabela)){
            tamanhoTabela++;
        }
        return tamanhoTabela;
    }

}
