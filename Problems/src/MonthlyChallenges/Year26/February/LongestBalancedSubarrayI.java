package MonthlyChallenges.Year26.February;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubarrayI {
    public static void main(String[] args) {
        LongestBalancedSubarrayI solution = new LongestBalancedSubarrayI();

        int[] nums0 = {10, 6, 10, 7};
        int result0 = 2;
        System.out.println(solution.longestBalanced(nums0) == result0);
    }

    /**
     * LeetCode №3719. Longest Balanced Subarray I.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     * <p>
     * A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of
     * distinct odd numbers.
     *
     * @param nums - an array of integers.
     * @return - the length of the longest balanced subarray.
     */
    public int longestBalanced(int[] nums) {
        int result = 0;

        for (int i = 0, length = nums.length; i < length && ((length - i) > result); i++) {
            Map<Integer, Integer> evens = new HashMap<>(), odds = new HashMap<>();

            for (int j = i; j < length; j++) {
                int number = nums[j];
                Map<Integer, Integer> curMap = (number & 1) == 0 ? evens : odds;

                curMap.put(number, curMap.getOrDefault(number, 0) + 1);

                if (evens.size() == odds.size()) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }
}
