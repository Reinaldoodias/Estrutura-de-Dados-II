/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinaldodias_atv01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author 20221SI0029
 */
public class LeituraArquivo {
    

    BufferedReader leitor = new BufferedReader(new FileReader("exec.txt")));
    String linha;
    while(linha = leitor.readLine()!= null){
        String[] parte = linha.split(";");
    }
}
