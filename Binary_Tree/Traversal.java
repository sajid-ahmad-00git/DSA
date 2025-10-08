package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Traversal {


    public static void preOrderTraversal(Node root){
        if(root==null) return ;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    public static void postOrderTraversal(Node root){
        if(root==null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public static void levelOrderTraverSal(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.println(currNode.data + " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }if(currNode.right!=null){
                    q.add(currNode.right);
                }
                
            }
        }
    }
    public static void main(String[] args) {
    int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

    Node root=BinaryTreeBt.buildTree(nodes);   // did not created the object , bcz the class was static  
    preOrderTraversal(root);
    System.out.println();
    inOrderTraversal(root);
    System.out.println();
    postOrderTraversal(root);
    System.out.println();
    levelOrderTraverSal(root);


        
    }

    // this is the iterative postOrder

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;

        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            
            if(st.peek().right!=null){
                curr=st.peek().right;
            }else{

                TreeNode temp=st.pop();
                list.add(temp.val);
                while(!st.isEmpty() && temp==st.peek().right){
                    temp=st.pop();
                    list.add(temp.val);
                }
            }

           


        }
        return list;

        
    }

    
}
