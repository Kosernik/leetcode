package MonthlyChallenges.Year23.April;

import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {

    /**
     * LeetCode #2336. Smallest Number in Infinite Set.
     */
    class SmallestInfiniteSet {
        private final PriorityQueue<Integer> infiniteSet = new PriorityQueue<>();
        private int largestPopped = 0;

        /**
         * Initializes the SmallestInfiniteSet object to contain all positive integers.
         */
        public SmallestInfiniteSet() {
            infiniteSet.offer(1);
        }

        /**
         * Removes and returns the smallest integer contained in the infinite set.
         *
         * @return - the smallest positive number contained in the infinite set.
         */
        public int popSmallest() {
            int smallest = infiniteSet.poll();
            if (infiniteSet.isEmpty()) {
                infiniteSet.offer(smallest + 1);
            }

            largestPopped = Math.max(largestPopped, smallest);
            return smallest;
        }

        /**
         * Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
         *
         * @param num - a positive integer.
         */
        public void addBack(int num) {
            if (num <= largestPopped && !infiniteSet.contains(num)) {
                infiniteSet.offer(num);
            }
        }
    }
}
