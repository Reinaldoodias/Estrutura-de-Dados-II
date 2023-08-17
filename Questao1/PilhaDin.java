/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */
class nodePi<T>{
    private T dado;
    private nodePi proximo;
    
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

class PilhaDin<T>{
    private int tamanho;
    private nodePi primeiro;//primeiro da pilha
    private nodePi ultimo;//ultimo da pilha

    public PilhaDin() {// Inicializar os atributos
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
    
    
    
    public boolean Vazia_Pilha(){//retorna true se a Pilha estiver Vazia
        return (tamanho==0);
    }
        
    
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
    public T Obter_Elemento(T dado){
       nodePi aux = getPrimeiro();
       while(aux!=null && dado!=aux.getDado()){
            aux = aux.getProximo();
            if(aux.getDado().equals(dado)){
                return (T) aux.getDado();
                   }
       }
      return null;
   }
    
    public nodePi Localiza_Elemento(T dado, nodePi aux){//Localiza qualquer elemento
        if(aux!= null && aux.getDado().equals(dado)){
             return aux;
        }else if(aux==null){
            throw new RuntimeException ("Elemento não encontrado!");
        }else{
            return Localiza_Elemento(dado, aux.getProximo());
        } 
    }
    
    public nodePi Localiza_Elemento_Anterior(T dado, nodePi aux){//Localiza o anterior de um nó(Reformular a pilha)
        if(aux!=null && aux.getProximo().getDado().equals(dado)){
            return aux;
        }else if(aux==null){
            throw new RuntimeException ("Elemento não encontrado!");
        }else{
            return Localiza_Elemento_Anterior(dado, aux.getProximo());
        }
    }
    
    public T Obter_Ultimo(){
       if(!Vazia_Pilha()){
            return (T) primeiro.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    
    public T Obter_Topo(){
        if(!Vazia_Pilha()){
            return (T) ultimo.getDado();
        }else{
            throw new RuntimeException("Fila Vazia");
        }
    }
    
     public void Tela(){
        nodePi atual = primeiro;
        while(atual!=null){
            System.out.println(atual.getDado() + " ");
            atual=atual.getProximo();
        }
    }
    
}

    


