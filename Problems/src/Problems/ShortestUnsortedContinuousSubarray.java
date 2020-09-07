package Problems;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
        solution.testFindUnsortedSubarray();
    }

    /**
     * Returns the size of shortest continuous subarray that if you only sort this subarray in ascending order, then the
     * whole array will be sorted in ascending order, too.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - array of integers.
     * @return - minimum size of a subarray that needs to be sorted.
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int length = nums.length;

        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i-1]) {
                found = true;
            }
            if (found) {
                if (nums[i] <= min) {
                    min = nums[i];
                }
            }
        }
        if (!found) return 0;

        int max = Integer.MIN_VALUE;
        found = false;

        for (int i = length-2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                found = true;
            }
            if (found) {
                if (nums[i] >= max) {
                    max = nums[i];
                }
            }
        }

        int leftIdx = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == min) {
                while (i < length && nums[i] == min) {
                    i++;
                }
                leftIdx = i;
                break;
            } else if (nums[i] > min) {
                leftIdx = i;
                break;
            }
        }
        int rightIdx = length-1;
        for (int i = length-1; i >= 0; i--) {
            if (nums[i] == max) {
                while (i >= 0 && nums[i] == max) {
                    i--;
                }
                rightIdx = i;
                break;
            } else if (nums[i] < max) {
                rightIdx = i;
                break;
            }
        }

        return Math.min(length, rightIdx-leftIdx+1);
    }

    private void testFindUnsortedSubarray() {
        int[][] tests = {
                {2, 6, 4, 8, 10, 9, 15},
                {1,2,3,4,8,7,3,6,7,8,9,10},
                {1,2,3,3,3,4,8,7,3,6,7,8,9,10},
                {1,2,3,4,8,7,3,6,7,8,8,8,9,10},
                {1,2,3,4,5,6},
                {6,5,4,3,2,1},
                {1,1,1,1,1,1},
                {1,2,4,4,8,7,3,6,7,8,9,10},
                {1}
        };
        int[] results = {
                5,
                6,
                6,
                6,
                0,
                6,
                0,
                7,
                0
        };

        int failed = 0;

        for (int i = 0; i < results.length; i++) {
            if (findUnsortedSubarray(tests[i]) != results[i]) {
                failed++;
                System.out.println("Wrong result for test: " + Arrays.toString(tests[i]));
                System.out.println("Got: " + findUnsortedSubarray(tests[i]) + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (results.length - failed) * 100.0 / results.length);
    }
}
