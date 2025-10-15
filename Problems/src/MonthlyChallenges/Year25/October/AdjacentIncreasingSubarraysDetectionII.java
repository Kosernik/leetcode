package MonthlyChallenges.Year25.October;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacentIncreasingSubarraysDetectionII {
    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionII solution = new AdjacentIncreasingSubarraysDetectionII();

        List<Integer> nums0 = convertArrayToList(new int[]{2, 5, 7, 8, 9, 2, 3, 4, 3, 1});
        int result0 = 3;
        System.out.println(solution.maxIncreasingSubarrays(nums0) == result0);

        System.out.println();
        List<Integer> nums1 = convertArrayToList(new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7});
        int result1 = 2;
        System.out.println(solution.maxIncreasingSubarrays(nums1) == result1);

        System.out.println();
        List<Integer> nums2 = convertArrayToList(new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int result2 = 5;
        System.out.println(solution.maxIncreasingSubarrays(nums2) == result2);
    }

    /**
     * LeetCode №3350. Adjacent Increasing Subarrays Detection II.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - a list of integers.
     * @return - the maximum value of k for which there exist two adjacent subarrays of length k each, such that both
     * subarrays are strictly increasing.
     */
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxLength = 0;

        int prevLength = 0;
        int start = 0;
        int prevNumber = nums.get(0) - 1;

        for (int i = 0; i < nums.size(); i++) {
            int curNumber = nums.get(i);

            if (curNumber <= prevNumber) {
                int curLength = i - start;

                maxLength = Math.max(maxLength, Math.max(curLength / 2, Math.min(prevLength, curLength)));

                prevLength = curLength;
                start = i;
            }

            prevNumber = curNumber;
        }

        int curLength = nums.size() - start;
        maxLength = Math.max(maxLength, Math.max(curLength / 2, Math.min(curLength, prevLength)));

        return maxLength;
    }

    private static List<Integer> convertArrayToList(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
