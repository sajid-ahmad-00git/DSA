package Binary_Search_Tree;

public class Build_BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static Node insertion(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;

        }
        if (val < root.data) {
            root.left = insertion(root.left, val);

        } else {
            root.right = insertion(root.right, val);
        }
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 5, 1, 3, 4, 2, 7 };
        int[] nodes2 = { 6, 3, 1, 2, 5, 4, 9, 7, 8, 10 };

        Node root = null;
        Node root2 = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insertion(root, nodes[i]);
        }

        inOrderTraversal(root);
        System.out.println();

        for (int i = 0; i < nodes2.length; i++) {
            root2 = insertion(root2, nodes2[i]);
        }

        inOrderTraversal(root2);
        System.out.println();

    }

}
