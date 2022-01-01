import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    
  public <T extends Estrutura<Key, Value>> void readArrayDocuments(String [] documents, T estrutura){
     ArrayList<String> palavras;
     int i=1;
      for (String doc: documents){
        palavras = split(doc);
        for (String palavra: palavras){
            putTermo(palavra,estrutura,Integer.toString(i));
        }
        i++;
  }
      
      
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
  
  
  public void readDocument(String[] documents){
      for (String doc : documents){
        ArrayList<String> words = split(doc);
        words.forEach(word -> {
            System.out.println(word);
        });
      }
  }
}


