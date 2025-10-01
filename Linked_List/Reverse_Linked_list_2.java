package Linked_List;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Reverse_Linked_list_2 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Step 1: Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move prev to node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Reverse sublist from left to right
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 4: Reconnect
        prev.next.next = curr; // tail of reversed part points to rest
        prev.next = prevSub; // prev connects to head of reversed part

        return dummy.next;
    }

    public static void printLinked(ListNode head) {
        if (head == null)
            return;

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(10);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);

        head = reverseBetween(head, 1, 4);
        printLinked(head);
    }
}
