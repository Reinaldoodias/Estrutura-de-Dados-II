/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao01;

/**
 *
 * @author 20221SI0029
 */
public class Hibridosort {
     
    
    public static int[] hibrid(int[] dados){
        int metade = (dados.length)/2;
        int v1[] = new int[metade];
        int v2[] = new int[metade];
        for(int i=0;i<metade;i++){
            v1[i]=dados[i];
        }
        for(int j=metade;j<dados.length;j++){
            v2[j-(metade)]=dados[j];
        }
        for(int a=0;a<metade;a++){
            for(int b=0;b<metade-1-a;b++){
                if(v1[b]>v1[b+1]){
                    int aux = v1[b];
                    v1[b] = v1[b+1];
                    v1[b+1] = aux;
                }
                if(v2[b]>v2[b+1]){
                    int aux = v2[b];
                    v2[b] = v2[b+1];
                    v2[b+1] = aux;
                }
            }      
        }
        int i=0, j=metade;
        System.out.println("metade" + metade);
        while(i<metade){
            dados[i] = v1[i]; i++;
        }
        while(j<dados.length){
            dados[j] = v2[j-metade]; j++;
        }
        return dados;
        
        
    }
}

