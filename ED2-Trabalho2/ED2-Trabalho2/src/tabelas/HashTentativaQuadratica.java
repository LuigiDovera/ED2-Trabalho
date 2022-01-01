/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelas;

/**
 *
 * @author Matheus
 * @param <Key>
 * @param <Value>
 */
public class HashTentativaQuadratica<Key, Value> implements Estrutura<Key, Value>{
    private int N; // numero de pares de chaves na tabela
	private int M = 16; // Tamanho da tabela hash com tratamento linear
	private Key[] keys; // the keys
	private Value[] vals; // the values
	private boolean[] stats;

	//stats
	// true = ALOCADO
	// false = REMOVIDO

	public HashTentativaQuadratica() {
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
		stats = new boolean[M];
	}
	
	public HashTentativaQuadratica(int cap) {
		keys = (Key[]) new Object[cap];
		vals = (Value[]) new Object[cap];
		M = cap;
	}
	

	//Retorna o hash entre 0 e M-1.
	private int hash(Key key,int c1, int c2, int k)
	{
		return (((key.hashCode() & 0x7fffffff) % M ) + c1*k + c2*k*k)%M;
	}
	
	/**
	 * Redimensiona a tabela de acordo com a quantidade de chaves.
	 * @param cap
	 */
	private void resize(int cap) {
		
		HashTentativaQuadratica<Key, Value> t;
		t = new HashTentativaQuadratica<Key, Value> (cap);
		
		for (int i = 0; i < keys.length; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
		
	}
	
	 public boolean contains(Key key) {
	        if (key == null) {
	            throw new IllegalArgumentException("Argument to contains() cannot be null");
	        }

	        return get(key) != null;
	 }

        
	public void put(Key key, Value val){
		int i;
		int k = 0;
		if (N >= M/2) 
			resize(2*M); // double M 

		for (i = hash(key,2,5,k); keys[i] != null; i = hash(key,2,5,k++))
			if (keys[i].equals(key)) { 
				vals[i] = val;
				return; 
				}
		//Achou uma posição livre
		keys[i] = key;
		vals[i] = val;
		stats[i] = true;
		N++;
	}
	
	public void delete(Key key)
	{
		if (key == null) 
			throw new IllegalArgumentException("Argument to delete() cannot be null");
		
		if (!contains(key))
			return;
                int k =0;
		int i = hash(key,2,5,k);
		while (!key.equals(keys[i]))
			i = hash(key,2,5,k++);
		
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		
		while (keys[i] != null){
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
		if (N > 0 && N == M/8) 
			resize(M/2);
	}
	
	/**
	 * Busca um objeto no Hash
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
                int k =0;
		for (int i = hash(key,2,5,k); keys[i] != null; i = hash(key,2,5,k++))
			if (keys[i].equals(key) && stats[i])
				return vals[i];
		return null;
	}

}
