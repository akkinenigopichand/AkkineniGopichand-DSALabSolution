import java.util.*;

public class SumInBST {

	
	 class Node {
	        int key;
	        Node left, right;
	 
	        public Node(int item)
	        {
	            key = item;
	            left = right = null;
	        }
	    }
	 
	
	
	// Root of BST
    Node root;
 
    // Constructor
    SumInBST() { root = null; }
 
    SumInBST(int value) { root = new Node(value); }
	
	
    
    //insertion into the tree
    void insert(int key) { root = insertRec(root, key); }
    
   
    Node insertRec(Node root, int key)
    {

        if (root == null) {
            root = new Node(key);
            return root;
        }
 
       
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        return root;
    }
 

    // function for recursion
    public boolean findPair(Node root,int sum, HashSet<Integer> set)
    {
    	if(root==null)
    	{
    		return false;
    	}
    	
    	if(findPair(root.left,sum,set))
    	{
    		return true;
    	}
    	
    	if(set.contains(sum-root.key))
    	{
    		System.out.println("pair is found ("+(sum-root.key+" , "+(root.key)+" )"));
    		return true;
    	}
    	
    	else
    	{
    		set.add(root.key);
    	}
    	
    	return findPair(root.right,sum,set);
    	
    }
    
    // solution function calling recursion
    public void solution(Node root, int sum)
    {
    	HashSet<Integer> set = new HashSet<Integer>();
    	if(!findPair(root,sum,set))
    	{
    		System.out.println("pair doesn't exist");
    	}
    }
    
    
    
    
    // Driver Code
    public static void main(String[] args)
    {
    	SumInBST tree = new SumInBST();
 
       
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
 
      
        tree.solution(tree.root,130);
    }
}

