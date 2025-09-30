package Linked_List;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Delete_node_without_head {

    public static void delete_node(Node delnode) {

        Node delNext = delnode.next;
        delnode.data = delNext.data;
        delnode.next = delNext.next;

    }

    public static void printLinked(Node head) {
        if (head == null)
            return;

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(20);
        head.next.next.next = new Node(10);

        delete_node(head.next.next);

        printLinked(head);

    }

}
