
package Questao1;

/**
 *
 * @author Reinaldo Dias
 */
class nodeAr<T>{
    private T dado;
    private nodeAr esq;
    private nodeAr dir;

    public nodeAr(T dado) {
        this.dado = dado;
        this.esq = null;
        this.dir = null;
    }

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
    
    
}
public class ArvoreBin<T>{ 
    private nodeAr raiz;
    private int tamanho;

    public ArvoreBin() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public nodeAr getRaiz() {
        return raiz;
    }

    public void setRaiz(nodeAr raiz) {
        this.raiz = raiz;
    }
    
    
    public boolean Vazia_Arvore(){
        return (tamanho==0 && raiz==null);
    }
    
    public void Criar_Raiz(T dado){
        nodeAr novo = new nodeAr(dado);
        if(Vazia_Arvore()){
            setRaiz(novo);
        }  
        tamanho++;
    }
    public void Criar_No_Dir(T dado){
        nodeAr novo = new nodeAr(dado);
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
    
    public void Criar_No_Esq(T dado){
        nodeAr novo = new nodeAr(dado);
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
    
    public void Criar_Dir_Pai(T dado, T dado_Pai){
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }else{
        nodeAr novo = new nodeAr(dado);
        nodeAr Pai = Localiza_No(dado_Pai, raiz);
        if(Pai.getDir()==null){
            Pai.setDir(novo);
        }else{
            throw new RuntimeException ("Essa posição já está ocupada!");
        }
        }
        tamanho++;
    }
    
    public void Criar_Esq_Pai(T dado, T dado_Pai){
        if(Vazia_Arvore()){
            Criar_Raiz(dado);
        }else{
        nodeAr novo = new nodeAr(dado);
        nodeAr Pai = Localiza_No(dado_Pai, raiz);
        if(Pai.getEsq()==null){
            Pai.setEsq(novo);
        }else{
            throw new RuntimeException ("Essa posição já está ocupada!");
        }
        }
        tamanho++;
    }
    
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
    
    public void Alterar_No(T dado, T novo_dado){
        if(!Vazia_Arvore()){
            nodeAr alterar = Localiza_No(dado, raiz);
            alterar.setDado(novo_dado);
        }
    }
    
    public nodeAr Percorre_Direita(nodeAr aux){
        if(aux.getDir()== null){
            return aux;
        }else{
            return Percorre_Direita(aux.getDir());
        }
    }
    
    public nodeAr Percorre_Esquerda(nodeAr aux){
        if(aux.getEsq()== null){
            return aux;
        }else{
           return Percorre_Direita(aux.getEsq());
        }
    }
        
    public nodeAr Localiza_No(T dado, nodeAr aux){
        if(aux.getDado() == dado){
            return aux;
        }else{
            Localiza_No(dado, aux.getDir());
            Localiza_No(dado, aux.getEsq());
        }
         return null;       
    }
    
    public nodeAr Localiza_No_anterior(T dado, nodeAr aux){
        if(aux.getDir().getDado()==dado && aux.getDir()!=null || aux.getEsq().getDado()==dado
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
    
    public void Tela(nodeAr aux){
        if(aux!=null){
            System.out.println("-->" + aux.getDado());
            Tela(aux.getEsq());
            Tela(aux.getDir());
        }
    }
        
        
    
    
    
    
    
}
