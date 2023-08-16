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
public class run {
    public static void main(String[] args){
        FilaDin<Integer> fila = new FilaDin();
        
        fila.Inserir_Elemento_Fila(1);
        fila.Inserir_Elemento_Fila(2);
        fila.Inserir_Elemento_Fila(4);
        fila.Sair_Elemento_Fila();
        fila.tela();
    }
}