package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Height_count_sum{

    public static int height(Node root){
        if(root==null) return 0;
        int left_height=height(root.left);
        int right_height=height(root.right);
        return Math.max(left_height,right_height)+1;

    }

    public static int count(Node root){
        if(root==null) return 0;
        int left_count=count(root.left);
        int right_count=count(root.right);
        return left_count+right_count+1;
    }

    public static int sum(Node root){
        
        if(root==null) return 0;
        int left_sum=sum(root.left);
        int right_sum=sum(root.right);
        return left_sum+right_sum+root.data;

    }

    public static void main(String[] args) {
    int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    Node root=BinaryTreeBt.buildTree(nodes);
    System.out.println(height(root)); 
    System.out.println();
    System.out.println(count(root));
    System.out.println();
    System.out.println(sum(root));
        
    }
}