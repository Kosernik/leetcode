package MonthlyChallenges.Year25.May;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {

    /**
     * LeetCode №3362. Zero Array Transformation III.
     * <p>
     * Complexity - O(N * MlogM), N = nums.length, M = queries.length.
     * Memory - O(M)
     * <p>
     * Each queries[i] represents the following action on nums:
     * * Decrement the value at each index in the range [left-index, right-index] in nums by at most 1.
     * * The amount by which the value is decremented can be chosen independently for each index.
     *
     * @param nums    - an array of non-negative integers.
     * @param queries - a 2d array of queries, where queries[i] = [left-index, right-index].
     * @return - the maximum number of elements that can be removed from queries, such that nums can still be converted
     * to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.
     */
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> farthest = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queriesInUse = new PriorityQueue<>();

        int queriesUsed = 0;
        int qLength = queries.length;

        for (int i = 0, q = 0; i < nums.length; i++) {
            int curNumber = nums[i];

            while (!queriesInUse.isEmpty() && queriesInUse.peek() < i) {  //  Removing outdated
                queriesInUse.poll();
            }

            while (q < qLength && queries[q][0] <= i) {  //  Adding potential queries
                farthest.offer(queries[q][1]);
                q++;
            }

            while (queriesInUse.size() < curNumber &&
                    !farthest.isEmpty() && farthest.peek() >= i) {  //  Using the farthest potential query
                queriesInUse.offer(farthest.poll());
                queriesUsed++;
            }

            if (queriesInUse.size() < curNumber) return -1; //  Can`t reduce to 0
        }

        return queries.length - queriesUsed;
    }
}
