package MonthlyChallenges.Year24.March;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {

    /**
     * LeetCode №3005. Count Elements With Maximum Frequency.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the total frequencies of elements in nums such that those elements all have the maximum frequency.
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        int numberOfMaxFreq = 0;

        for (int count : counts.values()) {
            if (count > maxFrequency) {
                maxFrequency = count;
                numberOfMaxFreq = 1;
            } else if (count == maxFrequency) {
                numberOfMaxFreq++;
            }
        }

        return maxFrequency * numberOfMaxFreq;
    }
}
