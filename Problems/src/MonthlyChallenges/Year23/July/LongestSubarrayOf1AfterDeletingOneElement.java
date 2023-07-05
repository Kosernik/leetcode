package MonthlyChallenges.Year23.July;

public class LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubarrayOf1AfterDeletingOneElement solution = new LongestSubarrayOf1AfterDeletingOneElement();

        int[][] tests = {
                {1, 1, 0, 1},
                {0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 0},
                {1},
                {0}
        };
        int[] results = {
                3,
                5,
                2,
                6,
                3,
                3,
                0,
                0,
                0
        };

        if (tests.length != results.length) {
            System.out.println("Wrong tests");
        }

        for (int i = 0; i < tests.length; i++) {
            int result = solution.longestSubarray(tests[i]);
            if (result != results[i]) {
                System.out.println("Wrong result for test #" + (i + 1));
                System.out.println(result + " =/= " + results[i]);
            }
        }

        System.out.println("Done!");
    }

    /**
     * LeetCode #1493. Longest Subarray of 1's After Deleting One Element.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of '0' and '1'
     * @return - the maximum length of a non-empty subarray of 1`s after deleting exactly one element from the array.
     * Returns 0 if there is no such subarray.
     */
    public int longestSubarray(int[] nums) {
        int longestResult = 0;
        if (nums == null || nums.length == 0) return longestResult;

        int prevLength = 0;
        int curLength = 0;
        boolean prevIsZero = true;
        int idx = 0;

        while (idx < nums.length) {
            if (nums[idx] == 1) {
                curLength++;
                prevIsZero = false;

            } else {
                if (prevIsZero) {
                    prevLength = 0;
                } else {
                    longestResult = Math.max(longestResult, prevLength + curLength);
                    prevLength = curLength;
                    curLength = 0;
                    prevIsZero = true;
                }
            }
            idx++;
        }

        longestResult = Math.max(longestResult, prevLength + curLength);
        if (longestResult == nums.length) longestResult--;
        return longestResult;
    }
}
