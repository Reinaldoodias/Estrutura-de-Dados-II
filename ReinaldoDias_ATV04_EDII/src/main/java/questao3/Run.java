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
            TabelaHash<Integer, Cliente> tabela = new TabelaHash<>(Calculos.tamanhofile());
            String line;
            while((line = leitor.readLine()) != null){
                String[] cliente = line.split(";");
                int chave = Integer.parseInt(cliente[0]);
                Cliente temp = new Cliente(chave, cliente[1], cliente[2],cliente[3]);
                tabela.inserir(chave, temp);
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
    private static void operacao(TabelaHash<Integer, Cliente> tabela) {
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
                        chave = Integer.parseInt(linha[1].trim());
                        Cliente temp = new Cliente(chave, linha[2], linha[3],linha[4]);
                        tabela.inserir(chave, temp);
                        break;
                    case "REMOVER":
                        chave = Integer.parseInt(linha[1].trim());
                        if(tabela.obter(chave) != null){
                            tabela.remover(chave);
                        }else{
                            System.out.println("O cliente não está presente na tabela.");    
                        }    
                        break;
                    case "IMPRIMIR":
                        tabela.imprimirTabela();
                        break;
                    case "BUSCAR":
                        chave = Integer.parseInt(linha[1].trim());
                        if(tabela.obter(chave)==null){
                            System.out.println("Cliente não está presente na tabela");         
                        }else{
                            System.out.println("\t|BUCKET(" +tabela.calcularIndice(chave)+ "):" + "\n\t|-> Dados =" + tabela.obter(chave).toString());
                        }
                        break; 
                }
            }   
        }catch(Exception e){
            System.out.println("Erro" + e.getMessage());
        }
    }
 
}

