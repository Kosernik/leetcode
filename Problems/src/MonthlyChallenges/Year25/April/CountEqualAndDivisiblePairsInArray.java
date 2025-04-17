package MonthlyChallenges.Year25.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountEqualAndDivisiblePairsInArray {

    /**
     * LeetCode №2176. Count Equal and Divisible Pairs in an Array.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(1)
     *
     * @param nums - an array of integers.
     * @param k    - a non-negative integer.
     * @return - the number of good pairs.
     */
    public int countPairs(int[] nums, int k) {
        int result = 0;

        for (int i = 0, length = nums.length; i < length - 1; i++) {
            int number = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (number == nums[j] && (i * j) % k == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    /**
     * LeetCode №2176. Count Equal and Divisible Pairs in an Array.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @param k    - a non-negative integer.
     * @return - the number of good pairs.
     */
    public int countPairsSlow(int[] nums, int k) {
        int result = 0;

        Map<Integer, List<Integer>> numbersToIndices = new HashMap<>();

        for (int i = 0, length = nums.length; i < length; i++) {
            int number = nums[i];

            if (!numbersToIndices.containsKey(number)) {
                numbersToIndices.put(number, new ArrayList<>());
            }

            List<Integer> indices = numbersToIndices.get(number);

            for (int idx : indices) {
                if ((idx * i) % k == 0) {
                    result++;
                }
            }

            indices.add(i % k);
        }

        return result;
    }
}
