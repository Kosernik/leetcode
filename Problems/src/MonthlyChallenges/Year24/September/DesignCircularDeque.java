package MonthlyChallenges.Year24.September;

public class DesignCircularDeque {
    /**
     * LeetCode №641. Design Circular Deque.
     */
    class MyCircularDeque {
        private final DequeNode head;

        private int size = 0;
        private final int maxSize;

        public MyCircularDeque(int k) {
            this.maxSize = k;

            head = new DequeNode(0);
            head.next = head;
            head.prev = head;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            DequeNode front = new DequeNode(value);
            front.prev = head;
            front.next = head.next;

            head.next = front;
            front.next.prev = front;

            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            DequeNode end = new DequeNode(value);
            end.next = head;
            end.prev = head.prev;

            head.prev = end;
            end.prev.next = end;

            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            DequeNode front = head.next;

            head.next = front.next;
            head.next.prev = head;

            front.prev = null;
            front.next = null;

            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            DequeNode end = head.prev;

            head.prev = end.prev;
            head.prev.next = head;

            end.next = null;
            end.prev = null;

            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            else return head.next.value;
        }

        public int getRear() {
            if (isEmpty()) return -1;
            else return head.prev.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        static class DequeNode {
            DequeNode prev;
            DequeNode next;
            int value;

            DequeNode(int value) {
                this.value = value;
            }
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
