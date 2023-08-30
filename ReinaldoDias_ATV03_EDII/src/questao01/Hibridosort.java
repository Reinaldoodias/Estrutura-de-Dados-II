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
    public static void hibrido(int[] v1, int[] v2,int metade){
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
        int inicio = 0, fim =; 
        for (int i = inicio; i <= fim; i++) { aux[i] = dados[i]; }
        int i = inicio; int j = metade + 1; int k = inicio;
        while (i <= metade && j <= fim) {
            if (aux[i] <= aux[j]) {
                dados[k] = aux[i]; i++;

        } else {
            dados[k] = aux[j]; j++;
        }
               k++;
        }
        while (i <= meio) {// copia o resto do lado esquerdo
            dados[k] = aux[i]; k++; i++;\
           }
        while (j <= fim) {// copia o resto do lado direito
            dados[k] = aux[j]; k++; j++;
         }
}
        for(int k=0;k<metade;k++){
        System.out.println(v1[k]);
        System.out.println(v2[k]);
        }
        
    }
    
    public static void hibrid(int[] dados){
        int metade = (dados.length)/2;
        int v1[] = new int[metade];
        int v2[] = new int[metade];
        for(int i=0;i<metade;i++){
            v1[i]=dados[i];
        }
        for(int j=metade;j<dados.length;j++){
            v2[j-(metade)]=dados[j];
        }
        hibrido(v1, v2, metade);
    }
    
}
