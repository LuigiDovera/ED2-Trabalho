
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
      if( estrutura.get((Key) termo) == null){
         
        Map<String, Integer> doc_occ = new HashMap<>();
        doc_occ.put(Documento,1);
        
        estrutura.put((Key)termo, (Value)doc_occ);
        
      }else{
          //Se tiver ocorrecia
          Map doc_occ = (Map) estrutura.get((Key)termo);
          Integer Ocorrecias = (Integer) doc_occ.get(Documento);
          Ocorrecias++;
          doc_occ.put(Documento,Ocorrecias);
      }
      
  }
  
  public <T extends Estrutura<Key, Value>> void readArrayDocuments(String [] documents, T estrutura){
      
      
      
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


