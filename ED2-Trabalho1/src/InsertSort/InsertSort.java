package InsertSort;

public class InsertSort {

    public static  <T extends Comparable<T>> int insertSort(T[] vetor, int inicio,int fim,int op){

       for(int i=inicio;i<fim;i++) {
           for (int j = i; j > inicio && vetor[j].compareTo(vetor[j - 1]) < 0; j--) {
               troca(vetor, j, j - 1);op++;
           }
       }

       return op;
}

    //Função auxiliar pra fazer a troca dos elementos
    private static <T extends Comparable<T>> void troca(T[] vetor,int i, int j){
        T aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }
}
