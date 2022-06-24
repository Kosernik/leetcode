package Problems;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget solution = new SumOfMutatedArrayClosestToTarget();

        int[] testArr = {1,2,2,3,4,5,5,6};
        System.out.println(solution.binarySearchRightmost(0, testArr));
        System.out.println(solution.binarySearchRightmost(1, testArr));
        System.out.println(solution.binarySearchRightmost(2, testArr));
        System.out.println(solution.binarySearchRightmost(5, testArr));
        System.out.println(solution.binarySearchRightmost(6, testArr));
        System.out.println(solution.binarySearchRightmost(7, testArr));
    }

    /**
     * LeetCode #1300. Sum of Mutated Array Closest to Target.
     *
     *  UNTESTED
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int result = 0;

        int[] prefixSums = new int[arr.length];
        prefixSums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSums[i] = prefixSums[i-1] + arr[i];
        }

        int lowVal = 0, highVal = (int) Math.ceil(target * 1.0 / arr.length), middle;

        while (lowVal < highVal) {
            middle = (highVal - lowVal) / 2 + lowVal;

            long sum = getUpdatedSum(middle, arr, prefixSums);
            int curDiff = (int) Math.abs(sum - target);

            if (curDiff < diff) {
                result = middle;
                diff = curDiff;
            } else if (curDiff == diff) {
                result = Math.min(result, curDiff);
            }

            if (sum == target) {
                return middle;
            } else if (sum > target){
                highVal = middle - 1;
            } else {
                lowVal = middle + 1;
            }
        }

        return result;
    }

    private long getUpdatedSum(int value, int[] arr, int[] prefixSums) {
        int idx = binarySearchRightmost(value, arr);
        int presum = idx >= 0 ? prefixSums[idx] : 0;
        long postsum = idx >= 0 ? ((long)value * (arr.length - idx)) : ((long)value * arr.length);

        return presum + postsum;
    }

    private int binarySearchRightmost(int target, int[] arr) {
        int left = 0, right = arr.length, middle;

        while (left < right) {
            middle = (right + left) / 2;

            if (arr[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right - 1;
    }
}
