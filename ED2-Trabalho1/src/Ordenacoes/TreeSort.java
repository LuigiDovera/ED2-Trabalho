package Ordenacoes;

public class TreeSort
{   
    int ordem;
    int op = 0;
 
    //Classe nó
    class  Node <Object extends Comparable<Object>>  
    {
        Object objeto;
        Node esq, dir;
        
        
 
        public Node(Object item)
        {
            objeto = item;
            esq = dir = null;
        }
    }
 
    private Node root;
 
    public TreeSort()
    {
        root = null;
    }
    
    public Node getRoot(){
        return root;
    }
    
    public int getOperacoes(){
        return op;
    }
 
    
    private <T extends Comparable<T>> void inserir(T chave, int ordem)
    {
        if (ordem == 1)
            root = inserirNodeCrescente(root, chave);
        else
            root = inserirNodeDecrescente(root, chave);
    }
     
    
    
    //Realiza a inserção na árvore binária, de forma a deixá-la ordenada
    private <T extends Comparable<T>> Node inserirNodeCrescente(Node node, T chave)
    {
 
        //Inserir nó na raiz da árvore se a mesma estiver
        if (node == null)
        {
            node = new Node(chave);
            return node;
        }
 
        /* Otherwise, recur
        down the tree */
        
        if (node.objeto.compareTo(chave) >= 0)
            node.esq = inserirNodeCrescente(node.esq, chave);
        else
            node.dir = inserirNodeCrescente(node.dir, chave);
        
        op++;
        /* return the root */
        return node;
    }
    
    private <T extends Comparable<T>> Node inserirNodeDecrescente(Node node, T chave)
    {
 
        //Inserir nó na raiz da árvore se a mesma estiver
        if (node == null)
        {
            node = new Node(chave);
            return node;
        }
 
        /* Otherwise, recur
        down the tree */
        
        if (node.objeto.compareTo(chave) < 0)
            node.esq = inserirNodeDecrescente(node.esq, chave);
        else
            node.dir = inserirNodeDecrescente(node.dir, chave);
        
        op++;
        /* return the root */
        return node;
    }
    
     
    public void inordemPrint(Node root)
    {
        if (root != null)
        {
            inordemPrint(root.esq);
            System.out.println(root.objeto.toString());
            inordemPrint(root.dir);
        }
    }
    
    public <T extends Comparable <T>> void inordemArray(Node root, T arr[], int i)
    {
        if (root != null)
        {
            inordemArray(root.esq, arr, i);
            arr[i] = (T) root.objeto;
            i++;
            inordemArray(root.dir, arr, i);
        }
    }
    
    public <T extends Comparable <T>> T[] salvarArray(T arr[])
    {   
        T[] arr2 = arr.clone();
        
        for(int i=0; i<arr2.length; i++){
            arr2[i] = null;
        }
        
        int i = 0;
        this.inordemArray(this.root, arr2, i);
        return arr2;
    }
    
    
    
    public <T extends Comparable <T>> void inserirArray(T arr[], int ordem)
    {   
        this.ordem = ordem; //ordem = 1 -> crescente
        for(int i = 0; i < arr.length; i++)
        {
            inserir(arr[i], ordem);
        }
         
    }
}
 
