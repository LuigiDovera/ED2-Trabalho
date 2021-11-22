/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenacoes;

import InsertSort.InsertSort;
import static Ordenacoes.MergeSort.op;
import java.util.Random;

/**
 *
 * @author Matheus
 */
public class QuickSort {
    static long op = 0;
    
    public static <T extends Comparable<T>> long sort(T[] vetor, int ordem){
        quickSort(vetor,0,vetor.length, ordem);
        return op;
    }
    
    public static <T extends Comparable<T>> void quickSort(T[] vetor, int inicio, int fim, int ordem){
        int tamanho = fim - inicio;op++;
        if (tamanho <= 15){
            op = InsertSort.insertSort(vetor,inicio,fim,op,ordem);
        }else{
            if (inicio < fim - 1){
                int posicaoPivo = particiona(vetor, inicio, fim-1, ordem, true);
                quickSort(vetor, inicio, posicaoPivo -1, ordem);
                quickSort(vetor, posicaoPivo+ 1 ,fim, ordem);
            }
        }
    }
    
        
    
    private static <T extends Comparable<T>> int particiona(T[] vetor, int inicio, int fim, int ordem, boolean randomizePivo){
        T pivo;
        if(randomizePivo){
            pivo = vetor[getRandomNumberInRange(inicio,fim)];op++;
        }else{
            pivo = vetor[inicio];op++;
        }
        
        int i = inicio +1, f = fim;op+=2;
        
        while(i <= f){
            if(ordem == 1){
                if(vetor[i].compareTo(pivo)<= 0){
                    i++;
                    op++;
                }
                else if (pivo.compareTo(vetor[f]) < 0){
                    f--;
                    op++;
                }
                else{
                    T troca  = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                    op+=3;
                }
            }else{
                if(vetor[i].compareTo(pivo) >= 0){
                    i++;
                    op++;
                }
                else if (pivo.compareTo(vetor[f]) > 0){
                    f--;
                    op++;
                }                    
                else{
                    T troca  = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                    op+=3;
                }
            }
        }
        vetor[inicio] = vetor[f]; op++;
        vetor[f] = pivo; op++;
        return f;
    }
    
    
    private static int getRandomNumberInRange(int min, int max) {

            if (min >= max) {
                    throw new IllegalArgumentException("max must be greater than min");
            }

            Random r = new Random();op++;
            return r.nextInt((max - min) + 1) + min;
    }
}
