package Problems;

import java.util.Arrays;

public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        WaysToSplitArrayIntoThreeSubarrays solution = new WaysToSplitArrayIntoThreeSubarrays();

//        long[] test0 = {0,1,3,5,7,12,12};
//        long[] test1 = {1,3,3,3,4,4,4,7};
//        long[] test2 = {2,4,4,4,4,6,6,8};
//
//        System.out.println(solution.binarySearchRightmostIndex(test0, 7, test0.length) == 4);
//        System.out.println(solution.binarySearchRightmostIndex(test0, 8, test0.length) == 4);
//        System.out.println(solution.binarySearchRightmostIndex(test0, 9, test0.length) == 4);
//        System.out.println(solution.binarySearchRightmostIndex(test0, 12, test0.length) == 6);
//
//        System.out.println(solution.binarySearchRightmostIndex(test1, 0, test1.length) == 0);
//        System.out.println(solution.binarySearchRightmostIndex(test1, 3, test1.length) == 3);
//        System.out.println(solution.binarySearchRightmostIndex(test1, 8, test1.length) == 7);
//
//        System.out.println(solution.binarySearchRightmostIndex(test2, 2, test2.length) == 0);
//        System.out.println(solution.binarySearchRightmostIndex(test2, 4, test2.length) == 4);
//        System.out.println(solution.binarySearchRightmostIndex(test2, 8, test2.length) == 7);

        int[] test0 = {1,2,2,2,5,0};
        System.out.println(solution.waysToSplit(test0));
    }

    private final int MODULO = 1_000_000_007;
    private long[] prefixSums;

    // TODO wrong algorithm
    public int waysToSplit(int[] nums) {
        prefixSums = new long[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }
        long totalSum = prefixSums[prefixSums.length-1];

        System.out.println(Arrays.toString(prefixSums));
        System.out.println("Total sum: " + totalSum);

        int rightStart = (int) (totalSum - Math.ceil(totalSum / 3.0));
        int i = binarySearchRightmostIndex(prefixSums, rightStart, prefixSums.length);

        System.out.println("Right start: " + rightStart + ", idx: " + i);

        int result = 0;
        for (; i > 1; i--) {
            long leftSum = prefixSums[i];

            long halfSum = leftSum / 2;
            int numberOfSubArrs = binarySearchRightmostIndex(prefixSums, halfSum, i);

            System.out.println("Left sum: " + leftSum + ", half sum: " + halfSum + ", number of arrays: " + numberOfSubArrs);

            result = (result + numberOfSubArrs) % MODULO;
        }

        return result;
    }

    private int binarySearchRightmostIndex(long[] arr, long target, int right) {
        int left = 0, middle;
        right = right - 1;

        while (left < right) {
            middle = right - (right - left) / 2;

            if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return left;
    }
}
