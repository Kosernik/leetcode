package MonthlyChallenges.Year26.April;

import java.util.HashMap;
import java.util.Map;

public class SumOfDistances {
    public static void main(String[] args) {
        SumOfDistances solution = new SumOfDistances();

        int[] nums0 = {1, 3, 1, 1, 2};
        long[] answer0 = {5, 0, 3, 4, 0};
        long[] result0 = solution.distance(nums0);
        for (int i = 0; i < answer0.length; i++) {
            System.out.print(answer0[i] + " " + result0[i] + " ");
            System.out.println(answer0[i] == result0[i]);
        }

        System.out.println();
        int[] nums1 = {0, 5, 3};
        long[] answer1 = {0, 0, 0};
        long[] result1 = solution.distance(nums1);
        for (int i = 0; i < answer1.length; i++) {
            System.out.print(answer1[i] + " " + result1[i] + " ");
            System.out.println(answer1[i] == result1[i]);
        }

        System.out.println();
        int[] nums2 = {2, 1, 3, 1, 2, 3, 3};
        long[] answer2 = {4, 2, 7, 2, 4, 4, 5};
        long[] result2 = solution.distance(nums2);
        for (int i = 0; i < answer2.length; i++) {
            System.out.print(answer2[i] + " " + result2[i] + " ");
            System.out.println(answer2[i] == result2[i]);
        }

        System.out.println();
        int[] nums3 = {10, 5, 10, 10};
        long[] answer3 = {5, 0, 3, 4};
        long[] result3 = solution.distance(nums3);
        for (int i = 0; i < answer3.length; i++) {
            System.out.print(answer3[i] + " " + result3[i] + " ");
            System.out.println(answer3[i] == result3[i]);
        }
    }

    /**
     * LeetCode №2615. Sum of Distances.
     *
     * @param nums - an array of integers. nums.length = n.
     * @return - an array intervals of length n where intervals[i] is the sum of intervals between nums[i] and each
     * element in arr with the same value as nums[i].
     */
    public long[] distance(int[] nums) {
        int length = nums.length;
        long[] intervals = new long[length];

        long[] sumOfPrevIndices = new long[length];
        long[] sumOfNextIndices = new long[length];

        int[] countOfPrevIndices = new int[length];
        int[] countOfNextIndices = new int[length];

        Map<Integer, Integer> prevIndices = new HashMap<>();
        for (int i = length - 1; i >= 0; i--) {
            int number = nums[i];

            int prevIdx = prevIndices.getOrDefault(number, -1);

            if (prevIdx != -1) {
                countOfNextIndices[i] += countOfNextIndices[prevIdx];
                sumOfNextIndices[i] += sumOfNextIndices[prevIdx];
            }

            countOfNextIndices[i] += 1;
            sumOfNextIndices[i] += i;

            prevIndices.put(number, i);
        }

        prevIndices = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int number = nums[i];

            int prevIdx = prevIndices.getOrDefault(number, -1);

            if (prevIdx != -1) {
                countOfPrevIndices[i] += countOfPrevIndices[prevIdx];
                sumOfPrevIndices[i] += sumOfPrevIndices[prevIdx];
            }

            countOfPrevIndices[i] += 1;
            sumOfPrevIndices[i] += i;

            prevIndices.put(number, i);

            intervals[i] = countOfPrevIndices[i] * (long) i - sumOfPrevIndices[i] + sumOfNextIndices[i] - countOfNextIndices[i] * (long) i;
        }

        return intervals;
    }
}
