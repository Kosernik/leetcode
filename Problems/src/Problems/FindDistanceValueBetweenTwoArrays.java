package Problems;

import java.util.Arrays;

public class FindDistanceValueBetweenTwoArrays {

    /**
     * LeetCode #1385. Find the Distance Value Between Two Arrays.
     *
     * Complexity - ((N+M)*logM), N = arr1.length, M = arr2.length.
     * Memory - O(1)
     *
     * @param arr1 - an array of integers.
     * @param arr2 - an array of integers.
     * @param d - a non-negative integer.
     * @return - the distance value between the two arrays.
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;

        Arrays.sort(arr2);

        for (int value : arr1) {
            int idx = binarySearch(arr2, value);

            int prev = idx > 0 ? arr2[idx-1] : arr2[idx];
            int cur = idx < arr2.length ? arr2[idx] : arr2[idx-1];

            int prevDiff = Math.abs(value - prev);
            int curDiff = Math.abs(value - cur);
            if (prevDiff > d && curDiff > d) {
                distance++;
            }
        }

        return distance;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
