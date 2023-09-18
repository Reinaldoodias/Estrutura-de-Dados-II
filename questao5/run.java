/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package questao5;

/**
 *
 * @author Aluno DCOMP
 */
public class run {

    public static void main(String[] args) {
        int zeros =0;
        int X[] = {0, 2, 0, 3, 0, 5, 6, 0,0};
        int Y[] = {1, 8, 9, 10, 15};
        
        for(int i=0;i<X.length;i++){
            if(X[i]==0){
                zeros++;  
            }
        }
        
        
            try {
                if (X.length >= Y.length && zeros == Y.length) {
                    for (int j = 0; j < X.length; j++) {
                        if (X[j] == 0) {
                        X[j] = Y[Y.length - zeros];
                        zeros--;
                        }
                    }
                    for (int a = 0; a < X.length; a++) {
                        for (int b = 0; b < X.length - a - 1; b++) {
                            if (X[b] > X[b + 1]) {
                                int aux = X[b];
                                X[b] = X[b + 1];
                                X[b + 1] = aux;
                            }
                        }
                    }
                } else {
                    throw new RuntimeException("Os vetores não estão com as diretrizes corretas");
                }
            } catch (RuntimeException e) {
                System.out.println("Exceção capturada: " + e.getMessage());
            }
    }
}







