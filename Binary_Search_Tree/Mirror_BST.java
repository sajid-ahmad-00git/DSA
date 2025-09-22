package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Mirror_BST {

    public static Node mirror(Node root) {

        if (root == null)
            return null;
        Node left_subtree = mirror(root.left);
        Node right_subtree = mirror(root.right);

        root.left = right_subtree;
        root.right = left_subtree;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = Build_BST.insertion(root, nodes[i]);
        }

        preOrder(root);

        System.out.println();

        mirror(root);
        preOrder(root);

    }

}
