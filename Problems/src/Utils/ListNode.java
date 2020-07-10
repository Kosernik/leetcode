package Utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode getListFromArray(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode node = head;

        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    public static String printString(ListNode node) {
        StringBuilder builder = new StringBuilder();

        while (node != null) {
            builder.append(node.val);
            builder.append(" ");
            node = node.next;
        }

        return builder.toString();
    }
}
