package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
        


/**
 *
 * @author Matheus
 */
public class Grafo {
    // Atributos úteis para os algoritmos
    protected final int WHITE = 0;
    protected final int GREY = 1;
    protected final int BLACK = 2;
    protected int time;
    protected double circumference;
    
    // Atributos da estrutura do grafo
    protected HashMap<String,Vertice> vertices;
    protected LinkedList<String> keys;
    protected boolean directed;
    protected double Wtotal;
    protected boolean ponderado;
    
    public void setWtotal(double peso){
        Wtotal = peso;
        ponderado = true;
    }
    // Classe aresta
	private class Aresta {
            Vertice orig;
            Vertice dest;
            Double w;
            
            Aresta(Vertice orig, Vertice dest) {// Adiciona aresta sem peso
                    this.orig = orig;
                    this.dest = dest;
                    this.w = 1.0;
            }
            Aresta(Vertice orig, Vertice dest, Double w) {// Adiciona aresta com peso
                    this.orig = orig;
                    this.dest = dest;
                    this.w = w;
            }
    }
    
    // Classe vértice
    private class Vertice implements Comparable<Vertice> {
        String key;
        LinkedList<Aresta> adjs;
        int color;
        Vertice pi;
        int dist;
        double wDist;
        int finishTime;
        double Eccentricity;
        Vertice(String key) {// Adiciona apenas vértice
            this.key = key;
            this.adjs = new LinkedList<Aresta>();
        }
        void addAresta(Vertice dest) {// Adiciona vértice conectado sem peso
            this.adjs.add(new Aresta(this, dest));
            if(!directed)
                    dest.adjs.add(new Aresta(dest, this));
        }
        void addAresta(Vertice dest, Double weight) {// Adiciona vértice conectado com peso
            this.adjs.add(new Aresta(this, dest, weight));
            if(!directed)
                    dest.adjs.add(new Aresta(dest, this, weight));
        }
        @Override
        public int compareTo(Vertice v) {
                if(this.wDist < v.wDist) return -1;
                if(this.wDist > v.wDist) return 1;
                return 0;
        }
    }
    
    public Grafo(boolean isDirected) {
        this.vertices = new HashMap<String,Vertice>();
        this.keys = new LinkedList<String>();
        this.directed = isDirected;
        this.Wtotal = Double.MIN_VALUE;
    }
    
    
    public void put(String key) {
        if(vertices.containsKey(key)) return;
        Vertice v = new Vertice(key);
        this.vertices.put(key, v);
        this.keys.add(key);
        this.Wtotal = Double.MIN_VALUE;
    }
    
    	// Verifica se algum dos vértices já existe e faz a inserção / conexão
    public void put(String key, String destination) {
        Vertice v, dest;
        if(!vertices.containsKey(key)) {
                v = new Vertice(key);
                vertices.put(key, v);
                this.keys.add(key);
        } else {
                v = vertices.get(key);
        }
        if(!vertices.containsKey(destination)) {
                dest = new Vertice(destination);
                vertices.put(destination, dest);
                this.keys.add(destination);
        } else {
                dest = vertices.get(destination);
        }
        v.addAresta(dest);
    }
    
    public void put(String key, String destination, double weight) {
        Vertice v, dest;
        if(!vertices.containsKey(key)) {
                v = new Vertice(key);
                vertices.put(key, v);
                this.keys.add(key);
        } else {
                v = vertices.get(key);
        }
        if(!vertices.containsKey(destination)) {
                dest = new Vertice(destination);
                vertices.put(destination, dest);
                this.keys.add(destination);
        } else {
                dest = vertices.get(destination);
        }
        v.addAresta(dest, weight);
    }
   
    // Exibe as listas de adjacências dos vértices
    public void show() {
        if(keys.size() == 0) { 
            System.out.println("Grafo vazio");
            return;
        }
        for(String key : keys) {
            Vertice v = vertices.get(key);
            System.out.println("Lista de adjacências (v : w) do vértice " + v.key);
            String adjsStr = "| ";
            for(Aresta aresta : v.adjs) {
                    adjsStr += (aresta.dest.key + " : " + aresta.w.toString() + " | ");
            }
            System.out.println(adjsStr);
        }
    }
    
    
    // Mostra quantas arestas estão entre dois vértices
    public int numEdges(String rootKey, String destKey) {

        if(!vertices.containsKey(rootKey)) return -1;

        Vertice v, temp;
        for(String key : keys) {
            if(key != rootKey) {
                v = vertices.get(key);
                v.color = WHITE;
                v.dist = Integer.MAX_VALUE;
                v.pi = null;
            }
        }

        v = vertices.get(rootKey);
        v.color = GREY;
        v.dist = 0;
        v.pi = null;

        LinkedList<Vertice> queue = new LinkedList<Vertice>();
        queue.add(v);
        while(!queue.isEmpty()) {
            v = (Vertice) queue.remove();
            for(Aresta aresta : v.adjs) {
                temp = aresta.dest;
                if(temp.color == WHITE) {
                    temp.color = GREY;
                    temp.dist = v.dist + 1; // Distância medida em número de arestas
                    temp.pi = v;
                    // Alteração no algoritmo: ao detectar o vértice desejado, retorna sua distância
                    if(temp.key.equals(destKey))
                        return temp.dist;
                    queue.add(temp);
                }
            }
            v.color = BLACK;
        }

        return -1;
    }
    
    // Retorna um caminho entre dois vértices
    public String path(String rootKey, String destKey) {

        if(!vertices.containsKey(rootKey)) return "Vértice de origem não encontrado";

        Vertice v, temp;
        for(String key : keys) {
            if(key != rootKey) {
                v = vertices.get(key);
                v.color = WHITE;
                v.dist = Integer.MAX_VALUE;
                v.pi = null;
            }
        }

        v = vertices.get(rootKey);
        v.color = GREY;
        v.dist = 0;
        v.pi = null;

        LinkedList<Vertice> queue = new LinkedList<Vertice>();
        queue.add(v);
        while(!queue.isEmpty()) {
            v = (Vertice) queue.remove();
            for(Aresta aresta : v.adjs) {
                temp = aresta.dest;
                if(temp.color == WHITE) {
                    temp.color = GREY;
                    temp.dist = v.dist + 1;
                    temp.pi = v;
                    // Alteração no algoritmo: ao detectar o vértice desejado, preenche uma lista
                            // com os vértices que levaram até ele, até chegar na raiz
                    if(temp.key.equals(destKey)) {
                        LinkedList<Vertice> aux = new LinkedList<Vertice>();
                        while(temp != null) {
                            aux.addFirst(temp);
                            temp = temp.pi;
                        }
                        // Convertendo a lista em uma string com a chave dos vértices
                        String path = ""; 
                        for(Vertice pathNode : aux) {
                            path += (pathNode.key + " ");
                        }
                        return path;
                    }
                    queue.add(temp);
                }
            }
        v.color = BLACK;
        }

        return "Destino não encontrado / Caminho inexistente";
    }
    
    // Retorna quais vértices estão a uma dada distância de um vértice
    public String around(String rootKey, int d) {

        if(!vertices.containsKey(rootKey)) return "Vértice de origem não encontrado";

        Vertice v, temp;
        for(String key : keys) {
                if(key != rootKey) {
                        v = vertices.get(key);
                        v.color = WHITE;
                        v.wDist = Double.MAX_VALUE;
                        v.pi = null;
                }
        }

        v = vertices.get(rootKey);
        v.color = GREY;
        v.wDist = 0;
        v.pi = null;

        LinkedList<Vertice> queue = new LinkedList<Vertice>();
        queue.add(v);
        LinkedList<Vertice> aux = new LinkedList<Vertice>();
        while(!queue.isEmpty()) {
                v = (Vertice) queue.remove();
                for(Aresta aresta : v.adjs) {
                        temp = aresta.dest;
                        if(temp.color == WHITE) {
                                temp.color = GREY;
                                temp.wDist = v.wDist + aresta.w;
                                temp.pi = v;
                                // Enquanto não alcançar a distância desejada,
                                // adicionar em uma lista os vértices visitados
                                if(temp.wDist <= d) {
                                    aux.add(temp);
                                }
                                queue.add(temp);
                        }
                }
                v.color = BLACK;
        }

        // Transformando a lista de vértices em uma string para retorno
        if(aux.isEmpty()) {
                return "Não há vértices";
        } else {
                String around = ""; 
                for(Vertice pathNode : aux) {
                        around += (pathNode.key + " ");
                }
                return around;
        }
    }

    private void CleanColors(){
        Vertice v;
        for(String key : keys) {
            v = vertices.get(key);
            v.color = WHITE;
            v.dist = Integer.MAX_VALUE;
            v.pi = null;
            
        }
    }
    public void Eccentricity(){
        Vertice v, temp;

        for (String key: keys){
            CleanColors();
            v = vertices.get(key);
            v.color = GREY;
            v.wDist = 0;
            v.pi = null;
            LinkedList<Vertice> queue = new LinkedList<Vertice>();
            queue.add(v);
            LinkedList<Vertice> aux = new LinkedList<Vertice>();

            while(!queue.isEmpty()) {
                    v = (Vertice) queue.remove();
                    for(Aresta aresta : v.adjs) {
                            temp = aresta.dest;
                            if(temp.color == WHITE) {
                                    temp.color = GREY;
                                    temp.wDist = v.wDist + aresta.w;
                                    temp.pi = v;
                                    // Enquanto não alcançar a distância desejada,
                                    // adicionar em uma lista os vértices visitados
                                    if(!ponderado){
                                        if(temp.wDist <= vertices.size())
                                            aux.add(temp);
                                    }else{
                                        if(temp.wDist <= Wtotal)
                                            aux.add(temp);
                                    }
                                    
                                    queue.add(temp);
                            }
                    }
                    v.color = BLACK;
            }

            if(aux.isEmpty()) {
                System.out.println("Não há vértices");
            } else {
                Vertice maxEcc = aux.getFirst();
                for(Vertice node : aux) {
                      if(node.wDist > maxEcc.wDist)
                          maxEcc = node;
                }
               v = vertices.get(key);
               v.Eccentricity = maxEcc.wDist;
            }
        }
    }

    public String getEccentricity(){
        Vertice v;
        String Ecc = "";
        for (String key : keys){
           v = vertices.get(key);
           Ecc += ("E("+ key + ") = " + v.Eccentricity +"\n");
        }
        return Ecc;
    }
    
    public String getCenter(){
        Vertice v;
        String Center = "";
        Vertice minEcc = vertices.get(keys.getFirst());
        // Procura o vertice de Excentricidade mínima
        for (String key : keys){
            v = vertices.get(key);
            if (v.Eccentricity < minEcc.Eccentricity)
                minEcc = v;
        }
        
        for (String key : keys){
            v = vertices.get(key);
            if(v.Eccentricity == minEcc.Eccentricity){
                Center += ("Vertice("+key+") = " + v.Eccentricity+"\n");
            }
        }
        return Center;
    }

    
    public void dfsVisit(Vertice v){
        time++;
        v.dist = time;
        v.color = GREY;

        Vertice temp;
        for(Aresta edge : v.adjs) {
                temp = edge.dest;
                if(temp.color == WHITE) {
                    temp.wDist = v.wDist + edge.w;
                    temp.pi = v;
                    dfsVisit(temp);
                } 
                
              
        }

        v.color = BLACK;
        time++;
        v.finishTime = time;
    }
    
    
    public String BridgeFinder(){
        Vertice v, temp;
        CleanColors();
        String Pontes = "";
        String Adj;
        Aresta Last1 = null;
        int posil=0;
        int QBridge = 0;
        for(String key: keys){
            Grafo GrafoResidual =  this;
            //GrafoResidual.show();
            v = GrafoResidual.vertices.get(key);
            //System.out.println(v.key);
            LinkedList <Aresta> adjs = v.adjs;
            /*
            System.out.println("Adsjs");
            for (Aresta a : adjs){
                System.out.println(a.orig.key +"-"+a.dest.key);
            }
*/
            int nAdjs = adjs.size()-1;
            for (int i=0; i<= nAdjs; i++){
                
                Adj = v.key + " " + adjs.get(i).dest.key;
                //System.out.println("removida: " + Adj);
                Last1 = adjs.get(i);
                posil = i;
                adjs.remove(adjs.get(i));
                for(String key2 : GrafoResidual.keys){
                    if(key2 != v.key){
                       // System.out.println(v.key + "-" +key2 );
                   // System.out.println(GrafoResidual.path(v.key, key2));
                        if (GrafoResidual.path(v.key, key2).equals("Destino não encontrado / Caminho inexistente")){
                            QBridge++;
                            Pontes += "|" + Adj + "| " + "\n";
                            break;
                        }     
                    }
                    
                }
                if(Last1 != null){
                    adjs.add(posil, Last1);
                }
            }
            
        }
        if (QBridge == 0){
            return "Conectado por aresta";
        }else{
            return "Postes: \n" + Pontes;
        }    
    }
}
