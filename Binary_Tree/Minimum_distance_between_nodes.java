package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Minimum_distance_between_nodes {
          
    public static int lca_distance(Node root,int n){
        if(root==null) return -1;

        if(root.data==n) return 0;

        int left_dist=lca_distance(root.left,n);
        int right_dist=lca_distance(root.right, n);

        if(left_dist==-1&&right_dist==-1) {
            return -1;
        } else if(left_dist==-1){
            return right_dist+1;
        }else {
            return left_dist+1;
        }
    

    }
    
    public static int min_distance(Node root,int n1,int n2){
       Node lca=LCA.lowestCommonAncestor(root, n1, n2);
       int distance1=lca_distance(lca,n1 );
       int distance2=lca_distance(lca,n2 );

       return distance1+distance2;
        
    }
    
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root=BinaryTreeBt.buildTree(nodes);
        System.out.println(min_distance(root, 4, 6));
    }
}
