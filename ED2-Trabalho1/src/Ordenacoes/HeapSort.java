package Ordenacoes;

public class HeapSort {
    
        int op = 0;
    
	public <T extends Comparable<T>> int sort(T arr[], int ordem)
	{
            int n = arr.length;

            
            for (int i = n / 2 - 1; i >= 0; i--){
                if (ordem == 1)
                    heapifyCrescente(arr, n, i);
                else
                    heapifyDecrescente(arr, n, i);
            }

            
            for (int i = n - 1; i >= 0; i--) {
                // Move current root to end
                Object temp = arr[0];
                arr[0] = arr[i];
                arr[i] = (T) temp;

                    
                if (ordem == 1)
                    heapifyCrescente(arr, i, 0);
                else
                    heapifyDecrescente(arr, i, 0);
            }
            
            return op;
	}
        
	<T extends Comparable<T>> void  heapifyCrescente(T arr[], int n, int i)
	{
            int largest = i; 
            int l = 2 * i + 1; 
            int r = 2 * i + 2; 

            
            if (l < n && arr[l].compareTo(arr[largest]) >= 0)
                largest = l;
 
            if (r < n && arr[r].compareTo(arr[largest]) >= 0)
                largest = r;

            
            if (largest != i) {
                Object swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = (T) swap;
                op++;
                
                heapifyCrescente(arr, n, largest);
            }
	}
        
        <T extends Comparable<T>> void  heapifyDecrescente(T arr[], int n, int i)
	{
            int smallest = i; 
            int l = 2 * i + 1; 
            int r = 2 * i + 2; 

            if (l < n && arr[l].compareTo(arr[smallest]) < 0)
                smallest = l;
            
            if (r < n && arr[r].compareTo(arr[smallest]) < 0)
                smallest = r;

            
            if (smallest != i) {
                Object temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = (T) temp;
                op++;

                
                heapifyDecrescente(arr, n, smallest);
            }
	}

}
