package Binary_Tree;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Binary_Tree.BinaryTree.BinaryTreeBt;
import Binary_Tree.BinaryTree.Node;

public class ZigZag_Traversal {

    public static List<List<Integer>> zigzagLevelOrder(Node root) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (flag) {
                    level.add(curr.data);
                } else {
                    level.add(0, curr.data);
                }

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(level);
            flag = !flag;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        Node root = BinaryTreeBt.buildTree(nodes);

        List<List<Integer>> result = zigzagLevelOrder(root);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
