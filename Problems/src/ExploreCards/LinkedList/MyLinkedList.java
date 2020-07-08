package ExploreCards.LinkedList;

public class MyLinkedList {

    private final ListNode HEAD;
    private long size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.HEAD = new ListNode(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode currNode = HEAD;
        int currIndex = -1;

        while (currNode.getNext() != null && currIndex != index) {
            currNode = currNode.getNext();
            currIndex++;
        }
        return currNode.getVal();
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode currNext = HEAD.getNext();
        ListNode node = new ListNode(val);

        node.setNext(currNext);
        HEAD.setNext(node);
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode currNode= HEAD;

        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }
        currNode.setNext(node);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
     * not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        else if (index == 0) {
            addAtHead(val);
            return;
        }
        else if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode node = new ListNode(val);

        int currIdx = -1;
        ListNode currNode = HEAD;

        while (currNode.getNext() != null && currIdx != (index-1)) {
            currNode = currNode.getNext();
            currIdx++;
        }

        node.setNext(currNode.getNext());
        currNode.setNext(node);

        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        int currIndex = -1;
        ListNode currNode = HEAD;

        while (currNode.getNext() != null && currIndex != (index-1)) {
            currNode = currNode.getNext();
            currIndex++;
        }
        ListNode currNext = currNode.getNext();
        currNode.setNext(currNode.getNext().getNext());
        if (currNext != null) currNext.setNext(null);

        size--;
    }

    class ListNode {
        private int val;
        private ListNode next;
        ListNode (int val) {
            this.val = val;
        }

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
    }
}
