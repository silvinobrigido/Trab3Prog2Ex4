/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1exercicio4;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 *
 * @author User
 */
public class ContadorMap implements IContador {

    /**
     * @param args the command line arguments
     */
    //Esta usa LinkedHashMap está faltando apenas ajuste da ordem alfabética.
    public static void main(String[] args) {
        System.out.println("Map");
        System.out.println(new ContadorMap().contar("Eu estou escrevendo um programa, mas eu não tenho um programa para escrever"));
        System.out.println("Collection");
        System.out.println(new ContadorCollection().contar("Eu estou escrevendo um programa, mas eu não tenho um programa para escrever"));
    }

    @Override
    public String contar(String frase) { //ok 
        LinkedHashMap mapa = new LinkedHashMap< String, Integer>();
        StringTokenizer st = new StringTokenizer(frase);
        while (st.hasMoreTokens()) {
            String palavra = st.nextToken();
            palavra = palavra.replace(',', ' ');
            palavra = palavra.trim();
            palavra = palavra.toLowerCase(Locale.getDefault());
            if (mapa.containsKey(palavra)) {
                int contador = (int) mapa.get(palavra); // Obtem contagem atual
                mapa.put(palavra, contador + 1); // Incrementa a contagem
            } else {
                mapa.put(palavra, 1);
            }
        }
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
        treeMap.putAll(mapa);
        int contador = 0;
        String valor = "[";        
        for (String a : treeMap.keySet()) {
            if (a != null) {
                if (contador == treeMap.size() - 1) {
                    valor += a + "-" + treeMap.get(a);
                } else {
                    valor += a + "-" + treeMap.get(a) + ";";
                    contador++;
                }
            }
        }     
        return valor + "]";
    }
}
