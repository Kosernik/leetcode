package MonthlyChallenges.Year24.November;


import java.util.PriorityQueue;

public class ShortestSubarrayWithSumAtLeastK {

    /**
     * LeetCode №862. Shortest Subarray with Sum at Least K.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - the minimum required sum of elements of a subarray.
     * @return - the shortest length of a subarray with the sum of all elements of at least k, or -1 if there is no such
     * subarray.
     */
    public int shortestSubarray(int[] nums, int k) {
        int result = Integer.MAX_VALUE;

        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.getKey(), b.getKey())
        );
        long curSum = 0L;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if (curSum >= k) {
                result = Math.min(result, i + 1);
            }

            while (!pq.isEmpty() && (curSum - pq.peek().getKey()) >= k) {
                result = Math.min(result, i - pq.poll().getVal());
            }

            pq.offer(new Pair<>(curSum, i));
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    class Pair<Long, Integer> {
        Long key;
        Integer val;

        Pair(Long key, Integer val) {
            this.key = key;
            this.val = val;
        }

        Long getKey() {
            return key;
        }

        Integer getVal() {
            return val;
        }
    }
}
