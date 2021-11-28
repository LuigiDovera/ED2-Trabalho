/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenacoes;

/**
 *
 * @author Luigi
 */
public class HeapSort {
    
        int op = 0;
    
	public <T extends Comparable<T>> int sort(T arr[], int ordem)
	{
            int n = arr.length;

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--){
                if (ordem == 1)
                    heapifyCrescente(arr, n, i);
                else
                    heapifyDecrescente(arr, n, i);
            }

            // One by one extract an element from heap
            for (int i = n - 1; i >= 0; i--) {
                // Move current root to end
                Object temp = arr[0];
                arr[0] = arr[i];
                arr[i] = (T) temp;

                    // call max heapify on the reduced heap
                if (ordem == 1)
                    heapifyCrescente(arr, i, 0);
                else
                    heapifyDecrescente(arr, i, 0);
            }
            
            return op;
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	<T extends Comparable<T>> void  heapifyCrescente(T arr[], int n, int i)
	{
            int largest = i; // Initialize largest as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is larger than root
            if (l < n && arr[l].compareTo(arr[largest]) >= 0)
                largest = l;

            // If right child is larger than largest so far 
            if (r < n && arr[r].compareTo(arr[largest]) >= 0)
                largest = r;

            // If largest is not root
            if (largest != i) {
                Object swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = (T) swap;
                op++;

                // Recursively heapify the affected sub-tree
                heapifyCrescente(arr, n, largest);
            }
	}
        
        <T extends Comparable<T>> void  heapifyDecrescente(T arr[], int n, int i)
	{
		int smallest = i; // Initialize smalles as root
            int l = 2 * i + 1; // left = 2*i + 1
            int r = 2 * i + 2; // right = 2*i + 2

            // If left child is smaller than root
            if (l < n && arr[l].compareTo(arr[smallest]) < 0)
                smallest = l;

            // If right child is smaller than smallest so far
            if (r < n && arr[r].compareTo(arr[smallest]) < 0)
                smallest = r;

            // If smallest is not root
            if (smallest != i) {
                Object temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = (T) temp;
                op++;

                // Recursively heapify the affected sub-tree
                heapifyDecrescente(arr, n, smallest);
            }
	}

	/* A utility function to print array of size n */

	// Driver code
	/*
        public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}
        */
}
