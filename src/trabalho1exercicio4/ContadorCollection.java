/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1exercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Leorcon
 */
public class ContadorCollection implements IContador{

    @Override
    public String contar(String frase) {
        HashMap mapa = new HashMap < String, Integer >(); 
        LinkedList<String> linked = new LinkedList<String>();
        StringTokenizer st = new StringTokenizer(frase);
        while(st.hasMoreTokens()){
             String palavra = st.nextToken();
             palavra = palavra.replace(',', ' ');
             palavra = palavra.trim();
             palavra = palavra.toLowerCase(Locale.getDefault());
             
            if (linked.contains(palavra)){
              String[] a = linked.get(linked.indexOf(palavra)).split("-");// Obtem contagem atual
              int contador = Integer.parseInt(a[1]) +1;
              /*mapa.put( palavra, contador+1); // Incrementa a contagem*/
              linked.add(palavra + "-" +contador);
            } else{
              linked.add(palavra + "-1");
            }
        }
        String valor = "[";
        Set<String> chaves = mapa.keySet();
        for(String a :chaves){
            if(a != null){
		valor+= a +"-"+ mapa.get(a)+";";
            }
		}
        return valor+"]";
    }    
}
