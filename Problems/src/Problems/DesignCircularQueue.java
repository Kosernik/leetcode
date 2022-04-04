package Problems;

public class DesignCircularQueue {

    /**
     * LeetCode #622. Design Circular Queue.
     */
    class MyCircularQueue {

        private ListNode head = null;
        private ListNode tail = null;

        private final int k;
        private int size = 0;


        public MyCircularQueue(int k) {
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            size++;
            ListNode node = new ListNode(value);

            // Adding to an empty queue
            if (size == 1) {
                this.head = node;
                this.tail = node;
                return true;
            }

            node.prev = this.tail;
            this.tail.next = node;

            // Updating the tail of the queue
            this.tail = node;

            // Making a circle
            this.head.prev = this.tail;
            this.tail.next = this.head;

            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            size--;

            // The queue becomes empty
            if (size == 0) {
                this.head = null;
                this.tail = null;
                return true;
            }

            // Updating the head of the queue
            this.head = this.head.next;

            // Maintaining the circle
            this.head.prev = this.tail;
            this.tail.next = this.head;

            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : head.val;
        }

        public int Rear() {
            return isEmpty() ? -1 : tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }

        class ListNode {
            ListNode prev;
            ListNode next;
            int val;

            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}
