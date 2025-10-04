package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

import Binary_Tree.BinaryTree.Node;

public class Min_Depth {

    public static int minDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            depth++;
        }
        return depth;

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(minDepth(root));
    }

}
