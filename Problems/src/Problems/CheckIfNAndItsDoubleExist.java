package Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist solution = new CheckIfNAndItsDoubleExist();

        int[] test0 = {10,5,-9,15,3,8,12,-10};
        System.out.println(Arrays.toString(test0));
        System.out.println(solution.checkIfExistBinSearch(test0));

        int[] test1 = {-2,0,10,-19,4,6,-8};
        System.out.println(Arrays.toString(test1));
        System.out.println(solution.checkIfExistBinSearch(test1));
    }

    /**
     * LeetCode #1346. Check If N and Its Double Exist.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - True if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     *           False - otherwise.
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> visited = new HashSet<>();

        for (int number : arr) {
            if (visited.contains(number*2) || (number % 2 == 0 && visited.contains(number/2))) return true;
            visited.add(number);
        }
        return false;
    }

    /**
     * LeetCode #1346. Check If N and Its Double Exist.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param arr - an array of integers.
     * @return - True if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     *           False - otherwise.
     */
    public boolean checkIfExistBinSearch(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (number == 0) {
                if ((i > 0 && arr[i-1] == 0) || (i < arr.length-1 && arr[i+1] == 0)) return true;
                continue;
            }
            if (binSearch(arr, number * 2)) {
                return true;
            }
        }

        return false;
    }
    private boolean binSearch(int[] arr, int target) {
        int left = 0, right = arr.length-1, middle;

        while (left <= right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] == target) {
                return true;
            } else if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
