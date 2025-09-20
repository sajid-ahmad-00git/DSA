package Binary_Search_Tree;

import java.util.ArrayList;

import Binary_Search_Tree.Build_BST.Node;

public class Print_to_leaf {

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void print_till_leaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }
        print_till_leaf(root.left, path);
        print_till_leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] nodes = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = Build_BST.insertion(root, nodes[i]);
        }

        Build_BST.inOrderTraversal(root);
        System.out.println();
        ArrayList<Integer> path = new ArrayList<>();
        print_till_leaf(root, path);
    }

}
