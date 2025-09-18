package Binary_Tree;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Transform_into_sum_tree {

    public static int transform(Node root) {
        if (root == null)
            return 0;

        // store old value
        int oldData = root.data;

        // get sum of left and right subtrees
        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        // change current node’s data to sum of left + right subtree values
        root.data = leftSum + rightSum;

        // return total sum of this subtree to parent
        return oldData + root.data;
    }

    public static int transform2(Node root) {
        if (root == null)
            return 0;
        int left = transform2(root.left);
        int right = transform2(root.right);
        int oldData = root.data;
        int leftData = (root.left == null) ? 0 : root.left.data;
        int rightData = (root.right == null) ? 0 : root.right.data;
        root.data = left + right + leftData + rightData;
        return oldData;
    }

    public static void main(String[] args) {

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

        Node root = BinaryTreeBt.buildTree(nodes);

        System.out.println(transform(root)); // its return root as 28
        Traversal.preOrderTraversal(root); // when we traverse it returns 27 ,9 ,0 ,0 13,0 ,0

    }
}
