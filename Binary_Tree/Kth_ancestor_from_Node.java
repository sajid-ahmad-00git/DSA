package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Kth_ancestor_from_Node {
    static boolean found = false;  // global flag

    public static int kth_ancestor(Node root, int k, int n) {
        if (root == null) return -1;
        if (root.data == n) return 0;

        int left_distance = kth_ancestor(root.left, k, n);
        int right_distance = kth_ancestor(root.right, k, n);

        if (left_distance == -1 && right_distance == -1) {
            return -1;
        }

        int max = Math.max(left_distance, right_distance);

        if (max+1 == k && !found) {
            System.out.println("Kth ancestor: " + root.data);
            found = true;
        

        }
        return max+1 ;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

        Node root = BinaryTreeBt.buildTree(nodes);
        kth_ancestor(root, 1, 7); // find 2nd ancestor of 5
    }
}
