// Classe Executavel do Programa
import Termo.Termo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tabelas.HashListaEncadeada;
import leitor.LeitorDoc;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) throws FileNotFoundException {
        String[] doc_name = {"O homem", "O animal", "O pensador"};
        String[] docs = {"O homem é o único animal que pensa que pensa", "Quem pensa O animal homem", "Se o homem pensa logo existe O homem existe porque pensa ou pensa porque existe"};
        int C=10;
        Termo t = new Termo();
        LeitorDoc doc_scan = new LeitorDoc();
        //t.readDocument(docs);
        HashListaEncadeada table = new HashListaEncadeada();
        //t.readArrayDocuments(docs,doc_name, table,C);
        File folder = new File("C:\\Users\\Matheus\\Downloads\\ED2-Trabalho1\\a"); 
        doc_scan.findAllFilesInFolder(folder, table,t, C);
        System.out.println(t.getFreq("o", table));
        
        
        /*MENU*/
    }
}
