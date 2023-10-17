/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1;
/**
 * Esse Arquivo(.java) contém a TAD tabela Hash com a implementação de suas funções fundamentais, dentre outras implementadas para resolver problemas específicos.
 * @author Reinaldo Dias
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import questao3.Calculos;
/**
 * Essa classe reprenta a implementação de uma tabela hash.
 * @author Reinaldo Dias
 * @param <K> Tipo de dado genérico para representar a Chave
 * @param <V> Tipo de dados genérico para representar o Valor
 */
public class TabelaHash<K, V> {
    private int tamanho;
    private ListaDE<Entrada<K, V>>[] tabela;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = (ListaDE<Entrada<K, V>>[]) new List[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaDE<>();
        }
    }
/**
 * Classe interna que representa um para Chave-Valor armazenado na tabela.
 * @param <K> Tipo de dado genérico para representar a Chave.
 * @param <V> Tipo de dados genérico para representar o Valor.
 */
    private static class Entrada<K, V> {
        K chave;
        V valor;
        public Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
/**
 * Método da Tabela Hash desenvolvido excluisivo para a questão 02 para não alterar os objetos que vão possuir o mesmo Hashcode e armazenálos no mesmo índice.
 */
    public void inserir_Q2(K chave, V valor) {
        int indice = calcularIndice(chave);
        ListaDE<Entrada<K, V>> bucket = tabela[indice];
        bucket.Inserir_Elemento_Final(new Entrada<K, V>(chave, valor));
    }
/**
 * Método da Tabela Hash que é responsável por inserir um para chave-valor na tabela em uma posição calculada.
 * @param chave Representa uma chave (Generics) única e de preferência não nula de um objeto que o identifique.
 * @param valor Representa as informações do objeto (Generics).
 */
    public void inserir(K chave, V valor) {
        int indice = calcularIndice(chave);
        ListaDE<Entrada<K, V>> bucket = tabela[indice];
        for (int i=0;i<bucket.Tamanho();i++) {
            Entrada<K,V> entrada = bucket.Obter_peloindice(i);
            if (entrada.chave.equals(chave)) {
                entrada.valor = valor;
                return;
            }
        }
        bucket.Inserir_Elemento_Final(new Entrada<K, V>(chave, valor));
        reHash();
    }
/**
 * Método da Tabela Hash responsável pela pesquisa de um objeto, obtendo sua posição através de uma calculo aritmético.
 * @param chave Parâmetro utilizado para calcular a posição do objeto.
 * @return Caso o elemento esteja na tabela retorna as informações (Valor) do objeto, caso não esteja retorna 'null'.
 */
    public V obter(K chave) {
        int indice = calcularIndice(chave);
        ListaDE<Entrada<K, V>> bucket = tabela[indice];
        for (int i=0;i<this.tamanho;i++) {
            Entrada<K,V> entrada = bucket.Obter_peloindice(i);
            if (entrada.chave.equals(chave)) {
                return entrada.valor;
            }
        }
        return null;
    }
/**
 * Método da Tabela Hash utilizado para remover um determinado objeto.
 * @param chave Parâmetro(identificador único e não nulo) utilizado para localizar um objetos.
 */
    public void remover(K chave) {
        int indice = calcularIndice(chave);
        ListaDE<Entrada<K, V>> bucket = tabela[indice];
        for (int i=0;i<this.tamanho;i++) {
            Entrada<K,V> entrada = bucket.Obter_peloindice(i);
            if (entrada.chave.equals(chave)) {
                bucket.remover_elemento(entrada);
                return;
            }
        }
    }
/**
 * Método cujo objetivo é calcular o Hashcode de cada objeto
 * @param chave O calculo é feito usando a chave, normalmente um inteiro.
 * @return A Chave multiplicada por 3
 */    
    private int hashCode(K chave){
        String key = (String) chave;
        int inteiro=1;
        for(int i=0;i<key.length();i++){
            inteiro *= key.charAt(i);
        }
        return inteiro;
    }
/**
 * Método para calcular o índice de um objeto na tabela Hash utilizando o hashcode, de forma que o indice é constante para uma determinada chave.
 * @param chave O calculo é feito usando a chave, normalmente um inteiro.
 * @return retorna um índice dentro dos limites da tabela.
 */
    public int calcularIndice(K chave) {
        int codigoHash = hashCode(chave);
        return Math.abs(codigoHash % tamanho);  
    }
/**
 * Método cuja função é imprimir todos os buckets da tabela Hash mostrando seus elementos.
 */    
    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            ListaDE<Entrada<K, V>> bucket = tabela[i];
            if (bucket!=null) {
                System.out.println("\t|BUCKET (" + i + "):");
                for (int j=0;j<bucket.Tamanho();j++) {
                    Entrada<K,V> entrada = bucket.Obter_peloindice(j);
                    System.out.println("\t|-> Chave: " + entrada.chave + "| Valor: " + entrada.valor);
                }
            }else{
                System.out.println("\t|BUCKET (" + i + "):" + "null");
            }  
        }
    }
/**
 * Método desenvolvido para questão 02. Verifica e armazena em um arrayList todos os elementos que se repetem em algum momento.
 * @return Retorna o arrayList com todos os elementos que se repetem.
 */
    public ArrayList<V> duplicados(){
        ArrayList<V> duplicados = new ArrayList<>();
        int i,j,r;
        for(i=0; i<tamanho;i++){
            ListaDE <Entrada<K, V>> bucket = tabela[i];
            if(bucket!=null && bucket.Tamanho()>1){
                for(j=0;j<bucket.Tamanho();j++){
                    for(r=j+1;r<bucket.Tamanho();r++){
                        if(bucket.Obter_peloindice(j).valor.equals(bucket.Obter_peloindice(i).valor) && !duplicados.contains(bucket.Obter_peloindice(j).valor)){
                            duplicados.add((V) bucket.Obter_peloindice(j).valor);
                            break;
                        }
                    }
                }
                
            }
        }
        return (ArrayList<V>) duplicados;
    }
/**
 * Método recursivo que percorre todos os buckets da tabela contanto todos os elementos.
 * @param indice A posição da tabela onde haverá a contagem, inicalizada com '0'.
 * @return Retorna a soma total de elementos presentes nos buckets.
 */   
    public int contaElementos(int indice){
        if(indice<this.tamanho){
            return tabela[indice].Tamanho() + contaElementos(indice+1);
        }else{
            return 0;
        }
    }
/**
 * Método REHASHING  utilizada para aumentar a tabela conforme o necessário (caso atinja 75% de sua capacidade).
 */
    public void reHash(){
        if(contaElementos(0)*100/this.tamanho > 75){
            int newSize = Calculos.tamanhoTabela(this.tamanho);
            TabelaHash<K,V> novaTabela = new TabelaHash<>(newSize);
            for(int i=0;i<tamanho;i++){
                for(Entrada<K,V> entrada : bucket){
                    novaTabela.inserir(entrada.chave, entrada.valor);
                }
            }
            this.tabela = novaTabela.tabela;
            this.tamanho = novaTabela.tamanho;
        } 
    }   
}

