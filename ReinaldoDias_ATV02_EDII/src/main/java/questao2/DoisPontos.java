/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reinaldo Dias
 */

class Ponto{
    int x,y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}

class DoisPontos {
    /**
     * Formula para calcular distância entre dois pontos
     * @param first O ponto 1
     * @param second O Ponto 2
     * @return Retorna o resultado da formula aplicada em dois pontos
     */
    private double DistanciaPontos(Ponto first, Ponto second){
        double ordenadas = first.y - second.y;
        double abcissas = first.x - second.x;
        return Math.sqrt(Math.pow(abcissas, 2)+ Math.pow(ordenadas, 2));
    }
    
    /**
     * método para descobria a menor distancia dos pontos da lista
     * @param lista A lista dos pontos
     * @param inicio Daonde vai iniciar o calculo para achar o menor
     * @param min O mínimo ponto encontrado
     * @return Retorna a menor distancia entre dois pontos
     */
    public double calculo(List<Ponto> lista, int inicio, double min){
        if(inicio<lista.size()-1){
            double menor = DistanciaPontos(lista.get(inicio),lista.get(inicio+1));
            if(menor<min){
                min= menor; 
            }
            return calculo(lista, inicio+1,min);
        }
        return min;
        
    }
    /**
     * Mesmo cálculo do método anterior, porém agora amazena os dois pontos
     * @return Retorna os dois pontos mais próximos
     */
    public Ponto[] retornapontos(List<Ponto> lista, int inicio, double min,Ponto[] pontos){
        if(inicio<lista.size()-1){
            double menor = DistanciaPontos(lista.get(inicio),lista.get(inicio+1));
            if(menor<min){
                min= menor;
                pontos[0] = lista.get(inicio);
                pontos[1] = lista.get(inicio+1);
            }
            return retornapontos(lista, inicio+1, min, pontos);
        }
        
        return pontos;
    }
    
    
    
    
    
    
}
