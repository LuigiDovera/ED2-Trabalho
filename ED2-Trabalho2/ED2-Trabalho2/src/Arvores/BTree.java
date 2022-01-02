/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvores;

import tabelas.Estrutura;

/**
 *
 * @author Matheus
 * @param <Key>
 * @param <Value>
 */
public class BTree<Key extends Comparable<Key>, Value> implements Estrutura {
    
    
    
    private class Page(){
        
        
    }
    
    private Page root = new Page(true);
    
    @Override
    public Object get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(Object key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
