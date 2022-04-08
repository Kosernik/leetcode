package MonthlyChallenges.Year22.April;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    /**
     * LeetCode #703. Kth Largest Element in a Stream.
     */
    class KthLargest {

        private final PriorityQueue<Integer> pq;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);

            for (int number : nums) {
                pq.add(number);
            }

            while (pq.size() > k) {
                pq.remove();
            }
        }

        public int add(int val) {
            pq.add(val);

            while (pq.size() > k) {
                pq.remove();
            }

            return pq.peek();
        }
    }
}
