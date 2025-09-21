package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class IsVaild_BST {

    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null)
            return true;
        if (min != null && root.data <= min.data)
            return false;
        if (max != null && root.data >= max.data)
            return false;

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static void main(String[] args) {
        // int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int[] nodes = { 8, 5, 3, 1, 1, 4 };

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = Build_BST.insertion(root, nodes[i]);
        }

        Build_BST.inOrderTraversal(root);
        System.out.println();

        System.out.println(isValid(root, null, null));
    }

}
