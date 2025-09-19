package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Delete_a_Node {

    public static Node delete(Node root, int val) {
        if (val > root.data) {
            root.right = delete(root.right, val);
        } else if (val < root.data) {
            root.left = delete(root.left, val);
        } else {
            // this is where root.data==val

            // case 1 => leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 => with only one child

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 => both children
            Node inorderSuccessor = findInOrderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {

        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = Build_BST.insertion(root, nodes[i]);
        }
        Build_BST.inOrderTraversal(root);
        System.out.println();

        delete(root, 5);

        Build_BST.inOrderTraversal(root);

    }
}
