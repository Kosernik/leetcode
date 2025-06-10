package MonthlyChallenges.Year25.June;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    /**
     * LeetCode №3442. Maximum Difference Between Even and Odd Frequency I.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @return - the maximum difference between an odd frequency of a letter and an even frequency of a letter.
     */
    public int maxDifference(String s) {
        int[] counts = new int[26];

        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        int minEven = Integer.MAX_VALUE;
        int maxOdd = 0;

        for (int count : counts) {
            if (count > 0) {
                if (count % 2 == 0) {
                    minEven = Math.min(minEven, count);
                } else {
                    maxOdd = Math.max(maxOdd, count);
                }
            }
        }

        return maxOdd - minEven;
    }
}
