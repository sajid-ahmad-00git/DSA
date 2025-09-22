package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Sorterd_into_BST {

    public static Node createSortedBST(int[] nodes, int start, int end) {
        if (start > end)
            return null;
        int mid = end + (start - end) / 2;

        Node root = new Node(nodes[mid]);

        root.left = createSortedBST(nodes, start, mid - 1);
        root.right = createSortedBST(nodes, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 3, 5, 6, 8, 10, 11, 12 };

        Mirror_BST.preOrder(createSortedBST(nodes, 0, nodes.length - 1));
        System.out.println();

        Build_BST.inOrderTraversal(createSortedBST(nodes, 0, nodes.length - 1));
    }

}
