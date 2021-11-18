// Classe Executavel do Programa

import InsertSort.InsertSort;
import Ordenacoes.*;
import Dados.*;
import java.lang.Comparable;
import Leitura.Leitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
      
        treeSort(30000, 1);
        
    }
    
    public <T extends Comparable<T>> void quicksort(int tamanho, int ordem){
        
        Dado1[] arr = Leitor.leitor1(tamanho);
        

        System.out.println("Ordem Inicial Vetor com "+ tamanho +" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave() + ", " + arr[i].getValor());
        System.out.println("...\n\n");

        //MergeSort.sort(arr,1);
        //MergeSortPadrão.sort(arr,-1);
        QuickSort.sort(arr, ordem);
        System.out.println("Após Chamado do MergeSort otimizado\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...");
    }
    
    public <T extends Comparable<T>> void mergeInsertSort(int tamanho, int ordem){
        Dado1[] arr = Leitor.leitor1(tamanho);
        

        System.out.println("Ordem Inicial Vetor com "+ tamanho +" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...\n\n");

        MergeSort.sort(arr, ordem);
        System.out.println("Após Chamado do MergeSort otimizado\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...");
        
    }
    
    public <T extends Comparable<T>> void mergeSort(int tamanho, int ordem){
        
        Dado3[] arr = Leitor.leitor3(tamanho);

        System.out.println("Ordem Inicial Vetor com "+tamanho+" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...\n\n");

        MergeSortPadrão.sort(arr, ordem);

        System.out.println("Após Chamado do MergeSort otimizado\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...");
    }
    
    public static <T extends Comparable<T>> void treeSort(int tamanho, int ordem){
        Dado1[] arr = Leitor.leitor1(tamanho);
        TreeSort ts = new TreeSort();
        
        System.out.println("Ordem Inicial Vetor com "+tamanho+" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...\n\n");

        ts.treeins(arr);

        System.out.println("Após Chamado do MergeSort otimizado\n\n");
        ts.inorderRec(ts.getRoot());
        System.out.println("...");
    }



}
