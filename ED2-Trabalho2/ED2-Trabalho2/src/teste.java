
import java.io.FileNotFoundException;
import Arvores.AVLTree;
import Arvores.RBTree;
import Document.Document;
import Termo.Termo;
import arvores.BTree;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import tabelas.HashListaEncadeada;
import leitor.LeitorDoc;
import leitor.Normalizador;
import tabelas.Estrutura;
import tabelas.HashTentativaQuadratica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luigi
 */
public class teste {
    public static <T extends Comparable<T>> void main(String[] args) throws FileNotFoundException {
    
        //String[] doc_name = {"O homem", "O animal", "O pensador"};
        //String[] docs = {"O homem é o único animal que pensa que pensa", "Quem pensa O animal homem", "Se o homem pensa logo existe O homem existe porque pensa ou pensa porque existe"};
        int C=5;
        Termo t = new Termo();
        LeitorDoc doc_scan = new LeitorDoc();
        //t.readDocument(docs);
        HashListaEncadeada table = new HashListaEncadeada();
        //t.readArrayDocuments(docs,doc_name, table,C);
        File folder = new File("C:\\Users\\Luigi\\Desktop\\git\\ED2-Trabalho1\\ED2-Trabalho2\\documentos"); 
        doc_scan.findAllFilesInFolder(folder, table,t, C);
        //System.out.println(t.getFreq("covi", table));
        HashMap<String, Integer> DistTermperDoc = doc_scan.findAllFilesInFolder(folder, table,t, C);
        //System.out.println("main:" + DistTermperDoc.get("1.txt"));

        //System.out.println("freq:" +  t.getFreq("homem", table));

        ArrayList<String> termos = new ArrayList();
        //termos.add("homem");
        termos.add("covi");
        ArrayList<Document> documentos = t.DocumentRL(termos, table, DistTermperDoc);
        for(Document doc : documentos){
            System.out.println("Nome: " + doc.getNome() + " Peso: " + doc.getPeso());
        }
        
        //DistTermperDoc.foreach();
    }
    
    
}
