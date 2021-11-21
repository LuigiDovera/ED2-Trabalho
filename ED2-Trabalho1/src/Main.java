// Classe Executavel do Programa

import InsertSort.InsertSort;
import Ordenacoes.MergeSort;
import Dados.*;
import java.lang.Comparable;
import Ordenacoes.MergeSortPadrão;
import Ordenacoes.QuickSort;
import Leitura.Leitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        long start, elapsed;
        List<Long> timer = new ArrayList<Long>();
        List<Integer> sizes = new ArrayList<Integer>();
        sizes.add(1000);
        sizes.add(10000);
        sizes.add(100000);
        sizes.add(500000);
        sizes.add(1000000);
        boolean verbose = false;
        Integer Batch_size = 1;
        List<String> lista = new ArrayList<String>();
        lista.add("MergeSortPadrao");
        lista.add("MergeSort");
        lista.add("QuickSort");
        int Operacoes=0;
        
        System.out.println("Batch Size: " + Batch_size);
        for(String Metodo : lista){
            System.out.println("Metodo " + Metodo);
            for (int size = 0;size<sizes.size();size++){
            
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
                        break;
                    case "MergeSort":
                        Operacoes = MergeSort.sort(arr1,1);
                        break;
                    case "QuickSort":
                        Operacoes = QuickSort.sort(arr1, 1);
                        break;
                    default:
                        break;
                }
            System.out.println("Operacoes: " + Operacoes);
            if(verbose){  
             System.out.println("----DADO1----------------------------\n");
             for (int i = 0; i < 10; i++)
                 System.out.println("Vetor[" + i + "]= " + arr1[i].getChave() + ", " + arr1[i].getValor());
             System.out.println("...\n\n");
            }
            
            for(int i=0; i<Batch_size;i++){
                arr1 = Leitor.leitor1(sizes.get(size));
                start = System.currentTimeMillis();
            if(Metodo=="MergeSortPadrao"){
                MergeSortPadrão.sort(arr1,1);
            }else if(Metodo == "MergeSort"){
                MergeSort.sort(arr1,1);
            }
            else if(Metodo == "QuickSort"){
                QuickSort.sort(arr1, 1);
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
            if(Metodo=="MergeSortPadrao"){
                MergeSortPadrão.sort(arr1,1);
            }else if(Metodo == "MergeSort"){
                MergeSort.sort(arr1,1);
            }
            else if(Metodo == "QuickSort"){
                QuickSort.sort(arr1, 1);
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
                if(Metodo=="MergeSortPadrao"){
                    MergeSortPadrão.sort(arr1,1);
                }else if(Metodo == "MergeSort"){
                    MergeSort.sort(arr1,1);
                }
                else if(Metodo == "QuickSort"){
                    QuickSort.sort(arr1, 1);
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
            if(Metodo=="MergeSortPadrao"){
                MergeSortPadrão.sort(arr1,1);
            }else if(Metodo == "MergeSort"){
                MergeSort.sort(arr1,1);
            }
            else if(Metodo == "QuickSort"){
                QuickSort.sort(arr1, 1);
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
            if(Metodo=="MergeSortPadrao"){
                MergeSortPadrão.sort(arr1,1);
            }else if(Metodo == "MergeSort"){
                MergeSort.sort(arr1,1);
            }
            else if(Metodo == "QuickSort"){
                QuickSort.sort(arr1, 1);
            }
                elapsed = System.currentTimeMillis() - start;
                timer.add(elapsed);
            }
            System.out.printf("<Dado3>Média Aritimética: %.3f ms +-(%.3f) %n",(Utils.mediaAritimetica(timer)),(Utils.variancia(timer)));

        }   
        
           
        }
 
    }



}
