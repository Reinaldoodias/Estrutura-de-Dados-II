package Packages;

/**
 * Classe para representar um nó de um árvore binária Splay
 * @author Reinaldo Dias
 * @param <T> Tipo de dado genérico
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
  private T chave;
  private Node<T> esq; // Nó Esquerdo
  private Node<T> dir; // Nó direito
  private Node<T> ant; // Nó anterior
  //Construtor
    public Node(T chave, Node<T> pai) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;
        this.ant = pai;
    }
    //Getters e setters
    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;
    }

    public Node<T> getEsq() {
        return esq;
    }

    public void setEsq(Node<T> esq) {
        this.esq = esq;
    }

    public Node<T> getDir() {
        return dir;
    }

    public void setDir(Node<T> dir) {
        this.dir = dir;
    }

    public Node<T> getAnt() {
        return ant;
    }

    public void setAnt(Node<T> ant) {
        this.ant = ant;
    }
 
    @Override
    public int compareTo(Node<T> objeto){
      return this.chave.compareTo(objeto.chave);
    }
/**
 * Método para verificar o avô de um nó
 * @return Retorna o avô do nó
 */
    public Node<T> retornaAvo(){
        Node<T> pai = this.getAnt();
        return (this.getAnt() != null)? pai.getAnt():null;
    }
/**
 * Verifica se um nó é filho à direita do seu pai
 * @return retorna 'true' caso seja
 */
    public boolean filhoadireita(){
        return this == ant.getDir();
    }
/**
 * Verifica se um nó é filho a esquerda do seu pai.
 * @return retorna 'true' caso seja
 */
    public boolean filhoaesquerda(){
        return this == ant.getEsq();
    }

}
