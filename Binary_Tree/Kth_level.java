package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Kth_level {

    public static void kth_level_print(Node node,int k,int level){
        if(node==null) return;

        if(k==level){
            System.out.println(node.data+" ");
            return;
        }
        kth_level_print(node.left, k, level+1);
        kth_level_print(node.right, k, level+1);

    }
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root=BinaryTreeBt.buildTree(nodes);
        kth_level_print(root, 3, 1);
    }
    
}
