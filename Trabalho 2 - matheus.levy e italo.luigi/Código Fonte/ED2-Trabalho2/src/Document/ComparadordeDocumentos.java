/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Document;

import java.util.Comparator;

/**
 *
 * @author Matheus
 */
public class ComparadordeDocumentos implements Comparator<Document>{

    @Override
    public int compare(Document o1, Document o2) {
       if (o1.getPeso()<o2.getPeso())
           return 1;
       else if (o1.getPeso() > o2.getPeso())
           return -1;
       else
           return 0;
    }
    
}
