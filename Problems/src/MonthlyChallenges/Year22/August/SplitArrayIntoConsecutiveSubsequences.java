package MonthlyChallenges.Year22.August;

import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {

    /**
     * LeetCode 659. Split Array into Consecutive Subsequences.
     * <p>
     * Complexiy - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers that is sorted in non-decreasing order.
     * @return - True - if it is possible to split 'nums' into one or more subsequences such that both of the following
     * conditions are true:
     * - Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous
     * integer).
     * - All subsequences have a length of 3 or more.
     * False - otherwise.
     */
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                (a, b) -> a[0].intValue() != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        for (int number : nums) {
            if (pq.isEmpty()) {
                pq.offer(new Integer[]{number, 1});
            } else {
                while (!pq.isEmpty() && (number - pq.peek()[0] > 1)) {
                    if (pq.peek()[1] < 3) return false;
                    pq.poll();
                }

                if (pq.isEmpty() || (pq.peek()[0] == number)) {
                    pq.offer(new Integer[]{number, 1});
                    continue;
                }

                Integer[] prev = pq.poll();
                prev[0] = number;
                prev[1]++;

                pq.offer(prev);
            }
        }

        while (!pq.isEmpty()) {
            if (pq.poll()[1] < 3) return false;
        }

        return true;
    }
}
