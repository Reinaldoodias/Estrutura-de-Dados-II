/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import questao1.TabelaHash;

/**
 * método Principal para resolução do exercício 3 da Atividade 4 de algoritmos e estruturas de dados II.
 * @author Reinaldo Dias
 */
public class Run {
    public static void main(String[] args){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\questao3\\Entrada.txt"));
            TabelaHash<String, Cliente> tabela = new TabelaHash<>(Calculos.tamanhofile());
            String line;
            while((line = leitor.readLine()) != null){
                String[] cliente = line.split(";");
                Cliente temp = new Cliente(cliente[0], cliente[1], cliente[2],cliente[3]);
                tabela.inserir(cliente[0], temp);
            }
            operacao(tabela);
            Calculos.tamanhofile();
        }catch(Exception e){
            System.out.println("Erro" + e.getMessage());
        }
        
    }
/**
 * Método resposável por ler o arquivo 'Exec.txt' e executar as operações.
 * @param tabela Recebe uma Tabela Hash existente como parâmetro.
 * @param <Integer> o Tipo de dado a ser utilizado como 'chave' na tabela é inteiro.
 * @param <Cliente> o tipo de dado a ser utilizado na tabela com 'valor' é Cliente. 
 */ 
    private static void operacao(TabelaHash<String, Cliente> tabela) {
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\questao3\\Exec.txt"));
            String line;
            int chave;
            while((line=leitor.readLine()) != null){
                String[] linha = line.split(";");
                String funcao = linha[0].toUpperCase();//Transforma para maiúsculo
                System.out.println(Arrays.toString(linha));
                switch(funcao){
                    case "INSERIR":
                        Cliente temp = new Cliente(linha[1], linha[2], linha[3],linha[4]);
                        tabela.inserir(linha[1].trim(), temp);
                        break;
                    case "REMOVER":
                        if(tabela.obter(linha[1].trim()) != null){
                            tabela.remover(linha[1].trim());
                        }else{
                            System.out.println("O cliente não está presente na tabela.");    
                        }    
                        break;
                    case "IMPRIMIR":
                        tabela.imprimirTabela();
                        break;
                    case "BUSCAR":
                        if(tabela.obter(linha[1].trim())==null){
                            System.out.println("Cliente não está presente na tabela");         
                        }else{
                            System.out.println("\t|BUCKET(" +tabela.calcularIndice(linha[1].trim())+ "):" + "\n\t|-> Dados =" + tabela.obter(linha[1].trim()).toString());
                        }
                        break; 
                }
            }   
        }catch(Exception e){
            System.out.println("Erro" + e.getMessage());
        }
    }
 
}

