// Classe Executavel do Programa
import Arvores.AVLTree;
import Arvores.RBTree;
import Document.Document;
import Termo.Termo;
import arvores.BTree;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import tabelas.HashListaEncadeada;
import leitor.LeitorDoc;
import tabelas.Estrutura;
import tabelas.HashTentativaQuadratica;

public class Main {
    public static <T extends Comparable<T>> void main(String[] args) throws FileNotFoundException {
        int C;
        //System.out.print("main:" + DistTermperDoc.get("O homem.txt"));
        
        //System.out.print("freq:" +  t.getFreq("homem", table));
        /*
        ArrayList<String> termos = new ArrayList();
        termos.add("homem");
        termos.add("anima");
        termos.add("exist");
        ArrayList<Document> documentos = t.DocumentRL(termos, table, DistTermperDoc);
        for(Document doc : documentos){
            System.out.print("Nome: " + doc.getNome() + " Peso: " + doc.getPeso());
        }        
        */

        /*MENU*/

        int opcao = 0;
	do {
		
		System.out.print("\n                  =========================\n");
		System.out.print("                  |     1 - Hash Quadra.   |\n");
		System.out.print("                  |     2 - Hash Lista E.  |\n");
		System.out.print("                  |     3 - Árvore AVL     |\n");
		System.out.print("                  |     4 - Árvore RB      |\n");
		System.out.print("                  |     5 - Árvore B       |\n");
		System.out.print("                  |     0 - Sair           |\n");
		System.out.print("                  =========================\n");

		Scanner leitor = new Scanner(System.in);
                opcao = leitor.nextInt();
		System.out.print("\n");
                LeitorDoc doc_scan = new LeitorDoc();
		switch (opcao) {
		case 1:
                    Termo tHL = new Termo();
                    HashTentativaQuadratica tableHQ = new HashTentativaQuadratica();
                    menu2(tableHQ,tHL);
                    break;
		case 2:
                    Termo tHE = new Termo();
                    HashListaEncadeada tableHE = new HashListaEncadeada();
                    menu2(tableHE, tHE);
                    break;
                case 3:
                    Termo tAVL = new Termo();
                    AVLTree TreeAVL = new AVLTree();
                    menu2(TreeAVL, tAVL);
                    break;
                case 4:
                    Termo tRB = new Termo();
                    RBTree treeRB = new RBTree();
                    menu2(treeRB, tRB);
                    break;
		case 5:
                    Termo tBT = new Termo();
                    BTree btree = new BTree();
                    menu2(btree, tBT);
                    break;
		case 0:
			break;
		default:
			System.out.print("Opção Inválida!");
			break;
		}
	} while (opcao != 0);
    }
    
    public static void menu2(Estrutura table, Termo t) throws FileNotFoundException{
        int C;
        String dir = "";
        LeitorDoc doc_scan = new LeitorDoc();
        String menu2 = "\n                  =====================\n";
        menu2 += "                  |     1 - Usar Pasta Padrão |\n";
        menu2 += "                  |     2 - Definir Diretório |\n\n";
        System.out.print(menu2);
        Scanner leitor = new Scanner(System.in);
        int resposta = leitor.nextInt();
        System.out.print("\n");
        switch(resposta){
            case 1:
                dir = "C:\\Users\\Matheus\\Downloads\\ED2-Trabalho1\\a";
                break;
            case 2:
                System.out.print("Digite o diretório: ");
                dir = leitor.next();
                break;
            default:
                System.out.print("Opção Inválida!");
                break;
        }
        System.out.print("Digite o valor de C:");
        resposta = leitor.nextInt();
        C = resposta;
        File folder = new File(dir);
        HashMap<String, Integer> DistTermperDoc = doc_scan.findAllFilesInFolder(folder, table,t, C);
        menu3(DistTermperDoc,t, table);
       
    }
    
    public static void menu3(HashMap<String,Integer> DistTermperDoc, Termo t, Estrutura estrutura){
        String menu3 ="\n                  ====================================\n";
        menu3 += "                  |     1 - Buscar Indice Inverso de termo   |\n"; 
        menu3 += "                  |     2 - Buscar Documento por termo(s)    |\n";
        menu3 += "                  |     3 - Sair                             |\n";
        boolean sair = false;
        do{
        System.out.print(menu3);
        Scanner leitor = new Scanner(System.in);
        int resposta = leitor.nextInt();
        System.out.print("\n");
            switch(resposta){
                case 1:
                    System.out.print("Digite o Termo:\n");
                    String termo = leitor.next();
                    System.out.print("freq:" +  t.getFreq(termo, estrutura));
                    break;
                case 2:
                    System.out.print("Digite os termos separados por espaço:" );
                    String termos;
                    ArrayList<String> TermosSeparados;
                    leitor.nextLine();
                    termos = leitor.nextLine();
                    TermosSeparados = t.split(termos);
                    ArrayList<Document> documentos = t.DocumentRL(TermosSeparados, estrutura, DistTermperDoc);
                    for(Document doc : documentos){
                        System.out.print("Nome: " + doc.getNome() + " Peso: " + doc.getPeso()+"\n");
                    }     
                    break;
                case 3:
                    sair = true;
                    break;
                default: 
                        System.out.print("Opção Inválida!");
                    break;
            }
        }while(!sair);
    
    }
}
