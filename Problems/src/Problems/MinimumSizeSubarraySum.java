package Problems;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        long[][] tests = {
                {0,1,2,3,4,5,6},{0,1,1,3,4,5,6},{0,1,3,3,4,5,6},
                {0,1,2,3,4,5,6,7},{0,1,1,3,4,5,6,7},{0,1,3,3,4,5,6,7},
                {-1,0,1,2,3,4,5,6},{-1,0,1,1,3,4,5,6},{-1,0,1,3,3,4,5,6},
                {0,1,2,2,4,5,6},{0,1,1,2,2,5,6},{0,1,1,1,2,5,6},{0,1,1,1,4,5,6}
        };

        int[] results = {
                2,3,2,
                2,3,2,
                3,4,3,
                2,3,4,4
        };

        for (int i = 0; i < tests.length; i++) {
            int idx = solution.binSearch(tests[i], 2);
            if (idx != results[i]) {
                System.out.println("Wrong result for test #" + i + ", got: " + idx + " instead of " + results[i]);
            }
        }
        System.out.println("Done test input \"1\"");

        System.out.println();
        for (int i = 0; i < tests.length; i++) {
            int idx = solution.binSearch(tests[i], -2);
            if (idx != 0) {
                System.out.println("Wrong result for test #" + i + ", got: " + idx + " instead of " + 0);
            }
        }
        System.out.println("Done test input \"2\"");

        System.out.println();
        for (int i = 0; i < tests.length; i++) {
            int idx = solution.binSearch(tests[i], 20);
            if (idx != tests[i].length) {
                System.out.println("Wrong result for test #" + i + ", got: " + idx + " instead of " + tests[i].length);
            }
        }
        System.out.println("Done test input \"3\"");
    }

    /**
     * LeetCode #209. Minimum Size Subarray Sum.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param target - a positive integer.
     * @param nums - an array of positive integers.
     * @return - the minimal length of a contiguous subarray of which the sum is greater than or equal to target.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int left = 0, curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum >= target) {
                while (curSum >= target) {
                    minLength = Math.min(minLength, i-left+1);
                    curSum -= nums[left++];
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * LeetCode #209. Minimum Size Subarray Sum.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param target - a positive integer.
     * @param nums - an array of positive integers.
     * @return - the minimal length of a contiguous subarray of which the sum is greater than or equal to target.
     */
    public int minSubArrayLenBinSearch(int target, int[] nums) {
        long[] sums = new long[nums.length+1];

        for (int i = 1; i < sums.length; i++) {
            if (nums[i-1] == target) return 1;
            sums[i] = sums[i-1] + nums[i-1];
        }

        int result = nums.length+1;

        for (int i = 0; i < nums.length; i++) {
            long curTarget = target + sums[i];

            int idx = binSearch(sums, curTarget);
            if (idx == sums.length) {
                if (sums[sums.length-1] - sums[i] >= target) {
                    result = Math.min(result, idx - i - 1);
                } else {
                    break;
                }
            } else {
                result = Math.min(result, idx-i);
            }
        }

        return result == nums.length+1 ? 0 : result;
    }

    private int binSearch(long[] arr, long target) {
        int left = 0, right = arr.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
