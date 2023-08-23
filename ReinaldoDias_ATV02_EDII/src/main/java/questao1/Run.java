/**
 * 
 */

package questao1;

/**
 *
 * @author Reinaldo Dias
 */
public class Run {
    public static void main (String[] args){
        int[] listabinaria = {1,0,1,0,1,0,1,0,1,0,1,1};
        System.out.println(calculo(listabinaria,0,listabinaria.length-1));
    }
    
    public static int calculo(int[] vetor,int inicio, int fim){
        if(inicio<=fim){
            int metade = (int)(inicio + fim)/2;
            if(vetor[metade]==1){
                return 1 + calculo(vetor,metade+1,fim) + calculo(vetor,inicio,metade-1);
            }
            else if(vetor[metade]==0){
                return calculo(vetor,metade+1,fim) + calculo(vetor,inicio,metade-1);
            }
        }

        return 0;
    }
    
}


