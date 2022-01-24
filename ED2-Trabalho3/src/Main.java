// Classe Executavel do Programa
import Grafo.Grafo;
import java.util.Scanner;
        
public class Main {
    public static <T extends Comparable<T>> void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op;

        System.out.println("Indique o tipo do grafo: 1 - direcionado | 2 - não direcionado");
        op = input.nextInt();

        Grafo g;

        if(op == 1)
            g = new Grafo(true);
        else
            g = new Grafo(false);

        leitor.lerTxt(g,"C:\\Users\\Matheus\\Downloads\\ED2-Trabalho1\\a\\grafo.txt");
        System.out.println("Grafo:");
        g.show();		
        System.out.println("Arestas entre os vértices A e C do grafo:");
        System.out.println(g.numEdges("A", "B"));
        System.out.println("Caminho do vértice A para o vértice F");
        System.out.println(g.path("A", "F"));
        System.out.println("Vértices a uma distância de 1 do vértice C");
        System.out.println(g.around("A", 1));
        System.out.println("Excentricidade dos Vertices");
        g.Eccentricity();
        System.out.println(g.getEccentricity());
        System.out.println("Centro do Grafo");
        System.out.println(g.getCenter());
        System.out.println("Procurar por Pontes");
        System.out.println(g.BridgeFinder());
    }
}
