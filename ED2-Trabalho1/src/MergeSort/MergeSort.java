package MergeSort;

import Dados.Dado1;
import InsertSort.InsertSort;

import javax.management.ObjectName;
import javax.sound.midi.SysexMessage;
import java.security.PrivilegedAction;
import java.util.ArrayList;

public class MergeSort {
    static int op=0;

    public static <T extends Comparable<T>> int sort(T[] vetor){
        T[] auxiliar = vetor.clone();
        mergesort(auxiliar,vetor,0,vetor.length);
        return op;
    }

    public static <T extends Comparable<T>>  void mergesort(T[] vetor,T[] auxiliar, int inicio, int fim){
        int tamanho = fim - inicio;
        if(tamanho<=15){
            op=InsertSort.insertSort(auxiliar,inicio,fim,op);
        }else{
            int meio;
            if(inicio<fim-1){
                meio = (inicio+fim)/2;                             // Calcula onde fica o meio do vetor
                mergesort(auxiliar, vetor, inicio, meio);            // Chamada recursiva do inicio do vetor até a metade
                mergesort(auxiliar, vetor, meio, fim);              // Chamada recursiva da 2ª parte do vetor (meio+1) até o fim
                if(vetor[meio].compareTo(vetor[meio-1])>=0){ //Verifica se o vetor já está ordenado. Caso esteja ele vai copiar do vetor
                    op++;                                             // para o axiliar em vez de chamar o merge. Caso não esteja ordenado ele vai
                                                            //mandar pro merge e ordenar.
                    //arraycopy é uma operação de custo menor do que iterar usando um for de inicio até fim-1
                    System.arraycopy(vetor,inicio,auxiliar,inicio,tamanho);
                }else{
                    op++;
                    merge(vetor,auxiliar,inicio,meio,fim);
                }

            }
        }
    }

   private static <T extends Comparable<T>> void merge(T[] vetor, T[] auxiliar, int inicio,int meio, int fim){
       int cont1=inicio; //Contador do primeiro subvetor
       int cont2=meio;   //Contador do segundo subvetor

       for(int k=inicio;k<fim;k++){                 //Percorrendo do inicio ao fim do vetor
           if(cont1>meio-1){                        //Caso o o cont1 tenha chegado no fim do subvetor1, mas o cont2 não, colocamos os elementos do 2subvetor no vetor.
               auxiliar[k]= vetor[cont2++];op++;
           }
           else if(cont2>fim-1){                   //Caso o cont2 tenha chegado ao fim do subvetor2, mas o cont2 não, colocamos os elementos do 1subvertor no vetor.
               auxiliar[k] = vetor[cont1++];op++;
           }
           else if(vetor[cont2].compareTo(vetor[cont1])<=0){    //Compara o valor do subvetor1 com o subvetor2 para ordenar
               auxiliar[k] = vetor[cont2++];op++;
           }else{
               auxiliar[k]= vetor[cont1++];op++;
           }
       }
   }

}

