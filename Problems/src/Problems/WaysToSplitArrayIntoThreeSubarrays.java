package Problems;

public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        WaysToSplitArrayIntoThreeSubarrays solution = new WaysToSplitArrayIntoThreeSubarrays();

//        int[] test0 = {0,1,3,5,7,12,12};
//        int[] test1 = {1,3,3,3,4,4,4,7};
//        int[] test2 = {2,2,4,4,4,6,6,8};

//        System.out.println(solution.leftmostGreaterOrEqual(test0, -2) == 0);
//        System.out.println(solution.leftmostGreaterOrEqual(test0, 0) == 0);
//        System.out.println(solution.leftmostGreaterOrEqual(test0, 4) == 3);
//        System.out.println(solution.leftmostGreaterOrEqual(test0, 5) == 3);
//        System.out.println(solution.leftmostGreaterOrEqual(test0, 12) == 5);
//        System.out.println(solution.leftmostGreaterOrEqual(test0, 13) == 7);
//
//        System.out.println(solution.leftmostGreaterOrEqual(test1, 0) == 0);
//        System.out.println(solution.leftmostGreaterOrEqual(test1, 3) == 1);
//        System.out.println(solution.leftmostGreaterOrEqual(test1, 7) == 7);
//        System.out.println(solution.leftmostGreaterOrEqual(test1, 8) == 8);
//
//        System.out.println("---------------");
//        System.out.println(solution.rightmostSmallerOrEqual(test0, -2) == -1);
//        System.out.println(solution.rightmostSmallerOrEqual(test0, 0) == 0);
//        System.out.println(solution.rightmostSmallerOrEqual(test0, 4) == 2);
//        System.out.println(solution.rightmostSmallerOrEqual(test0, 5) == 3);
//        System.out.println(solution.rightmostSmallerOrEqual(test0, 12) == 6);
//        System.out.println(solution.rightmostSmallerOrEqual(test0, 13) == 6);
//
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 0) == -1);
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 2) == 1);
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 3) == 1);
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 6) == 6);
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 8) == 7);
//        System.out.println(solution.rightmostSmallerOrEqual(test2, 9) == 7);


        int[] test10 = {1,2,2,2,5,0};
        System.out.println(solution.waysToSplit(test10));

        int[] test11 = {0,3,3};
        System.out.println(solution.waysToSplit(test11));

        int[] test12 = {0,0,0,1};
        System.out.println(solution.waysToSplit(test12));

        int[] test13 = {0,0,0};
        System.out.println(solution.waysToSplit(test13));

        int[] test14 = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution.waysToSplit(test14));
    }


    /**
     * LeetCode #1712. Ways to Split Array Into Three Subarrays.
     *
     * Complexity - (N + logN)
     * Memory - O(N)
     *
     * @param nums - an array of non-negative integers.
     * @return - the number of ways to split nums into 3 good subarrays.
     */
    public int waysToSplit(int[] nums) {
        if (nums.length == 3) return isValidArr(nums);

        int MODULO = 1_000_000_007;
        long result = 0L;

        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }
        int totalSum = prefixSums[prefixSums.length-1];

        for (int i = 0; i < nums.length-2; i++) {
            int leftSum = prefixSums[i];

            int remainder = totalSum - leftSum;
            if (leftSum*2 > remainder || leftSum*2 < 0) break;

            int middleMinIdx = leftmostGreaterOrEqual(prefixSums, leftSum*2);
            if (middleMinIdx <= i) {
                middleMinIdx = i+1;
            }

            int middleMaxVal = leftSum + remainder / 2;
            int middleMaxIdx = rightmostSmallerOrEqual(prefixSums, middleMaxVal);
            if (middleMaxIdx == nums.length-1) {
                middleMaxIdx = nums.length-2;
            }

            int curNumberOfArrays = middleMaxIdx - middleMinIdx + 1;

            result = (result + curNumberOfArrays) % MODULO;
        }

        return (int) result;
    }

    private int leftmostGreaterOrEqual(int[] prefixSums, int target) {
        int left = 0, right = prefixSums.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (prefixSums[middle] < target) {
                left = middle+1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private int rightmostSmallerOrEqual(int[] prefixSums, int target) {
        int left = -1, right = prefixSums.length-1, middle;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (prefixSums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return left;
    }

    private int isValidArr(int[] nums) {
        if (nums[0] <= nums[1] && nums[1] <= nums[2]) {
            return 1;
        } else {
            return 0;
        }
    }
}