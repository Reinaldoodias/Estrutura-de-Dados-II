/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.IIOException;
/**
 *
 * @author Reinaldo Dias
 */
/**
 * Classe para operacoes das estruturas
 * @author Reinaldo Dias
 */
public class ManipulacaoEstrutura {
    /**
     * Método para operações com listas
     * @param arquivo O objeto que foi criado para ler o arquivo exec.txt
     */
    public void Listas(BufferedReader arquivo){
        ListaDE<String> lista = new ListaDE<String>();
        try{
            String line; 
               while((line = arquivo.readLine())!= null){
                String[] funcao = line.split(";");
                String comando = funcao[0];
                System.out.println(Arrays.toString(funcao));
                switch(comando){
                    case "INSERIR":
                        String dadoin = funcao[1];
                        lista.Inserir_Elemento_Final(dadoin);
                        break;
                    case "REMOVER":
                        String dadodel = funcao [1];
                        lista.remover_elemento(dadodel);
                        break;
                    case "IMPRIMIR":
                        lista.Tela();
                        break;
                    case "BUSCAR":
                        String dadopes = funcao[1];
                        System.out.println("("+lista.Obter_Elemento(dadopes)+ ")");
                        break;
                        
                }
               } 
            arquivo.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //O processo serve para todas as outras estruturas
    
    public void Filas(BufferedReader arquivo){
        FilaDin<String> fila = new FilaDin<String>();
        try{
            String line; 
               while((line = arquivo.readLine())!= null){
                String[] funcao = line.split(";");
                String comando = funcao[0];
                System.out.println(Arrays.toString(funcao));

                switch(comando){
                    case "INSERIR":
                        String dadoin = funcao[1];
                        fila.Inserir_Elemento_Fila(dadoin);
                        break;
                    case "REMOVER":
                        String dadodel = funcao [1];
                        fila.Remover_Elemento_Fila(dadodel);
                        break;
                    case "IMPRIMIR":
                        fila.tela();
                        break;
                    case "BUSCAR":
                        String dadopes = funcao[1];
                        System.out.println("("+fila.Obter_Elemento(dadopes)+ ")");

                        break;
                        
                }
               } 
            arquivo.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Pilhas(BufferedReader arquivo){
        PilhaDin<String> pilha = new PilhaDin<String>();
        try{
            String line; 
               while((line = arquivo.readLine())!= null){
                String[] funcao = line.split(";");
                String comando = funcao[0];
                System.out.println(Arrays.toString(funcao));
                switch(comando){
                    case "INSERIR":
                        String dadoin = funcao[1];
                        pilha.Entrar_Elemento_Pilha(dadoin);
                        break;
                    case "REMOVER":
                        String dadodel = funcao [1];
                        pilha.Remover_Elemento_Pilha(dadodel);
                        break;
                    case "IMPRIMIR":
                        pilha.Tela();
                        break;
                    case "BUSCAR":
                        String dadopes = funcao[1];
                        System.out.println("("+pilha.Obter_Elemento(dadopes)+")");

                        break;
                        
                }
               } 
            arquivo.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Arvores(BufferedReader arquivo){
        ArvoreBin<String> arvore = new ArvoreBin<String>();
        try{
            String line; 
               while((line = arquivo.readLine())!= null){
                String[] funcao = line.split(";");
                String comando = funcao[0];
                System.out.println(Arrays.toString(funcao));

                switch(comando){
                    case "INSERIR":
                        String dadoin = funcao[1];
                        arvore.Inserir_Elemento(dadoin);
                        break;
                    case "REMOVER":
                        String dadodel = funcao[1];
                        arvore.remover(dadodel);
                        break;
                    case "IMPRIMIR":
                        arvore.Tela(1);
                        break;
                    case "BUSCAR":
                        String dadobu = funcao[1];
                        System.out.println("(" +arvore.Obter_elemento(dadobu)+")");
                        break;
                        
                }
               } 
            arquivo.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public String Titulo(BufferedReader leitor){
        try{
            String estrutura = leitor.readLine().toUpperCase();
            System.out.println("Estrutura:" + estrutura);
            return estrutura;
        
        }catch(IOException e){
            e.printStackTrace();
            
        }
        return null;
    }
    
}


    
