package MonthlyChallenges.Year26.January;

public class MaxDotProductOfTwoSubsequences {
    private int[] nums1;
    private int[] nums2;

    /**
     * LeetCode №1458. Max Dot Product of Two Subsequences.
     *
     * @param nums1 - an array of integers.
     * @param nums2 - an array of integers.
     * @return - the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        return dp(0, 0, new Integer[nums1.length][nums2.length]);
    }

    private int dp(int i, int j, Integer[][] computed) {
        if (i >= nums1.length || j >= nums2.length) {
            return Integer.MIN_VALUE;
        }

        if (computed[i][j] != null) {
            return computed[i][j];
        }

        int curResult = nums1[i] * nums2[j];

        if (i == (nums1.length - 1) && j == (nums2.length - 1)) {
            computed[i][j] = curResult;
            return curResult;
        } else {
            int nextScore = dp(i + 1, j + 1, computed);

            if (nextScore != Integer.MIN_VALUE) {
                if (curResult < 0 || nextScore < 0) {
                    curResult = Math.max(curResult, nextScore);
                } else {
                    curResult += nextScore;
                }
            }
        }

        int skipI = dp(i + 1, j, computed);

        int skipJ = dp(i, j + 1, computed);

        curResult = Math.max(curResult, Math.max(skipI, skipJ));

        computed[i][j] = curResult;
        return curResult;
    }
}
