package Problems;

import java.util.Arrays;
import java.util.Collections;

public class MaximumSumObtainedOfAnyPermutation {
    public static void main(String[] args) {
        MaximumSumObtainedOfAnyPermutation solution = new MaximumSumObtainedOfAnyPermutation();
        solution.testMaxSumRangeQuery();
    }

    /**
     * Returns the maximum total sum of all requests among all permutations of nums.
     *
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param nums - array of integers.
     * @param requests - array of requests where requests[i] = [start-i, end-i]. The i-th request asks for the sum of
     *                 nums[start-i] + nums[start-i + 1] + ... + nums[end-i - 1] + nums[end-i] Both start-i and end-i
     *                 are 0-indexed.
     * @return - the maximum total sum of all requests among all permutations of nums, answer is modulo (10^9 + 7).
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] reqs = new int[length];
        for (int[] request : requests) {
            reqs[request[0]]++;
            if (request[1] < length-1) reqs[request[1]+1]--;
        }

        int prev = reqs[0];
        for (int i = 1; i < length; i++) {
            if (reqs[i] == 0) reqs[i] = prev;
            else {
                reqs[i] = prev + reqs[i];
                prev = reqs[i];
            }
        }

        Arrays.sort(reqs);

        long sum = 0;

        for (int i = length-1; i >= 0; i--) {
            if (reqs[i] == 0) break;
            sum += nums[i] * reqs[i];
        }

        return (int)(sum % (1000000007));
    }

    private void testMaxSumRangeQuery() {
        int[] test0 = {1,2,3,4,5};
        int[][] req0 = {{1,3},{0,1}};
        System.out.println(maxSumRangeQuery(test0, req0));
    }
}
