package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class PreOrder {


    public static void preTraversal(Node root){
        if(root==null) return ;
        System.out.println(root.data);
        preTraversal(root.left);
        preTraversal(root.right);
    }
    public static void main(String[] args) {
    int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

    Node root=BinaryTreeBt.buildTree(nodes);   // did not created the object 
    preTraversal(root);


        
    }
    
}
