package Leitura;

import Dados.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Leitor {

   public static  Dado1[] leitor1(int quantidade){

       File arquivo = new File("Tabela_String_Double.csv");
       Dado1[] arr = new Dado1[quantidade];

       try{
           Scanner leitor = new Scanner(arquivo);

           String linhas = new String();
           linhas = leitor.nextLine();

           for(int i=0;i<quantidade;i++){
               linhas = leitor.nextLine();
               String[] linha = linhas.split(",");
               arr[i] = gerarObjeto1(linha);
           }
       }catch (FileNotFoundException e){
           System.out.println("not found");
       }
       return arr;
    }

    public static  Dado2[] leitor2(int quantidade){

        File arquivo = new File("Tabela_Double_String.csv");
        Dado2[] arr = new Dado2[quantidade];

        try{
            Scanner leitor = new Scanner(arquivo);

            String linhas = new String();
            linhas = leitor.nextLine();

            for(int i=0;i<quantidade;i++){
                linhas = leitor.nextLine();
                String[] linha = linhas.split(",");
                arr[i] = gerarObjeto2(linha);
            }
        }catch (FileNotFoundException e){
            System.out.println("not found");
        }
        return arr;
    }

    public static  Dado3[] leitor3(int quantidade){

        File arquivo = new File("Tabela_Int_Vetor.csv");
        Dado3[] arr = new Dado3[quantidade];

        try{
            Scanner leitor = new Scanner(arquivo);

            String linhas = new String();
            String linha2 = new String();
            int[] vetor = new int[30];
            for(int i=0;i<quantidade;i++){
                linhas = leitor.nextLine();
                String[] linha = linhas.split(",");
                for(int j=0;j<30;j++){
                    vetor = new int[30];
                    linha2 = leitor.nextLine();
                    String[] linhavet = linhas.split(",");
                    vetor[j] = Integer.parseInt(linhavet[1]);
                }
                Dado3 objeto = new Dado3(Integer.parseInt(linha[1]),vetor);
                arr[i] = objeto;
            }
        }catch (FileNotFoundException e){
            System.out.println("not found");
        }
        return arr;
    }

    private static Dado1 gerarObjeto1(String[] linha){
       String chave = linha[0].toUpperCase();
       Double valor = Double.parseDouble(linha[1]);
       return new Dado1(chave,valor);
    }

    private static Dado2 gerarObjeto2(String[] linha){
        Double chave =  Double.parseDouble(linha[0]);
        String valor = linha[1];
        return new Dado2(chave,valor);
    }


}
