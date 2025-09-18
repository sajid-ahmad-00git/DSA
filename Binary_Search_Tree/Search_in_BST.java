package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Search_in_BST {

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return search(root.left, key);

        } else {
            return search(root.right, key);

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

        System.out.println(search(root, 12));
    }

}
