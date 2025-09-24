package Binary_Search_Tree;

import Binary_Search_Tree.Build_BST.Node;

public class Size_of_Largest_BST {

    static class Info {
        boolean IsVaildBst;
        int size;
        int min;
        int max;

        public Info(boolean IsVaild_Bst, int size, int min, int max) {
            this.IsVaildBst = IsVaild_Bst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int max_size = 0;

    public static Info largest_size(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largest_size(root.left);
        Info rightInfo = largest_size(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.max > root.data || rightInfo.min < root.data) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.IsVaildBst && rightInfo.IsVaildBst) {
            max_size = Math.max(max_size, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Mirror_BST.preOrder(root);

        System.out.println("size of largest BST is : ");

        Info info = largest_size(root);
        System.out.println(max_size);
        System.out.println(info.size);

    }
}