package MonthlyChallenges.July21;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
        FindKClosestElements solution = new FindKClosestElements();
        int[] test0 = {1,2,3,4,5};
        System.out.println(solution.findClosestElements(test0, 4, 3).toString());
    }

    /**
     * LeetCode #658.
     *
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param arr - sorted array of integers.
     * @param k - the size of the resulting list.
     * @param x - target value.
     * @return - sorted list of closest to target elements.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length-k;

        while (low < high) {
            int middle = (high + low) / 2;

            if (x - arr[middle] > arr[middle + k] - x) {
                low = middle+1;
            } else {
                high = middle;
            }
        }

        for (int i = low; i < (low+k); i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
