package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Sum_of_lastLeaves {

    public static int sum_of_left_leaves(Node root) {

        if (root == null)
            return 0;

        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {

            sum += root.left.data;

        }
        sum += sum_of_left_leaves(root.left);
        sum += sum_of_left_leaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 8, -1, -1, 7, -1, -1 };

        Node root = BinaryTreeBt.buildTree(nodes);

        System.out.println(sum_of_left_leaves(root));

    }

}