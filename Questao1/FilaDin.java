/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */

/**
 * Classe que representa um nó da Fila
 * @author Reinaldo Dias
 * @param <T> Tipo de dado armazenado
 */
class nodeFi<T>{
   private T dado;
   private nodeFi<T> proximo;
   /**
    * Construtor para inicializar os atributos
    * @param dado O dado do elemento
    */
    public nodeFi(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
    //Getters e Setters
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public nodeFi getProximo() {
        return proximo;
    }

    public void setProximo(nodeFi proximo) {
        this.proximo = proximo;
    }
    
}
/**
 * Classe que representa uma Fila dinâmica 
 * @author Reinaldo Dias
 * @param <T> O tipo de dado a ser armazenado na fila
 */
class FilaDin<T>{
   private int tamanho;
   private nodeFi primeiro;//Primeiro a entrar
   private nodeFi ultimo;//Ultimo a entrar
   /**
    * Construtor que inicializa os atributos 
    */
    public FilaDin() {
        this.tamanho = tamanho = 0;
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }
    //Gettters e Setters
    public nodeFi getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(nodeFi primeiro) {
        this.primeiro = primeiro;
    }

    public nodeFi getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodeFi ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean Vazia_Fila(){
        return (tamanho==0);
    }
    
    /**
     * Método par inserir elemento na fila usando o método FIFO
     * @param dado 
     */
    public void Inserir_Elemento_Fila(T dado){
        nodeFi novo = new nodeFi(dado);
        if(Vazia_Fila()){
            setPrimeiro(novo);
            setUltimo(novo);
        }
        else{
            ultimo.setProximo(novo);
            setUltimo(novo);
        }
        tamanho++;
    }
    /**
     * Retira um elemento da Fila usando o método FIFO
     * @return 
     */
    public T Sair_Elemento_Fila(){
        if(Vazia_Fila()){
            throw new RuntimeException ("A lista está vazia!");
        }
        else{
            nodeFi aux = primeiro;
            setPrimeiro(primeiro.getProximo());
            aux.setProximo(null);
            tamanho --;
            return (T) aux.getDado();
        }
    }
    /**
     * Remove um determinado elemento da Fila 
     * @param dado O dado do elemento a ser removido
     */
    public void Remover_Elemento_Fila(T dado){
        if(Vazia_Fila()){
            throw new RuntimeException ("A lista está vazia!");
        }
        else{
            nodeFi apagar = Localiza_Elemento_Fila(dado, getPrimeiro());
            if(apagar.equals(primeiro)){
                setPrimeiro(apagar.getProximo());
                apagar.setProximo(null);
            }
            else if(apagar.equals(ultimo)){
                nodeFi previous = Localiza_Elemento_Anterior(dado, primeiro);
                setUltimo(previous);
                ultimo.setProximo(null);
            }
            else{
                nodeFi previous = Localiza_Elemento_Anterior(dado, primeiro);
                previous.setProximo(apagar.getProximo());
                apagar.setProximo(null);
            } 
        }
    }
    /**
     * Método que localiza e retorna um elemento
     * @param dado O dado do elemento a ser pesquisado
     * @return Retorna o valor do elemento
     */
    public T Obter_Elemento(T dado){
       nodeFi aux = getPrimeiro();
       while(aux!=null && dado!=aux.getDado()){
            aux = aux.getProximo();
            if(aux.getDado().equals(dado)){
                return (T) aux.getDado();
                   }
       }
      return null;
   }
    
    public nodeFi Localiza_Elemento_Fila(T dado,nodeFi aux){
        if(aux!= null && aux.getDado().equals(dado)){
             return aux;
        }else if(aux==null){
            throw new RuntimeException ("Elemento não encontrado!");
        }else{
            return Localiza_Elemento_Fila(dado, aux.getProximo());
        }
    }
    
    public nodeFi Localiza_Elemento_Anterior(T dado,nodeFi aux){
        if(aux!=null & aux.getDado().equals(dado)){
            return aux;
        }else if(aux==null){
            throw new RuntimeException ("Elemento não encontrado!");
        }else{
            return Localiza_Elemento_Anterior(dado, aux.getProximo());
        }
    }
    /**
     * Método para obter o primeiro da Fila
     * @return Retorna o Primeiro da Fila
     */
    public T Obter_Primeiro(){
        if(!Vazia_Fila()){
            return (T) primeiro.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    /**
     * Método para obter o primeiro da Fila 
     * @return Retorna o primeiro da Fila
     */
    public T Obter_Ultimo(){
        if(!Vazia_Fila()){
            return (T) ultimo.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    
    public void tela(){
        nodeFi aux = primeiro;
        while(aux!=null){
            System.out.println("-->" + aux.getDado());
            aux = aux.getProximo();
        }
    }
}