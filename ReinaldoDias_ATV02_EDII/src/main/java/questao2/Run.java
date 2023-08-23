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
public class Run {
    public static void main(String[] args){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("src\\main\\java\\questao2\\entrada.txt"));
            String line; int con =1;
            DoisPontos base = new DoisPontos();
            Ponto[] jojo = new Ponto[2];

            List<Ponto> pontos = new ArrayList<>();
            while((line = leitor.readLine())!= null){
                String[] coordenada = line.split(";");
               int vetorX = Integer.parseInt(coordenada[0]);
               int vetorY = Integer.parseInt(coordenada[1]);
               Ponto momento = new Ponto(vetorX, vetorY);
               pontos.add(momento);
            }
            
            jojo = base.retornapontos(pontos, 0, Double.MAX_VALUE, jojo);
            for(Ponto valor : jojo){
                System.out.print("P" + con + "(" + valor.getX() + "," + valor.getY() + ")");
                if(con==1){
                    System.out.print(" e ");
                }
                con++;
            }
            System.out.println(": D(" + base.calculo(pontos, 0,   Double.MAX_VALUE)+")");

            leitor.close();
        }catch(IOException e){
            e.printStackTrace();
        }    
    }
}
