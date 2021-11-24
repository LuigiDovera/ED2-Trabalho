// Classe Executavel do Programa

import InsertSort.InsertSort;
import Ordenacoes.*;
import Dados.*;
import java.lang.Comparable;
import Ordenacoes.MergeSort;
import Ordenacoes.MergeSortPadrão;
import Ordenacoes.QuickSort;
import Leitura.Leitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        
        
        
        long start, elapsed;
        List<Long> timer = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        List arr_list;
        ArrayList arr_ArrayList;
        sizes.add(1000);
        sizes.add(10000);
        //sizes.add(100000);
        //sizes.add(250000);
        //sizes.add(500000);
        //sizes.add(1000000);
        
        boolean verbose = false;
        Integer Batch_size = 100;
        List<String> lista = new ArrayList<>();
        lista.add("MergeSortPadrao");
        lista.add("MergeSort");
        lista.add("QuickSort");
        lista.add("JDKMergeSort");
        lista.add("JDKQuickSort");
        
        long  Operacoes=0;
        
        System.out.println("Batch Size: " + Batch_size);
        for(String Metodo : lista){
            System.out.println("Metodo " + Metodo);
            for (int size = 0;size<sizes.size();size++){
                
            timer.clear();
            Dado1[] arr1 = Leitor.leitor1(sizes.get(size));
            System.out.println("VETOR COM "+ sizes.get(size) + " Elementos");

            //----DADO1----------------------------
            if(verbose){
             System.out.println("----DADO1----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr1[i].getChave() + ", " + arr1[i].getValor());
             System.out.println("...\n\n");
            }
            
            if( null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        Operacoes = MergeSortPadrão.sort(arr1,1);
                        System.out.println("Operacoes: " + Operacoes);
                        break;
                    case "MergeSort":
                        Operacoes = MergeSort.sort(arr1,1);
                        System.out.println("Operacoes: " + Operacoes);
                        break;
                    case "QuickSort":
                        Operacoes = QuickSort.sort(arr1, 1);
                        System.out.println("Operacoes: " + Operacoes);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr1);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr1);
                        break;
                    default:
                        break;
                }
            if(verbose){  
             System.out.println("----DADO1----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr1[i].getChave() + ", " + arr1[i].getValor());
             System.out.println("...\n\n");
            }
            
            for(int i=0; i<Batch_size;i++){
                arr1 = Leitor.leitor1(sizes.get(size));
                start = System.currentTimeMillis();
            if( null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        MergeSortPadrão.sort(arr1,1);
                        break;
                    case "MergeSort":
                        MergeSort.sort(arr1,1);
                        break;
                    case "QuickSort":
                        QuickSort.sort(arr1, 1);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr1);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr1);
                        break;
                    default:
                        break;
                }
                elapsed = System.currentTimeMillis() - start;
                timer.add(elapsed);
            }


            System.out.printf("<Dado1>Média Aritimética: %.3f ms +-(%.3f) %n",(Utils.mediaAritimetica(timer)),(Utils.variancia(timer)));


            Dado2[] arr2 = Leitor.leitor2(sizes.get(size));

            timer.clear();
            if(verbose){
             //----DADO2----------------------------
             System.out.println("----DADO2----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr2[i].getChave() + ", " + arr2[i].getValor());
             System.out.println("...\n\n");
            }
            if( null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        MergeSortPadrão.sort(arr2,1);
                        break;
                    case "MergeSort":
                        MergeSort.sort(arr2,1);
                        break;
                    case "QuickSort":
                        QuickSort.sort(arr2, 1);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr2);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr2);
                        break;
                    default:
                        break;
                }
            if(verbose){
             System.out.println("----DADO2----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr2[i].getChave() + ", " + arr2[i].getValor());
             System.out.println("...\n\n");
            }

            for(int i=0; i<Batch_size;i++){
                arr2 = Leitor.leitor2(sizes.get(size));
                start = System.currentTimeMillis();
                if(null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        MergeSortPadrão.sort(arr2,1);
                        break;
                    case "MergeSort":
                        MergeSort.sort(arr2,1);
                        break;
                    case "QuickSort":
                        QuickSort.sort(arr2, 1);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr2);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr2);
                        break;
                    default:
                        break;
                }
                elapsed = System.currentTimeMillis() - start;
                timer.add(elapsed);
            }

            System.out.printf("<Dado2>Média Aritimética: %.3f ms +-(%.3f) %n",(Utils.mediaAritimetica(timer)),(Utils.variancia(timer)));




            Dado3[] arr3 = Leitor.leitor3(sizes.get(size));
            timer.clear();
            if(verbose){
             //----DADO3----------------------------
             System.out.println("----DADO3----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr3[i].getChave() + ", " + arr3[i].getValor());
             System.out.println("...\n\n");
            }
            if( null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        MergeSortPadrão.sort(arr3,1);
                        break;
                    case "MergeSort":
                        MergeSort.sort(arr3,1);
                        break;
                    case "QuickSort":
                        QuickSort.sort(arr3, 1);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr3);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr3);
                        break;
                    default:
                        break;
                }
                   
            if(verbose){
             System.out.println("----DADO3----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr3[i].getChave() + ", " + arr3[i].getValor());
             System.out.println("...\n\n");
            }


            for(int i=0; i<Batch_size;i++){
               arr3 = Leitor.leitor3(sizes.get(size));
               start = System.currentTimeMillis();
            if( null!=Metodo)switch (Metodo) {
                    case "MergeSortPadrao":
                        MergeSortPadrão.sort(arr3,1);
                        break;
                    case "MergeSort":
                        MergeSort.sort(arr3,1);
                        break;
                    case "QuickSort":
                        QuickSort.sort(arr3, 1);
                        break;
                    case "JDKMergeSort":
                        arr_list = Arrays.asList(arr3);
                        arr_ArrayList = new ArrayList(arr_list);
                        Collections.sort(arr_list);
                        break;
                    case "JDKQuickSort":
                        Arrays.sort(arr3);
                        break;
                    default:
                        break;
                }
                elapsed = System.currentTimeMillis() - start;
                timer.add(elapsed);
            }
            System.out.printf("<Dado3>Média Aritimética: %.3f ms +-(%.3f) %n",(Utils.mediaAritimetica(timer)),(Utils.variancia(timer)));

        }   
        
        System.out.println("----------------------------------------------------------");
        }
 
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
        System.out.println("Após Chamado do Quicksort otimizado\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...");
    }
    
    public <T extends Comparable<T>> void mergeInsertSort(int tamanho, int ordem){
        Dado2[] arr = Leitor.leitor2(tamanho);
        

        System.out.println("Ordem Inicial Vetor com "+ tamanho +" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...\n\n");

        MergeSort.sort(arr, ordem);
        System.out.println("Após Chamado do Merge-Insert Sort otimizado\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...");
        
    }
    
    public <T extends Comparable<T>> void mergeSort(int tamanho, int ordem){
        
        Dado2[] arr = Leitor.leitor2(tamanho);

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
        Dado2[] arr = Leitor.leitor2(tamanho);
        TreeSort ts = new TreeSort();
        
        System.out.println("Ordem Inicial Vetor com "+tamanho+" elementos\n\n");
        for (int i = 0; i < 10; i++)
            System.out.println("Vetor[" + i + "]= " + arr[i].getChave());
        System.out.println("...\n\n");

        ts.inserirArray(arr, ordem);
        
        System.out.println("Após Chamado do Tree Sort\n\n");
        ts.inordemPrint(ts.getRoot());
        
        System.out.println("...");
    }



}
