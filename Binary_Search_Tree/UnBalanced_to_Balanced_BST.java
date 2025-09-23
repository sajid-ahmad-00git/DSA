package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Arrays;

import Binary_Search_Tree.Build_BST.Node;

public class UnBalanced_to_Balanced_BST {

    public static void getOrderList(Node root, ArrayList<Integer> inorderList) {
        if (root == null)
            return;

        getOrderList(root.left, inorderList);
        inorderList.add(root.data);
        getOrderList(root.right, inorderList);

    }

    public static Node createSortedBST(ArrayList<Integer> inorderList, int start, int end) {
        if (start > end)
            return null;
        int mid = end + (start - end) / 2;

        Node root = new Node(inorderList.get(mid));

        root.left = createSortedBST(inorderList, start, mid - 1);
        root.right = createSortedBST(inorderList, mid + 1, end);
        return root;
    }

    public static Node balanced_BST(Node root) {

        // find the inOrder Sequence
        ArrayList<Integer> list = new ArrayList<>();

        getOrderList(root, list);

        // create BST from inorder_List
        root = createSortedBST(list, 0, list.size() - 1);
        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        Mirror_BST.preOrder(root);
        System.out.println();
        System.out.println("Balanced BST afterwards : ");
        root = balanced_BST(root);
        Mirror_BST.preOrder(root);

    }
}