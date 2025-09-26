package Binary_Tree;

import Binary_Tree.BinaryTree.Node;

public class Max_Depth {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;

        return depth;
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxDepth(root));

    }

}
