package Termo;

import Arvores.RBTree.Iterator;
import Document.ComparadordeDocumentos;
import Document.Document;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import leitor.Normalizador;
import tabelas.Estrutura;
import tabelas.HashListaEncadeada;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus
 * @param <Key>
 * @param <Value>
 */
public class Termo<Key,Value> {
       private int Ndoc;
       
  public Termo(){
      this.Ndoc = 0;
  }
  public <T extends Estrutura<Key, Value>> void  putTermo(String termo, T estrutura,String Documento){
      if(termo == null || estrutura ==  null)
          throw new IllegalArgumentException();
     
      //Se não tiver nenhuma occorrencia
      Map<String, Integer> v = (Map<String, Integer>) estrutura.get((Key)termo);
      if(v == null){
          
          Map<String, Integer> doc_occ = new HashMap<>();
          doc_occ.put(Documento,1);
          
          estrutura.put((Key)termo, (Value)doc_occ);
          
      }else if (v.get(Documento) == null){
          //Se tiver ocorrecia 
          Map<String, Integer> doc_occ = (Map<String, Integer>) estrutura.get((Key)termo);
          doc_occ.put(Documento,1);
      }else{ 
          Map<String, Integer> doc_occ = (Map<String, Integer>) estrutura.get((Key)termo);
          Integer Ocorrecias = (Integer) doc_occ.get(Documento);
          Ocorrecias++;
          doc_occ.put(Documento,Ocorrecias);
      }
      
  }
  
    public <T extends Estrutura<Key, Value>> Value  getFreq(String termo, T estrutura){
        if(termo == null || estrutura == null){
            throw new IllegalArgumentException();
        }
        
        return estrutura.get((Key)termo);
    }
    
    
  public <T extends Estrutura<Key, Value>> HashMap<String, Integer> readArrayDocuments(List<String> documents, List<String> nomes,int Ndoc, T estrutura, int C){
     List<String> palavras;
     HashMap<String, Integer> Doc_DistTerm = new HashMap();
     int i=0;
     int sizeDisc;
      for (String doc: documents){
        palavras = Normalizador.normalizarParaLista(doc, C);
        palavras = Normalizador.apenasCLetras(palavras, C, false);
        sizeDisc = Normalizador.apenasCLetras(palavras, C, true).size();
        Doc_DistTerm.put(nomes.get(i), sizeDisc);
        System.out.println("Doc: " + nomes.get(i));
        for (String palavra: palavras){
            System.out.println(palavra);
            putTermo(palavra, estrutura, nomes.get(i));
        }
        i++;
  }
      this.Ndoc = Ndoc;
      
      return Doc_DistTerm;
      
  }
  
  
  public String ResizeString(String palavra, int C){
      String newTermo = "";
      char[] letras = palavra.toCharArray();
      int i =0;
      for (char letra : letras){
          if(i==C)
              break;
          newTermo += letra;
          i++;
      }
      return newTermo;
  }
  public ArrayList<String> split(String s){
       int l=s.length();
       String word="";
       ArrayList<String> words = new ArrayList();
        for(int i=0; i<l; i++)
        {
            char ch = s.charAt(i);
            if (ch!=' ') // append to current word
            {
                word=word+ch;
            }
            else // if space is found print the previously formed word
            {   
                words.add(word);
                word="";
            }
        }
        words.add(word);
        
        return words;
  }
  
  
  public void readDocument(String[] documents, int C){
      for (String doc : documents){
        ArrayList<String> words = split(doc);
        words.forEach(word -> {
            System.out.println(word);
        });
      }
  }
  
  public ArrayList<Document> DocumentRL(List<String> termos, Estrutura estrutura, HashMap<String, Integer> DistTermPerDoc){
      HashMap<String, Integer> map;
      int n; // número de documentos na coleção que contém tj
      int f; //número de documentos na coleção que contém tj
      int dj; // número de documentos na coleção que contém tj
      double w;
      Document doc;
      ArrayList<Document> WeigthedDoc = new ArrayList<Document>();
      for(String termo : termos){
           //System.out.println("termo:" + termo);
           map = (HashMap<String, Integer>) getFreq(termo, estrutura);
           if(map != null){
            //System.out.println(map);
            dj = map.size();
            for(Map.Entry<String,Integer> pair : map.entrySet()){
                //System.out.println("Documento: " + pair.getKey());
                n = DistTermPerDoc.get(pair.getKey());
                f = pair.getValue();
                w = WeightTermInDoc(dj, Ndoc, this.Ndoc);
                //System.out.println("n: " + n + " f : " + f + " w: " + w + " dj: " + dj + " ndoc: "+ this.Ndoc);
                doc = findDoc(WeigthedDoc, pair.getKey());
                if(doc != null){
                    doc.setPeso(doc.getPeso()+w);
                }else{
                    WeigthedDoc.add(new Document(pair.getKey(), w, n));
                }

            }
           }
      }
      
      for (Document docum: WeigthedDoc){
          docum.setPeso(docum.getPeso()/docum.getdisTerm());
      }
      Collections.sort(WeigthedDoc, new ComparadordeDocumentos());
      return WeigthedDoc;
  }
  
  public Document findDoc(ArrayList<Document> lista, String nome){
      for(Document doc : lista){
          if (doc.getNome().equals(nome)){
              return doc;
          }
      }
      return null;
  }
  
  
  public double WeightTermInDoc(int dj, int Ocorrencias, int NDoc){
      return Ocorrencias * ((Math.log(NDoc))/dj);
  }
  
}


