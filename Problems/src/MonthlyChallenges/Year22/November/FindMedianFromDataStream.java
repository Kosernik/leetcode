package MonthlyChallenges.Year22.November;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /**
     * LeetCode #295. Find Median from Data Stream.
     * <p>
     * Complexity: addNum - O(logN), findMedian - O(1)
     * Memory - O(N)
     */
    class MedianFinder {

        private PriorityQueue<Integer> leftPQ;      // Biggest number from the left side on top
        private PriorityQueue<Integer> rightPQ;     // Smallest number from the right side on top

        public MedianFinder() {
            this.leftPQ = new PriorityQueue<>(Comparator.reverseOrder());
            this.rightPQ = new PriorityQueue<>();
        }

        public void addNum(int num) {
            leftPQ.add(num);
            balancePQs();
        }

        private void balancePQs() {
            if (leftPQ.size() - 2 >= rightPQ.size()) {
                rightPQ.add(leftPQ.poll());
            } else if (leftPQ.size() <= rightPQ.size() - 2) {
                leftPQ.add(rightPQ.poll());
            } else if (!rightPQ.isEmpty() && leftPQ.peek() > rightPQ.peek()) {
                rightPQ.add(leftPQ.poll());
                leftPQ.add(rightPQ.poll());
            }
        }


        public double findMedian() {
            if (leftPQ.size() == rightPQ.size()) {
                return ((double) leftPQ.peek() + rightPQ.peek()) / 2.0;
            } else if (leftPQ.size() > rightPQ.size()) {
                return (double) leftPQ.peek();
            } else {
                return (double) rightPQ.peek();
            }
        }
    }
}
