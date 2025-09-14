package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Subtree {

    public static boolean isidentical(Node root, Node subroot){
        if(root==null && subroot==null){
            return true;
        }else if(root==null || subroot == null || root.data!=subroot.data){
            return false;
        }
        if(!isidentical(root.left, subroot.left))return false;
        if(!isidentical(root.right, subroot.right))return false;
        return true;
    }


    public static boolean isSubtree(Node root, Node subroot){
        if(subroot==null)return true;   //because an empty tree is always considered a subtree.
        if(root==null) return false; //  if root is null but subroot isn't, it's not a subtree

        if(root.data==subroot.data){
            if(isidentical(root,subroot)){
                return true; 
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }


    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root=BinaryTreeBt.buildTree(nodes);
        // Traversal.preOrderTraversal(root);

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        // Traversal.preOrderTraversal(subRoot);

        System.out.println(isSubtree(root, subRoot));

        
    }
    
}
