/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Packages;

/**
 * Função de teste da estrutura
 * @author Reinaldo Dias
 */
public class Run {
    public static void main(String [] args){
        ArvoreSplay<Integer> tree = new ArvoreSplay<>();
        tree.inserir(45);
        tree.inserir(83);
        tree.inserir(76);
        
        tree.imprimir();
        tree.buscar(45);
        tree.imprimir();
        
        
    }
    
}
