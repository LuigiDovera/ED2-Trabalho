// Classe Executavel do Programa
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tabelas.HashListaEncadeada;


public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        String[] docs = {"O homem é o único animal que pensa que pensa", "Quem pensa O animal homem", "Se o homem pensa logo existe O homem existe porque pensa ou pensa porque existe"};
        
        Termo t = new Termo();
        //t.readDocument(docs);
        HashListaEncadeada table = new HashListaEncadeada();
        t.readArrayDocuments(docs, table);
        System.out.println(t.getFreq("homem", table));
    }
}
