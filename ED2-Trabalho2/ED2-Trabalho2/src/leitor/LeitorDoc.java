/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitor;

import Termo.Termo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//import jdk.jpackage.internal.IOUtils;
import tabelas.Estrutura;
import leitor.Normalizador;
import java.util.Collections;

/**
 *
 * @author Matheus
 */
public class LeitorDoc<Key, Value> {

    public static String lerDoc(File Nome) throws FileNotFoundException {
        String docString = "";
        Scanner in = new Scanner(Nome);
        while (in.hasNextLine()) {
            docString += in.nextLine();
        }
        return docString;
    }

    public <T extends Estrutura<Key, Value>> HashMap<String, Integer> findAllFilesInFolder(File folder, Estrutura estrutura, Termo t, int C) throws FileNotFoundException {
        List<String> doc_names = new ArrayList<String>();
        List<String> doc_content = new ArrayList<String>();
        int Ndoc = 0;
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                doc_names.add(file.getName());
                doc_content.add(lerDoc(file));
                Ndoc++;
            } else {
                findAllFilesInFolder(file, estrutura, t, C);
            }
        }
        return t.readArrayDocuments(doc_content, doc_names, Ndoc, estrutura, C);
    }

    public <T extends Estrutura<Key, Value>> List<String> findAllFilesInFolder(File folder, int C) throws FileNotFoundException {
        List<String> doc_names = new ArrayList<String>();
        List<String> doc_content = new ArrayList<String>();
        List<String> palavras = new ArrayList<String>();
        List<String> aux;
        int Ndoc = 0;
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                doc_names.add(file.getName());
                doc_content.add(lerDoc(file));
                Ndoc++;
            } else {
                findAllFilesInFolder(file, C);
            }
        }

        for (String doc : doc_content) {
            palavras.addAll(Normalizador.apenasCLetras(Normalizador.normalizarParaLista(doc, C), C, true));
        }

        aux = palavras;
        palavras = new ArrayList<String>();
        for (String palavra : aux) {
            boolean palavraExiste = false;
            for (String palavraUnica : palavras) {
                if (palavraUnica.equals(palavra)) {
                    palavraExiste = true;
                    break;
                }
            }
            if (!palavraExiste) {
                palavras.add(palavra);
            }

        }

        java.util.Collections.sort(palavras);

        return palavras;
    }

}
