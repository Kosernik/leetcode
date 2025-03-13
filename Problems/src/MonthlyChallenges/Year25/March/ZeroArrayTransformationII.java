package MonthlyChallenges.Year25.March;

public class ZeroArrayTransformationII {

    /**
     * LeetCode №3356. Zero Array Transformation II.
     * <p>
     * Complexity - O(logM*N), N = nums.length, M = queries.length.
     * Memory - O(N)
     *
     * @param nums    - an array of integers.
     * @param queries - a 2d array of queries.
     *                query[i][0] - starting index of an interval,
     *                query[i][1] - ending index of an interval,
     *                query[i][2] - the amount by which each value in the interval can be decremented.
     * @return - the minimum possible non-negative value of k, such that after processing the first k queries in
     * sequence, nums becomes a Zero Array. If no such k exists, returns -1.
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length, middle;

        if (!helper(queries.length, nums, queries)) return -1;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (helper(middle, nums, queries)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean helper(int numberOfQueries, int[] nums, int[][] queries) {
        int[] diffArray = new int[nums.length + 1];

        for (int i = 0; i < numberOfQueries; i++) {
            int[] query = queries[i];
            int start = query[0], end = query[1], diff = query[2];

            diffArray[start] += diff;
            diffArray[end + 1] -= diff;
        }

        long sum = 0L;

        for (int i = 0; i < nums.length; i++) {
            sum += diffArray[i];

            if (sum < nums[i]) return false;
        }

        return true;
    }
}
