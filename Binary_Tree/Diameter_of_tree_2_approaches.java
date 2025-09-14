package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;


public class Diameter_of_tree_2_approaches {
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static Info diameter2(Node root){
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo=diameter2(root.left);
        Info rightInfo=diameter2(root.right);

        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+leftInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;    // with one recursice call we calculate both height and diameter both;
    
        return new Info(diam, ht);
    }

    public static int diameterr(Node root){
        if(root==null) return 0;
        int left_diam=diameterr(root.left);
        int right_diam=diameterr(root.right);
        int left_height=Height_count_sum.height(root.left);
        int right_height=Height_count_sum.height(root.right);

        int self_diam=left_height+right_height+1;

        return Math.max(Math.max(left_diam,right_diam),self_diam);
    }
    public static void main(String args[]){
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    Node root=BinaryTreeBt.buildTree(nodes); 

    System.out.println(diameterr(root));
    System.out.println();
    System.out.println(diameter2(root).diam);
    System.out.println();
    System.out.println(diameter2(root).ht);



    }
    
}
