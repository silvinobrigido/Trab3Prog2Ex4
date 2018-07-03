/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1exercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Leorcon
 */
public class ContadorCollection implements IContador {

    @Override
    public String contar(String frase) {
        LinkedList<String> linked = new LinkedList<>();
        frase = frase.toLowerCase();
        frase = frase.replaceAll(",", " ");
        frase = frase.replaceAll("[.]", " ");
        frase = frase.replaceAll(" - ", " ");
        frase = frase.replaceAll("!", " ");
        frase = frase.replaceAll("[?]", " ");
        frase = frase.replaceAll(";", " ");
        StringTokenizer st = new StringTokenizer(frase);
        int linkedPosicao[] = new int[st.countTokens()];
        int posicao = 0;
        while (st.hasMoreTokens()) {
            String palavra = st.nextToken();
            palavra = palavra.trim();
            int index = 0;

            for (int i = 0; i < linked.size(); i++) {
                if (linked.get(i).equals(palavra)) {
                    index = i;
                }
            }

            if (linked.contains(palavra)) {
                linkedPosicao[index]++;
            } else {
                linked.add(palavra);
                linkedPosicao[posicao] = 1;
                posicao++;
            }
        }
        Collections.sort(linked);
        String valor = "[";
        int contador = 0;
        for (String o : linked) {
            if (contador == linked.size() -1) {
                valor += o + "-" + linkedPosicao[contador];
            } else {
                valor += o + "-" + linkedPosicao[contador] + "; ";
                contador++;
            }
            /*if (linked.size() -1 == contador) {
                valor += o;
            } else {
                valor += o + ";";
                contador++;
            }*/
        }
        return valor + "]";
    }
}
