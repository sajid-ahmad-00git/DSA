package Binary_Search_Tree;

import java.util.ArrayList;

import Binary_Search_Tree.Build_BST.Node;

public class Merge_2_BST {

    public static void getInorder(Node root, ArrayList<Integer> list) {

        if (root == null)
            return;

        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);

    }

    public static ArrayList<Integer> merge_array(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> sortedlist = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                sortedlist.add(arr1.get(i));
                i++;

            } else {
                sortedlist.add(arr2.get(j));
                j++;

            }

        }
        while (i < arr1.size()) {
            sortedlist.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            sortedlist.add(arr2.get(j));
            j++;
        }
        System.out.println(sortedlist.toString());
        return sortedlist;

    }

    public static Node createBST(ArrayList<Integer> list, int st, int end) {
        if (st > end)
            return null;
        int mid = st + (end - st) / 2;

        Node root = new Node(list.get(mid));
        root.left = createBST(list, st, mid - 1);
        root.right = createBST(list, mid + 1, end);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2) {

        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        ArrayList<Integer> sortedListforBST = merge_array(arr1, arr2);

        Node root = createBST(sortedListforBST, 0, sortedListforBST.size() - 1);

        return root;

    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(2);
        root1.left.right = new Node(7);
        root1.right.left = new Node(12);
        root1.right.right = new Node(21);

        preOrder(root1);
        System.out.println();

        Node root2 = new Node(50);
        root2.left = new Node(30);
        root2.right = new Node(70);
        root2.left.left = new Node(20);
        root2.left.right = new Node(40);
        root2.right.left = new Node(60);
        root2.right.right = new Node(80);

        preOrder(root2);
        System.out.println();

        Node root = mergeBSTs(root1, root2);

        preOrder(root);
    }

}
