
package Questao1;

import java.lang.Comparable;

/**
 *
 * @author Reinaldo Dias
 */
/**
 * Classe que representa um nó da arvore
 * @author Reinaldo Dias
 * @param <T> Tipo de dado a ser utilizado
 */
class nodeAr<T extends Comparable<T>>implements Comparable<nodeAr<T>>{
    private T dado;
    private nodeAr esq;
    private nodeAr dir;

/**
 * Construtor para iniciar os atributos
 * @param dado O dado a ser inserido nó
 */
    public nodeAr(T dado) {
        this.dado = dado;
        this.esq = null;
        this.dir = null;
    }
    //Getters e Setters
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public nodeAr getEsq() {
        return esq;
    }

    public void setEsq(nodeAr esq) {
        this.esq = esq;
    }

    public nodeAr getDir() {
        return dir;
    }

    public void setDir(nodeAr dir) {
        this.dir = dir;
    }
    
    public int compareTo(nodeAr<T> objeto){
      return this.dado.compareTo(objeto.dado);
    }
        
    
}
/**
 * Classe que representa a arvore binária
 * @author Reinaldo Dias
 * @param <T> Tipo de dado presente na arvore
 */
public class ArvoreBin<T extends Comparable<T>>{ 
    private nodeAr<T> raiz;
    private int tamanho;
/**
 * Construtor para inicializar os atributos
 */
    public ArvoreBin() {
        this.raiz = null;
        this.tamanho = 0;
    }
    //Getters e Setters
    public nodeAr getRaiz() {
        return raiz;
    }

    public void setRaiz(nodeAr raiz) {
        this.raiz = raiz;
    }
    
    
    public boolean Vazia_Arvore(){
        return (tamanho==0 && raiz==null);
    }
    /**
     * Método para criar a raiz da arvore
     * @param dado O dado a ser inserido no elemento
     */
    public void Criar_Raiz(T dado){
        nodeAr<T> novo = new nodeAr<>(dado);
        if(Vazia_Arvore()){
            setRaiz(novo);
        }  
        tamanho++;
    }
    /**
     * Método para cria ruma subarvore na direita da ultima subarvore a direta 
     * @param dado O dado a ser inserido no elemento
     */
    public void Criar_No_Dir(T dado){
        nodeAr<T> novo = new nodeAr<>(dado);
        nodeAr ultimo_Direita;
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }
        else{
            ultimo_Direita = Percorre_Direita(raiz);
            ultimo_Direita.setDir(novo);
        }
        tamanho++;
    }
    /**
     * Método para cria ruma subarvore na esquerda da ultima subarvore a esquerda
     * @param dado O dado a ser inserido no elemento
     */
    public void Criar_No_Esq(T dado){
        nodeAr<T> novo = new nodeAr<>(dado);
        nodeAr ultimo_Esquerda;
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }
        else{
            ultimo_Esquerda = Percorre_Esquerda(raiz);
            ultimo_Esquerda.setEsq(novo);
        }
        tamanho++;
    }
    /**
     * Método para criar um elemento à direita de um determinada subarvore
     * @param dado O dado do elemento a ser inserido
     * @param dado_Pai O dado da subarvore que terá um filha a direita
     */
    public void Criar_Dir_Pai(T dado, T dado_Pai){
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }else{
        nodeAr<T> novo = new nodeAr<>(dado);
        nodeAr Pai = Localiza_No(dado_Pai, raiz);
        if(Pai.getDir()==null){
            Pai.setDir(novo);
        }else{
            System.out.println("Essa posição já está ocupada!");
            tamanho--;
        }
        }
        tamanho++;
    }
    /**
     * Método para criar um elemento à direita de um determinada subarvore
     * @param dado O dado do elemento a ser inserido
     * @param dado_Pai O dado da subarvore que terá um filha a direita
     */
    public void Criar_Esq_Pai(T dado, T dado_Pai){
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }else{
        nodeAr novo = new nodeAr(dado);
        nodeAr Pai = Localiza_No(dado_Pai, raiz);
        if(Pai.getEsq()==null){
            Pai.setEsq(novo);
        }else{
            System.out.println("Essa posição já está ocupada!");
            tamanho--;
        }
        }
        tamanho++;
    }
    public void Inserir_Elemento(T dado){
        nodeAr novo = new nodeAr(dado);
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }
        else{
            Inserir_no(raiz, novo);
        }
    }
    
    private void Inserir_no(nodeAr aux, nodeAr novo){
        if(aux!=null){
            if(novo.getDado().compareTo(aux.getDado())!=-1){
                if(aux.getDir()==null){
                    aux.setDir(novo);
                }else{
                    Inserir_no(aux.getDir(), novo);
                }    
            }
        } else{
            if(aux.getEsq()==null){
                aux.setEsq(novo);
            }else{
                Inserir_no(aux.getEsq(), novo);
            }    
        }  
    }
    /*  
    public void Remover_No(T dado){
        if(Vazia_Arvore()){
            throw new RuntimeException("Arvore vazia!");
        }else{
            nodeAr excluido = Localiza_No(dado, raiz);
            nodeAr anterior = Localiza_No_anterior(dado, raiz);
            if(anterior.getDir()!=null && anterior.getDir()==excluido){
                if(excluido.getDir()==null){
                    anterior.setDir(excluido.getDir());
                }
                else if(anterior.getEsq()==null){
                    anterior.setEsq(excluido.getEsq());
                }
                excluido.setDir(null);
                excluido.setEsq(null);
                tamanho--;
            }
        }
    }
    */
    /**
     * Mpetodo para localizar uma subarvore e alterar seu dado
     * @param dado O dado da subarvore existente
     * @param novo_dado O dado para o qual será alterado
     */
    public void Alterar_No(T dado, T novo_dado){
        if(!Vazia_Arvore()){
            nodeAr alterar = Localiza_No(dado, raiz);
            alterar.setDado(novo_dado);
        }
    }
    /**
     * Método para percorrer a direita de uma determinada subarvore
     * @param aux Uma estrutura nó (subarvore) passada como parâmetro
     * @return Retorna o ultimo nó a direita da subarvore
     */
    private nodeAr Percorre_Direita(nodeAr aux){
        if(aux.getDir()== null){
            return aux;
        }else{
            return Percorre_Direita(aux.getDir());
        }
    }
    /**
     * Mesmo método de cima, omitido por simplicidade
     */
    private nodeAr Percorre_Esquerda(nodeAr aux){
        if(aux.getEsq()== null){
            return aux;
        }else{
           return Percorre_Direita(aux.getEsq());
        }
    }
    /** 
     * Método para localizar um determinado nó
     * @param dado O dado do elemento a ser encontrado
     * @param aux Nó passado como parâmetro para iniciar a busca
     * @return retorna um ponteiro sobre o nó com o dado
     */
    private nodeAr Localiza_No(T dado, nodeAr aux){
        if(aux.getDado().equals(dado) && aux!=null){
            return aux;
        }else{
            nodeAr encontrado = Localiza_No(dado, aux.getDir());
            if(encontrado!=null){
                return encontrado;
            }else{
            return Localiza_No(dado, aux.getEsq());
            }
        }
          
    }
    public T Obter_elemento(T dado){
        nodeAr mostrar = Localiza_No(dado, raiz);
        return (T) mostrar.getDado();
    }
    /**
     * Quase mesma logica do método acima, omitido por simplicidade
     */
    private nodeAr Localiza_No_anterior(T dado, nodeAr aux){
        if(aux.getDir().getDado().equals(dado) && aux.getDir()!=null || aux.getEsq().getDado().equals(dado)
           && aux.getEsq()!=null){
            return aux;
        }else{
            nodeAr encontrado = Localiza_No_anterior(dado, aux.getEsq());
            if(encontrado!=null){
                return encontrado;
            }
            return Localiza_No_anterior(dado, aux.getDir());
        }
    }
    public void Tela(){
        Display_preOrdem(raiz,0);
    }
    private void Display_preOrdem(nodeAr<T> aux, int nivel){
        if(aux!=null){
            for(int i=1;i<=nivel;i++,System.out.print("--"));
            System.out.println("" + aux.getDado());
            Display_preOrdem(aux.getEsq(),nivel+1);
            Display_preOrdem(aux.getDir(),nivel+1);
            
        }
    }
    
       
        
    
    
    
    
    
}
