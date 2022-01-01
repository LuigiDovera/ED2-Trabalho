/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tabelas;

/**
 *
 * @author Matheus
 * @param <Key>
 * @param <Value>
 */
public interface Estrutura<Key, Value> {
    public Value get(Key key);
    public void put(Key key, Value value);
}
