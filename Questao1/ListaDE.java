/*

 */
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */

class nodeLi<T> { //Classe que representa um nó com seus atributos
    private T dado;
    private nodeLi antes;
    private nodeLi proximo;
    
    public nodeLi(T dado){ //contrutor usado para inicializar os atributos
        this.dado = dado;
        this.antes = null;
        this. proximo = null;      
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public nodeLi getAntes() {
        return antes;
    }

    public void setAntes(nodeLi antes) {
        this.antes = antes;
    }

    public nodeLi getProximo() {
        return proximo;
    }

    public void setProximo(nodeLi proximo) {
        this.proximo = proximo;
    }
    
}

class ListaDE<T> {//Faz o papel da struct em C
   private nodeLi primeiro;
   private nodeLi ultimo;
   private int tamanho;

   public ListaDE(){ //Construtor da classe
       this.primeiro=null;
       this.ultimo = null;
       this.tamanho = 0;
            
   }

    public nodeLi getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(nodeLi primeiro) {
        this.primeiro = primeiro;
    }

    public nodeLi getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodeLi ultimo) {
        this.ultimo = ultimo;
    }
   
   
   public int Tamanho(){//Retorna o tamanho da lista
       return tamanho;
   }
   
   public boolean Vazia(){//retorna se a lista estiver vazia
       return (tamanho==0);
   }
   
   public void Inserir_Elemento_Inicio(T dado){//Insere um elemento na lista
       nodeLi novo = new nodeLi(dado);
      if(Vazia()){
         setPrimeiro(novo);
         setUltimo(novo);
      }
      else{
         novo.setProximo(primeiro);
         primeiro.setAntes(novo);
         setPrimeiro(novo);
      }
       tamanho++;
   }
   
   public void Inserir_Elemento_Final(T dado){//Insere um elemento na lista
       nodeLi novo = new nodeLi(dado);
      if(Vazia()){
         setPrimeiro(novo);
         setUltimo(novo);
      }
      else{
          ultimo.setProximo(novo);
          novo.setAntes(ultimo);
          setUltimo(novo);
         
      }
       tamanho++;
   }
   
   public void remover_elemento(T dado){
       if(Vazia()){
            throw new RuntimeException("A lista está vazia!");//Não há elementos
       }
       else{
            nodeLi aux = primeiro;
            nodeLi apagar = Localiza_elemento(aux, dado);  
            if(apagar.equals(primeiro)&& apagar.getProximo()!=null){
                setPrimeiro(apagar.getProximo());
                apagar.setProximo(null);
            }else if(apagar == ultimo && apagar.getProximo()==null){
                apagar.getAntes().setProximo(null);
                apagar.setAntes(null);
            }else if(apagar!=ultimo && apagar!=primeiro){
                apagar.getAntes().setProximo(apagar.getProximo());
                apagar.getProximo().setAntes(apagar.getAntes());
                apagar.setAntes(null);
                apagar.setProximo(null);
                
            }
            tamanho--;
       }
   }
   
   public nodeLi Localiza_elemento(nodeLi aux, T dado){
       if(aux!=null && aux.getDado().equals(dado)){
           return aux;
       }else if(aux==null){
                throw new RuntimeException ("Elemento não encontrado!");
       }else{
                return Localiza_elemento(aux.getProximo(), dado);
       }
       
   }
   
  public T Obter_Elemento(T dado){
       nodeLi aux = getPrimeiro();
       while(aux!=null && dado!=aux.getDado()){
            aux = aux.getProximo();
            if(aux.getDado().equals(dado)){
                return (T) aux.getDado();
                   }
       }
      return null;
   }
   
    public void Tela(){
        nodeLi atual = primeiro;
        while(atual!=null){
            System.out.println(atual.getDado() + " ");
            atual=atual.getProximo();
        }
    }
   
   
  
   
   
    
}
