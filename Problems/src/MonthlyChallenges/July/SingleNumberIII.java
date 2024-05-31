package MonthlyChallenges.July;

import java.util.*;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Boolean> seen = new HashMap<>();

        for (int number : nums) {
            if (seen.containsKey(number)) {
                seen.put(number, false);
            } else {
                seen.put(number, true);
            }
        }

        List<Integer> singles = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> entry : seen.entrySet()) {
            if (entry.getValue()) {
                singles.add(entry.getKey());
            }
        }
        int[] result = new int[singles.size()];

        for (int i = 0; i < singles.size(); i++) {
            result[i] = singles.get(i);
        }
        return result;
    }

    /**
     * LeetCode №260. Single Number III.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers in which exactly two elements appear only once and all the other elements
     *             appear exactly twice.
     * @return - an array of two elements that appear only once.
     */
    public int[] singleNumberAlt(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (numbers.contains(num)) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
        }

        int[] result = new int[2];
        int idx = 0;
        for (int number : numbers) {
            result[idx++] = number;
        }

        return result;
    }
}
