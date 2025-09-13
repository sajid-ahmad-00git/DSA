package Binary_Tree;

public class BinaryTree{

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    static class BinaryTreeBt{
        static int idx=-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1) {
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode; // this will return the root node from where the tree start getting build;

        }
    }

    public static void main(String[] args) {
    int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
    Node root=BinaryTreeBt.buildTree(nodes);   // the class was static that's why i dont have to create the Object 

    System.out.println(root.data);
    BinaryTreeBt.idx=-1;        // this is bcz at first i have called the function buildTree and index has reached 14
    // now when i do Node treeRoot=tree.buildTree(nodes) it says exception out of bound 
    // either you do one of them or want to do both then reset the index to -1

    BinaryTreeBt tree=new BinaryTreeBt();
    Node treeRoot=tree.buildTree(nodes);
    System.out.println(treeRoot.data);


        
    }

}