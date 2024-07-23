package MonthlyChallenges.Year24.July;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByIncreasingFrequency {

    /**
     * LeetCode №1636. Sort Array by Increasing Frequency.
     * <p>
     * Complexity - O(N + NlogN)
     * Memory - O(N + sorting memory)
     *
     * @param nums - an array of integers. -100 <= nums[i] <= 100
     * @return - array nums sorted in increasing order based on the frequency of the values. If multiple values have
     * the same frequency, sorts them in decreasing order.
     */
    public int[] frequencySort(int[] nums) {
        List<Integer> numbers = new ArrayList<>(nums.length);

        int[] freqs = new int[201];
        for (int number : nums) {
            freqs[number + 100]++;
            numbers.add(number);
        }

        numbers.sort((a, b) -> freqs[a + 100] == freqs[b + 100] ?
                Integer.compare(b, a) :
                Integer.compare(freqs[a + 100], freqs[b + 100]));

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }
}
