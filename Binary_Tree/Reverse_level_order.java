package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class Reverse_level_order {

    public static ArrayList<Integer> reverse_level_order(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            st.push(currNode);

            if (currNode.right != null)
                q.add(currNode.right);
            if (currNode.left != null)
                q.add(currNode.left);

        }
        while (!st.isEmpty()) {
            list.add(st.pop().data);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = BinaryTreeBt.buildTree(nodes);
        ArrayList<Integer> result = reverse_level_order(root);
        Traversal.preOrderTraversal(root);
        System.out.println(result.toString());
    }
}
