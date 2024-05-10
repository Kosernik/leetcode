package MonthlyChallenges.Year24.May;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    /**
     * LeetCode №786. K-th Smallest Prime Fraction.
     * <p>
     * Complexity - O(N^2*logK)
     * Memory - O(K)
     *
     * @param arr - an array of prime numbers.
     * @param k   - the number of required fraction.
     * @return - the k-th smallest fraction considered
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int delimoe = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new Fraction(delimoe, arr[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        while (pq.size() > 1) {
            pq.poll();
        }
        Fraction fraction = pq.poll();
        return new int[]{fraction.delimoe, fraction.delitel};
    }

    class Fraction implements Comparable<Fraction> {
        int delimoe;
        int delitel;

        Fraction(int delimoe, int delitel) {
            this.delimoe = delimoe;
            this.delitel = delitel;
        }

        @Override
        public int compareTo(Fraction other) {
            return Integer.compare(other.delimoe * this.delitel, this.delimoe * other.delitel);
        }
    }
}
