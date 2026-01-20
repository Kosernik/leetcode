package MonthlyChallenges.Year26.January;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructMinimumBitwiseArrayI {

    /**
     * LeetCode №3314. Construct the Minimum Bitwise Array I.
     * <p>
     * You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and
     * ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
     * Additionally, you must minimize each value of ans[i] in the resulting array.
     *
     * @param nums - an array of prime numbers.
     * @return - the resulting array.
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int prime = nums.get(i);
            int curResult = -1;
            for (int j = 0; j < prime; j++) {
                if ((j | (j + 1)) == prime) {
                    curResult = j;
                    break;
                }
            }

            result[i] = curResult;
        }

        return result;
    }

    public int[] minBitwiseArraySlow(List<Integer> nums) {
        int[] result = new int[nums.size()];

        Map<Integer, Integer> numbers = getNumbers(1000);

        for (int i = 0; i < nums.size(); i++) {
            result[i] = numbers.getOrDefault(nums.get(i), -1);
        }

        return result;
    }

    private Map<Integer, Integer> getNumbers(int lastNumber) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i <= lastNumber; i++) {
            int or = i | (i + 1);

            int prev = numbers.getOrDefault(or, Integer.MAX_VALUE);
            numbers.put(or, Math.min(i, prev));
        }

        return numbers;
    }
}
