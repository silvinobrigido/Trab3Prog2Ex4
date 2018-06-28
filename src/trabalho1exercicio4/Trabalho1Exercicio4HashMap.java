/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1exercicio4;

import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class Trabalho1Exercicio4HashMap implements IContador{

    /**
     * @param args the command line arguments
     */
    //Criar outra classe que use a collection; 
    //Esta usa HashMap está Ok.
    
    public static void main(String[] args) {       
        System.out.println(new Trabalho1Exercicio4HashMap().contar("Eu estou escrevendo um programa, mas eu não tenho um programa para escrever"));
    }
    
    public static void qtdadeVezesHashMap(String str){
        HashMap mapa = new HashMap < String, Integer >(); 
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
             String palavra = st.nextToken();
             palavra = palavra.replace(',', ' ');
             palavra = palavra.trim();
             palavra = palavra.toLowerCase(Locale.getDefault());
            if (mapa.containsKey(palavra)){
              int contador = (int) mapa.get(palavra); // Obtem contagem atual
              mapa.put( palavra, contador+1); // Incrementa a contagem
            } else{
              mapa.put( palavra, 1);  
            }
        }
        Set<String> chaves = mapa.keySet();
        for(String a :chaves){
            if(a != null)
				System.out.println("A palavra '" + a +"' foi apresentada "+ mapa.get(a) + " vezes na frase");
		}        
        }      

    @Override
    public String contar(String frase) { //ok 
        HashMap mapa = new HashMap < String, Integer >(); 
        StringTokenizer st = new StringTokenizer(frase);
        while(st.hasMoreTokens()){
             String palavra = st.nextToken();
             palavra = palavra.replace(',', ' ');
             palavra = palavra.trim();
             palavra = palavra.toLowerCase(Locale.getDefault());
            if (mapa.containsKey(palavra)){
              int contador = (int) mapa.get(palavra); // Obtem contagem atual
              mapa.put( palavra, contador+1); // Incrementa a contagem
            } else{
              mapa.put( palavra, 1);  
            }
        }
        String valor = "[";
        Set<String> chaves = mapa.keySet();
        for(String a :chaves){
            if(a != null){
		 System.out.println(a + mapa.get(a));
                  valor+= a +"-"+ mapa.get(a)+";";
            }
		}
        return valor+"]";
    }    
    }

    

