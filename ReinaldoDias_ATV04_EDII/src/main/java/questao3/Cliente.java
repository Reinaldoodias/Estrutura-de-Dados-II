/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

/**
 * Classe para representar um cliente conforme dados da questão.
 * @author Reinaldo Dias
 */
public class Cliente {
    private String idcliente;
    private String nome;
    private String email;
    private String cidade;
/*Construtot para inicilaizar o Objeto*/
    public Cliente(String idcliente, String nome, String email, String cidade) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }
/*Getters e Setters*/
    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "{" + "idcliente=" + idcliente + "| nome=" + nome + "| email=" + email + "| cidade=" + cidade + '}';
    }
    
    
            
}
