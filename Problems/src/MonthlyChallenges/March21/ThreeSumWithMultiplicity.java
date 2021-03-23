package MonthlyChallenges.March21;

import java.util.*;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        ThreeSumWithMultiplicity solution = new ThreeSumWithMultiplicity();
        int[] arr0 = {1,1,2,2,3,3,4,4,5,5};
        System.out.println(solution.threeSumMulti(arr0, 8));

        int[] arr1 = {3,3,0,0,3,2,2,3};
        System.out.println("Test 1 - " + solution.threeSumMulti(arr1, 6));
    }

    // LeetCode #923.
    public int threeSumMulti(int[] arr, int target) {
        int MODULO = 1_000_000_007;
        long result = 0;
        Arrays.sort(arr);

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int twoSum = target - arr[i];
            int start = i+1;
            int stop = arr.length - 1;

            while (start < stop) {
                if (arr[start] + arr[stop] < twoSum) {
                    start++;
                } else if (arr[start] + arr[stop] > twoSum) {
                    stop--;
                } else if (arr[start] != arr[stop]) {
                    int left = 1;
                    int right = 1;

                    while (start+1 < stop && arr[start] == arr[start+1]) {
                        left++;
                        start++;
                    }
                    while (stop -1 > start && arr[stop] == arr[stop-1]) {
                        right++;
                        stop--;
                    }

                    result += (long) left * right;
                    result %= MODULO;

                    start++;
                    stop--;
                } else {
                    result += (long) (stop - start + 1) * (stop - start) / 2;
                    result %= MODULO;
                    break;
                }
            }
        }

        return (int) result;
    }

}
