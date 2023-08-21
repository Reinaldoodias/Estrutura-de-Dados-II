/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
}

class DoisPontos {
    private double variavel = Double.MAX_VALUE;
    Ponto[] Pmenores = new Ponto[2];
    
    private double DistanciaPontos(Ponto first, Ponto second){
        double ordenadas = first.y - second.y;
        double abcissas = first.x - second.x;
        return Math.sqrt(Math.pow(abcissas, abcissas)+ Math.pow(ordenadas, ordenadas));
    }
  
    public double calculo(List<Ponto> lista, int inicio, int fim){
        if(inicio==fim){
            return Double.MAX_VALUE;
        } else{
            int metade = (int) (inicio+fim)/2;
            double calculoEsquerda = calculo(lista,inicio,metade);
            double calculoDireita = calculo(lista,metade+1,fim);
            double menordistancia = Math.min(calculoDireita, calculoEsquerda);
            
            for(int i=inicio;i<=metade;i++){
                for(int j=metade;j<=fim;j++){
                    double distancia = DistanciaPontos(lista.get(i), lista.get(j));
                    menordistancia = Math.min(menordistancia, distancia);
                    if(menordistancia<variavel){
                        variavel=menordistancia;
                        Pmenores[0] = lista.get(i);
                        Pmenores[1] = lista.get(j);
                        System.out.println(Pmenores[0]);

                    }
                }    
            }
            return (double) menordistancia;
        }
    }
        
    public static void main(String[] args){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\questao2\\entrada.txt"));
            String line;
            DoisPontos base = new DoisPontos();
            List<Ponto> pontos = new ArrayList<>();
            while((line = leitor.readLine())!= null){
                String[] coordenada = line.split(";");
               int vetorX = Integer.parseInt(coordenada[0]);
               int vetorY = Integer.parseInt(coordenada[1]);
               Ponto momento = new Ponto(vetorX, vetorY);
               pontos.add(momento);
            }
            
            System.out.println(base.calculo(pontos, 0,   pontos.size()));
            leitor.close();
        }catch(IOException e){
            e.printStackTrace();
        }    
    }
    
    
    
    
    
}
