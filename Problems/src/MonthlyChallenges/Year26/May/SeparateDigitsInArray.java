package MonthlyChallenges.Year26.May;

import java.util.ArrayList;
import java.util.List;

public class SeparateDigitsInArray {

    /**
     * LeetCode №2553. Separate the Digits in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - an array result that consists of the digits of each integer in nums after separating them in the same
     * order they appear in nums.
     */
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int number = nums[i];

            while (number > 0) {
                resultList.add(number % 10);
                number /= 10;
            }
        }

        int[] result = new int[resultList.size()];

        for (int i = 0, j = resultList.size() - 1; j >= 0; i++, j--) {
            result[j] = resultList.get(i);
        }

        return result;
    }

    /**
     * LeetCode №2553. Separate the Digits in an Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - an array result that consists of the digits of each integer in nums after separating them in the same
     * order they appear in nums.
     */
    public int[] separateDigitsAlt(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int number = nums[i];

            while (number > 0) {
                resultList.add(number % 10);
                number /= 10;
            }
        }

        int[] result = new int[resultList.size()];
        int idx = result.length - 1;

        for (int digit : resultList) {
            result[idx--] = digit;
        }

        return result;
    }
}
