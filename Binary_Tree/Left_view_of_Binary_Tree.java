package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Binary_Tree.BinaryTree.Node;

public class Left_view_of_Binary_Tree {

    public static ArrayList<Integer> left_view(Node root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (i == 0)
                    list.add(curr.data);

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return list;

    }

    // if we have a constraint to do it with a recurison
    // then

    public static ArrayList<Integer> left_view2(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        helper(root, list, 0);
        return list;
    }

    private static void helper(Node root, ArrayList<Integer> list, int level) {
        if (root == null)
            return;
        if (level == list.size()) {
            list.add(root.data);
        }
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(10);

        root.right = new Node(2);
        root.right.right = new Node(6);

        ArrayList<Integer> result = left_view(root);
        System.out.println(result.toString());

        ArrayList<Integer> result2 = left_view2(root);
        System.out.println(result2.toString());

    }
}
