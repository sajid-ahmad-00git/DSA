package Binary_Tree;

import java.util.ArrayList;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class LCA {

        public static boolean getPath(Node root,int n,ArrayList<Node> path){
            if(root==null) return false;
            path.add(root);

            if(root.data==n) return true;
            boolean left_found=getPath(root.left, n, path);
            boolean right_found=getPath(root.right, n, path);

            if(left_found||right_found) return true;

            path.remove(path.size()-1);
            return false;


        }
    public static Node lowestCommonAncestor(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;
    }
    public static void main(String[] args) {
         int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

    Node root=BinaryTreeBt.buildTree(nodes);
    System.out.println(lowestCommonAncestor(root, 04, 07).data);
    }
    
}
