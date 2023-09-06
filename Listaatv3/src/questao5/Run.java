/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao5;

/**
 *
 * @author 20221Si0029
 */
public class Run {
    public static void main(String []args){
        int[] v1 = {0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] v2 = {1, 8, 9, 10, 15};
        hibrid(v1,v2);
        for(int i=0;i<10;i++){
            System.out.println(v1[i]);
        }
        for(int i=0;i<10;i++){
            System.out.println(v2[i]);
        }
    }
    
   
     
    
    public static void hibrid(int[] v1, int[] v2){
        if(v1.length<v2.length){
            for(int i=0;i<v1.length;i++){
                if(v1[i]==0){
                    for(int j=i;j<v1.length;j++){
                        v1[j]=v1[j+1];
                    }
                    
                }
            }
            for(int a=0;a<v1.length;a++){
                for(int b=0;b<v1.length-1-a;b++){
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
      
        }
    }
}


