package Packages;

/**
 * Implementação de Árvore binária Splay
 * @author Reinaldo Dias
 * @param <T> Tipo de dado genérico
 */
public class ArvoreSplay <T extends Comparable<T>> {
    private Node<T> raiz;
    private int tamanho = 0; //Quantidade de nós da arvore
/**
 * Função para modificar a raiz
 * @param raiz Raiz da árvore
 */
    public void setRaiz(Node<T> raiz) {
        this.raiz = raiz;
    }
   //Funções Públicas
/**
 * Essa função insere um novo nó na árvore
 * @param dado O valor que nó terá do tipo genérico
 */    
   public void inserir(T dado){
         Node<T> novo = new Node<>(dado,null);
        if(Vazia_Arvore()){
            setRaiz(novo);
        }
        else{
            Inserir_no(raiz, novo);   
            splay(novo);
        }
        tamanho++;
    }
/**
 * Esse método realiza um busca de um elemento na árvore e 'splaya' o elemento
 * @param dado O valor que o nó terá do tipo genérico
 * @return Retorna o valor
 */ 
    public T buscar(T dado){
        Node alvo = splay(Localiza(raiz, dado));
        if(alvo!=null){
        return (T) alvo.getChave();
        }else{
            System.out.println("elemento não presente na árvore");
            return null;
        }      
    }
/**
 * Método público para imprimir a arvore, chama a função de impressão.
 */
    public void imprimir(){
        preOrdem(raiz,0);
    }
/**
 * Método público pra chamar a função 'remover recursivo'
 * @param dado Informação que o nó que será escluído armazena
 */    
    public void remover(T dado){
        if(Localiza(raiz, dado) != null){
        raiz = removerRecursivo(splay(Localiza(raiz,dado)), dado);
        }else{
            System.out.println("Elemento não presente na árvore");
        }
        
  
    }
/**
 * Função para verificar se a arvore se encontra vazia.
 * @return Retorna 'true' caso esteja e 'false' se tiver algum elemento.
 */  
    private boolean Vazia_Arvore(){
        return (tamanho==0 && raiz==null);
    }
    // Métodos privados
/**
 * Realiza a função de rotação simples a direita, ajustando os ponteiros.
 * @param node O nó da árvore em que será alvo da rotação.
 */    
    private void zig (Node<T> node){
       Node<T> esquerdo = node.getEsq();
       node.setEsq(esquerdo.getDir());
       if(node.getEsq() != null){
           node.getEsq().setAnt(node);
       }
       esquerdo.setDir(node);
       esquerdo.setAnt(node.getAnt());
       atualizafilhos(node,esquerdo);
       node.setAnt(esquerdo);       
    }
/**
 * Realiza a função de rotação simples a esquerda, ajustando os ponteiros.
 * @param node O nó da árvore em que será alvo da rotação.
 */ 
    private void zag (Node<T> node){
       Node<T> direito = node.getDir();
       node.setDir(direito.getEsq());
       if(node.getDir() != null){
           node.getDir().setAnt(node);
       }
       direito.setEsq(node);
       direito.setAnt(node.getAnt());
       atualizafilhos(node,direito);
       node.setAnt(direito);       
    }
/**
 * Função para ajustar ponteiros e atualizar os filhos d eum nó
 * @param node Nó alvo de alguma rotaçãos
 * @param tempnode Nó temporário para ajuste de ponteiro
 */  
    private void atualizafilhos(Node<T> node, Node<T> tempnode){
        if(node.getAnt()==null){
            raiz = tempnode;
        }else if(node.filhoaesquerda()){
            node.getAnt().setEsq(tempnode);
        }else{
            node.getAnt().setDir(tempnode);
        }
    }
 
/**
 * Método Splay para reformular a árvore conforme o elemento buscado o transferindo para a raiz
 * @param no O nó que contém um elemento que deseja ser buscado
 * @return retrona o nó a ser buscado quando ele estiver na raiz
 */
    private Node<T> splay (Node<T> no){
        if(no != null)
            if(no != raiz){
                if(no.retornaAvo()== null){//ZIG || ZAG
                    if(no.filhoaesquerda())
                        zig(no.getAnt());
                    else
                        zag(no.getAnt());
                } else if(no.filhoaesquerda() && no.getAnt().filhoaesquerda()){//ZIG-ZIG
                    zig(no.retornaAvo());
                    zig(no.getAnt());
                } else if(no.filhoadireita() && no.getAnt().filhoadireita()){//ZAG-ZAG
                    zag(no.retornaAvo());
                    zag(no.getAnt());
                }else if(no.filhoaesquerda() && no.getAnt().filhoadireita()){
                    zig(no.getAnt());
                    zag(no.getAnt());
                }else{
                    zag(no.getAnt());
                    zig(no.getAnt());
                }
                return splay(no);
            }
        return no;
    }
/**
 * Metodo recursivo para localizar na arvore um determinado nó
 * @param aux o nó pasado como parâmetro, inicia-se na 'raiz'
 * @param dado O valor que o nó a ser localizado armazena.
 * @return retorna o endereço sobre uma estrutura Node que armazena o dado
 */
    private Node<T> Localiza(Node<T> aux, T dado){
        if(aux!=null){
            if(aux.getChave().equals(dado)){
                return aux;
            }
            Node<T> proximo = dado.compareTo(aux.getChave())>=0? aux.getDir():aux.getEsq();
            return Localiza(proximo, dado); 
        }
        return null;
    }
/**
 * Insere um nó caso a árvore tenha mais de 1 elemento de acordo com as diretrizes de uma árvore binária
 * @param aux Nó passado como parâmetro, inicia ana raiz
 * @param novo Novo nó armazendando a informação
 */ 
    private void Inserir_no(Node<T> aux, Node<T> novo){
        if(aux!=null){
            if(novo.compareTo(aux) >= 0){
                if(aux.getDir()==null){
                    aux.setDir(novo);
                    novo.setAnt(aux);
                    

                }else{
                    Inserir_no(aux.getDir(), novo);
                }    
            }else{
                if(aux.getEsq()==null){
                    aux.setEsq(novo);
                    novo.setAnt(aux);
                    


                }else{
                    Inserir_no(aux.getEsq(), novo);
                }    
            }
        }
    }
/**
 * Método recursivo para remover um determinado nó da árvore de forma que atenda as orientações de uma árvore binária
 * @param atual Nó passado como parâmetro, inicia na raiz.
 * @param dado Dado que se quer excluir
 */  
    private Node<T> removerRecursivo(Node<T> atual, T dado) {
        if (atual == null) {
            return null;
        }
        
        int comparacao = dado.compareTo(atual.getChave());
        
        if (comparacao < 0) {
            atual.setEsq(removerRecursivo(atual.getEsq(), dado));
            atual.getEsq().setAnt(atual);
        } else if (comparacao > 0) {
            atual.setDir(removerRecursivo(atual.getDir(), dado));
            atual.getDir().setAnt(atual);
        
        } else {
            // Nó a ser removido encontrado
            if (atual.getEsq() == null) {
                this.tamanho--;
                return atual.getDir();
            } else if (atual.getDir() == null) {
                this.tamanho--;
                return atual.getEsq();
            }
            

            Node<T> sucessor = encontrarSucessor(atual.getDir());
            atual.setChave(sucessor.getChave());
            atual.setDir(removerRecursivo(atual.getDir(), sucessor.getChave()));
            atual.getEsq().setAnt(atual);
            
        }

        return atual;
    }
/**
 * Método auxiliar da função 'removerRecursivo' para encontrar o nó que irá substituir
 * @param atual nó no qual se quer achar um sucessor
 * @return retorna o sucessor
 */
    private Node<T> encontrarSucessor(Node<T> atual) {
        while (atual.getEsq() != null) {
            atual = atual.getEsq();
        }
        return atual;
    }

/**
 * Imprimir a arvore em pre-ordem: Raiz-esquerda-Direita
 * @param aux
 * @param nivel 
 */  
    @SuppressWarnings("empty-statement")
    private void preOrdem(Node<T> aux, int nivel){
        if(aux!=null){
            for(int i=1;i<=nivel;i++,System.out.print("--"));
            System.out.println("" + aux.getChave());
            preOrdem(aux.getEsq(),nivel+1);
            preOrdem(aux.getDir(),nivel+1);
            
        }
    } 
}   
    
    

