/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinaldodias_atv01;

/**
 *
 * @author 20221SI0029
 */

class nodeFi<T>{
   private T dado;
   private nodeFi<T> proximo;

    public nodeFi(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

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

class FilaDin<T> {
   private int tamanho;
   private nodeFi primeiro;//Primeiro a entrar
   private nodeFi ultimo;//Ultimo a entrar

    public FilaDin() {
        this.tamanho = tamanho = 0;
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }
    
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
    
    public void Inserir_Elemento_Fila(int dado){
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
    
    public void Sair_Elemento_Fila(){
        if(Vazia_Fila()){
            throw new RuntimeException ("A lista está vazia!");
        }
        else{
            nodeFi aux = primeiro;
            setPrimeiro(primeiro.getProximo());
            aux.setProximo(null);
            tamanho --;
            aux.getDado();
        }
    }
    
    public void Localiza_Elemento_Fila(T dado,nodeFi aux){
        
        if(aux.getDado() == dado){
             aux.getDado();
        }else{
            Localiza_Elemento_Fila(dado, aux.getProximo());
        }
    }
    
    public void Obter_Primeiro(){
        getPrimeiro();
    }
    public void Obter_Ultimo(){
        getUltimo();
    }
    
    public void tela(){
        nodeFi aux = primeiro;
        while(aux!=null){
            System.out.println("-->" + aux.getDado());
            aux = aux.getProximo();
        }
    }
    
}
