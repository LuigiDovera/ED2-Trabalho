package Ordenacoes;

public class TreeSort
{
 
    // Class containing left and
    // right child of current
    // node and key value
    class Node <Object extends Comparable<Object>>
    {
        Object key;
        Node left, right;
 
        public Node(Object item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    private Node root;
 
    // Constructor
    public TreeSort()
    {
        root = null;
    }
    
    public Node getRoot(){
        return root;
    }
 
    // This method mainly
    // calls insertRec()
    private <T extends Comparable<T>> void insert(T key)
    {
        root = insertRec(root, key);
    }
     
    /* A recursive function to
    insert a new key in BST */
    private <T extends Comparable<T>> Node insertRec(Node root, T key)
    {
 
        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur
        down the tree */
        if (root.key.compareTo(key)>=0)
            root.left = insertRec(root.left, key);
        else
            root.right = insertRec(root.right, key);
 
        /* return the root */
        return root;
    }
     
    // A function to do
    // inorder traversal of BST
    public void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    
    public <T extends Comparable <T>> void treeins(T arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }
         
    }
 
    /*
    public static <T extends Comparable<T>> void main(String[] args)
    {
        TreeSort tree = new TreeSort();
        T arr[] = {5, 4, 7, 2, 11};
        tree.treeins(arr);
        tree.inorderRec(tree.root);
    }
    */
}
 
