package Binary_Search_Tree;

import java.util.ArrayList;

import javax.swing.tree.TreeCellRenderer;

import Binary_Search_Tree.Build_BST.Node;

public class Kth_Smallest_In_BST {

    public static int kth_small_in_Bst(Node root, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        inOrder(root, list);

        return list.get(k - 1);

    }

    public static ArrayList<Integer> inOrder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return list;

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

        return list;
    }

    public static void main(String[] args) {
        int[] nodes2 = { 55, 11, 36, 44, 12, 87 };

        Node root = null;

        for (int i = 0; i < nodes2.length; i++) {
            root = Build_BST.insertion(root, nodes2[i]);
        }

        System.out.println(kth_small_in_Bst(root, 2));
    }

}
