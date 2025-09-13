package MonthlyChallenges.Year25.September;

public class FindMostFrequentVowelAndConsonant {

    /**
     * LeetCode №3541. Find Most Frequent Vowel and Consonant.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @return - the sum of counts of max frequent vowel and max frequent consonant.
     */
    public int maxFreqSum(String s) {
        int[] counts = new int[26];
        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        for (int i = 0; i < counts.length; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) { // index of vowels
                maxVowel = Math.max(maxVowel, counts[i]);
            } else {    // consonants
                maxConsonant = Math.max(maxConsonant, counts[i]);
            }
        }

        return maxVowel + maxConsonant;
    }
}
