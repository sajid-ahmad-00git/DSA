package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Print_in_Range {

    public static void print(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.data >= k1 && root.data <= k2) {
            print(root.left, k1, k2);
            System.out.print(root.data + " ");
            print(root.right, k1, k2);

        } else if (root.data < k1) {
            // current node and left subtree too small -> go right
            print(root.right, k1, k2);
        } else {
            // current node and right subtree too large -> go left

            print(root.left, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = Build_BST.insertion(root, nodes[i]);
        }

        Build_BST.inOrderTraversal(root);
        System.out.println();

        print(root, 5, 12);
    }

}
