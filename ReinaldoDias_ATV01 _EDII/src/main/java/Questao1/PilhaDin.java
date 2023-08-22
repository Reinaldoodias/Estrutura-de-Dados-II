/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */

/**
 * 
 * @author Reinaldo Dias
 * @param <T> o tipo de dado armazanado no nó(é genérico)
 */
class nodePi<T>{
    private T dado;
    private nodePi proximo;

    /**
     * 
     * @param dado O dado a ser armazanado no nó
     */
   public nodePi (T dado){
       this.dado = dado;
       this.proximo = null;
   }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public nodePi getProximo() {
        return proximo;
    }

    public void setProximo(nodePi proximo) {
        this.proximo = proximo;
    }
   
}

/**
 * Classe que define uma pilha dinâmica genérica
 * @author Reinaldo Dias
 * @param <T> tipo de dado armazenado na pilha
 */
class PilhaDin<T>{
    private int tamanho;
    private nodePi primeiro;//primeiro da pilha
    private nodePi ultimo;//ultimo da pilha
/**
 * Construtor que inicializa os atributos da pilha
 */
    public PilhaDin() {
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }
    //Getters and Setters

    public nodePi getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(nodePi primeiro) {
        this.primeiro = primeiro;
    }

    public nodePi getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodePi ultimo) {
        this.ultimo = ultimo;
    }
    
    
    /**
     * Método que retorna true caso a pilha estiver Vazia
     * @return 
     */
    public boolean Vazia_Pilha(){
        return (tamanho==0);
    }
        
    /**
     * Método que adiciona um elemento na pilha
     * @param dado O dado a ser inserido na pilha
     */
    public void Entrar_Elemento_Pilha(T dado){//Adiciona um elemento na Pilha
        nodePi novo = new nodePi(dado);
        if(Vazia_Pilha()){
            setPrimeiro(novo);
            setUltimo(novo);
            novo.setProximo(null);
        }else{
            ultimo.setProximo(novo);
            setUltimo(novo);
        }
        tamanho++;
    } 
    /**
     * Funçao para retirar o elemento da pilha usando o método LIFO
     * @return 
     */
    public T Sair_Elemento_Pilha(){
        if(!Vazia_Pilha()){
            nodePi saindo = ultimo;
            setUltimo(Localiza_Elemento_Anterior((T) saindo.getDado(),primeiro));
            ultimo.setProximo(null);
            tamanho--;
            return (T) saindo.getDado();
        } 
        return null;
    }
    /**
     * Função para remover um determinado elemento da pilha
     * @param dado O dado a ser removido da pilha
     */
    public void Remover_Elemento_Pilha(T dado){//Remove um elemento da pilha apenas com o dado fornacido
        if(!Vazia_Pilha()){
            nodePi delete, anterior;
            delete = Localiza_Elemento(dado, primeiro);
            if(delete.equals(primeiro)){
                setPrimeiro(primeiro.getProximo());
                delete.setProximo(null);
            }else{
               anterior = Localiza_Elemento_Anterior(dado, primeiro);
               anterior.setProximo(delete.getProximo());
               delete.setProximo(null);
            }
                
            tamanho--;
        }
            
    }
    /**
     * Função para localizar um elemento na pilha e retornar seu valor
     * @param dado O dado a ser localizado
     * @return retorna o valor do dado
     */
    public T Obter_Elemento(T dado){
       nodePi aux = Localiza_Elemento(dado, primeiro);
       return (T) aux.getDado();
      
   }
    
    public nodePi Localiza_Elemento(T dado, nodePi aux){//Localiza qualquer elemento
        if(aux!= null && aux.getDado().equals(dado)){
             return aux;
        }else if(aux==null){
            return null;
        }else{
            return Localiza_Elemento(dado, aux.getProximo());
        } 
    }
    
    public nodePi Localiza_Elemento_Anterior(T dado, nodePi aux){//Localiza o anterior de um nó(Reformular a pilha)
        if(aux!=null && aux.getProximo()!=null && aux.getProximo().getDado().equals(dado)){
            return aux;
        }else if(aux==null){
            return null;
        }else{
            return Localiza_Elemento_Anterior(dado, aux.getProximo());
        }
    }
    /**
     * Método para saber o ultimo elemento da pilha
     * @return Retorna o valor do elemento
     */
    public T Obter_Ultimo(){
       if(!Vazia_Pilha()){
            return (T) primeiro.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    /**
     * Método para saber o elemento topo
     * @return retorna o valor do primeiro elemento
     */
    public T Obter_Topo(){
        if(!Vazia_Pilha()){
            return (T) ultimo.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    
     public void Tela(){
        nodePi atual = ultimo;
        while(atual!=null){
            System.out.println(atual.getDado());
            atual = Localiza_Elemento_Anterior((T) atual.getDado(), primeiro);   
        }
    }
    
}

    


