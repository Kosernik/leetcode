package MonthlyChallenges.Year23.May;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    /**
     * LeetCode #1456. Maximum Number of Vowels in a Substring of Given Length.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of lower case english letters.
     * @param k - the length of a substring
     * @return - the maximum number of vowel letters in any substring of "s" with length k.
     */
    public int maxVowels(String s, int k) {
        char[] letters = s.toCharArray();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(letters[i])) {
                vowelCount++;
            }
        }
        int maxVowel = vowelCount;

        for (int i = k; i < letters.length; i++) {
            if (vowels.contains(letters[i - k])) {
                vowelCount--;
            }
            if (vowels.contains(letters[i])) {
                vowelCount++;
            }

            maxVowel = Math.max(maxVowel, vowelCount);
        }

        return maxVowel;
    }
}
