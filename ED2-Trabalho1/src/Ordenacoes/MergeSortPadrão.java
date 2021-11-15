package Ordenacoes;

public class MergeSortPadrão {
    static int op=0; //quantidade de operações realizadas
    
    public static <T extends Comparable<T>> int sort(T[] vetor, int ordem) {
        mergesortPadrão(vetor, 0, vetor.length, ordem);
        return op;
    }
    
    public static <T extends Comparable<T>> void mergesortPadrão(T[] vetor, int inicio, int fim, int ordem) {
        int meio;
        if (inicio < fim - 1) {
            op++;
            meio = (inicio + fim) / 2;                      // Calcula onde fica o meio do vetor
            mergesortPadrão(vetor, inicio, meio,ordem);              // Chamada recursiva do inicio do vetor até a metade
            mergesortPadrão(vetor, meio, fim,ordem);                // Chamada recursiva da 2ª parte do vetor (meio+1) até o fim
            mergePadrão(vetor, inicio, meio, fim,ordem);
        }
    }

    public static <T extends Comparable<T>> void mergePadrão(T[] vetor, int inicio, int meio, int fim, int ordem) {
        //Cria um vetor temporario para trabalharmos a ordenação.
        //O vetor temporario tem o mesmo tamanho do vetor orginal sendo uma copia do mesmo ordenado.

        T[] vetorTemporario = (T[]) new Comparable[vetor.length];

        //O cont1 é o contador que irá percorrer o primeiro subvetor, que está dentro do vetorTemporario.Sendo do inicio até o meio.
        //O cont2 é o contador que irá percorrer o segundo subvetor, que está dentro do vetorTemporario. Sendo do meio+1 até o fim.
        int cont1 = inicio;
        int cont2 = meio;
        // i corresponde a um contador para a posição do vetorTemporario onde será inserido o valor;
        int i = 0;
        //O while vai durar enquanto cont1 for não chegar em meio+1 que é o primeiro elemento do segundo subvetor.
        //e cont2 não chegar no fim do segundo subVetor que como estamos fazendo tudo dentro do vetorTemporario
        //corresponde ao fim do vetor.
        while (cont1 < meio && cont2 < fim) {
            //vetor[cont1]<=vetor[cont2]
          if(ordem == 1){
             if (vetor[cont1].compareTo(vetor[cont2]) <= 0) {
                vetorTemporario[i] = vetor[cont1];   //O vetorTemporario recebe o valor da posição cont1 pois é a menor
                i++;                                //Incrementamos o contador de posição do vetorTemporario.
                cont1++;
                op++;//Incrementamos o contador de posição do primeiro subvetor já que o valor foi adicionado ao vetorTemporario.
            } else {
                //O mesmo do acima
                vetorTemporario[i] = vetor[cont2];
                i++;
                cont2++;op++;                        //Incrementamso o contador de posição do segundo subvetor
            }
            }else{
                if (vetor[cont1].compareTo(vetor[cont2]) >= 0) {
                vetorTemporario[i] = vetor[cont1];   //O vetorTemporario recebe o valor da posição cont1 pois é a menor
                i++;                                //Incrementamos o contador de posição do vetorTemporario.
                cont1++;
                op++;//Incrementamos o contador de posição do primeiro subvetor já que o valor foi adicionado ao vetorTemporario.
            } else {
                //O mesmo do acima
                vetorTemporario[i] = vetor[cont2];
                i++;
                cont2++;op++;                        //Incrementamso o contador de posição do segundo subvetor
            }
            }
        }


        //Colocando os valores que sobraram no primeiro subarray
        //cont1<meio+1 é o mesmo que dizer que que existem elementos entre inicio e meio+1 que sobraram.
        while (cont1 < meio) {
            vetorTemporario[i] = vetor[cont1];
            i++;
            cont1++;
            op++;
        }
        //Colocando os valores que sobraram no segundo subarray
        //cont2<fim é o mesmo que dizer que existem elementos entre meio+1 e fim que sobraram
        while (cont2 < fim) {
            vetorTemporario[i] = vetor[cont2];
            i++;
            cont2++;
            op++;
        }

        //Vamos transferir os valores do vetorTemporario para o vetor original
        //Para vetores que iniciam em 0 k também será 0 obviamente.
        //Mas se podemos ter um inicio diferente de 0
        int j;
        int k;
        for (j = 0, k = inicio; k < fim; j++, k++) {
            vetor[k] = vetorTemporario[j];
            op++;
        }
    }
}