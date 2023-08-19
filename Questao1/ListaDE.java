/*

 */
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */

/**
 * Classe que representa um nó da lista
 * @author Reinaldo Dias
 * @param <T> O tipo de dado armazenado
 */
class nodeLi<T> { 
    private T dado;
    private nodeLi antes;
    private nodeLi proximo;
    
    /**
     * Construtor usado para inicializar os atributos
     * @param dado O dado a ser armazenado nó
     */
    public nodeLi(T dado){
        this.dado = dado;
        this.antes = null;
        this. proximo = null;      
    }
    
    //Getters e Setters

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

/**
 * Classe que representa a lista duplamente encadeada
 * @author Reinaldo Dias
 * @param <T> Tipo de dado armazenado no nó
 */
class ListaDE<T> {
   private nodeLi primeiro;
   private nodeLi ultimo;
   private int tamanho;

   /**
    * Construtor da classe par ainicalizar os atributos
    */
   public ListaDE(){ 
       this.primeiro=null;
       this.ultimo = null;
       this.tamanho = 0;
            
   }
   //Getters e Setters
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
   
   public int Tamanho(){
       return tamanho;
   }
   /**
    * Método verifica se a lista está vazia
    * @return Retorna true se a lista estiver vazia
    */
   public boolean Vazia(){
       return (tamanho==0);
   }
   /**
    * Método para inserir um novo nó no final da lista
    * @param dado O dado a ser inserido no elemento
    */
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
   /**
    * Método para ainserir um novo nó no início da lista
    * @param dado O dado a ser inserido no elemento
    */
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
   /**
    * Método para remover um determinado elemento da lista
    * @param dado O dado do elemento a ser removido
    */
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
   /**
    * Método que localiza um elemento na lista e retorna o seu valor
    * @param dado O dado do elemento  a ser localizado
    * @return Retorna o valor do elemento achado
    */
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
