package MonthlyChallenges.Year25.October;

import java.util.ArrayList;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {

    /**
     * LeetCode №2273. Find Resultant Array After Removing Anagrams.
     *
     * @param words - an array of strings, each string consists of lowercase english letters.
     * @return - a list words after removing anagram words.
     */
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();

        int[] prevCount = new int[26];

        for (String word : words) {
            int[] curCount = countLetters(word);

            if (!compareCountsEquals(prevCount, curCount)) {
                result.add(word);
                prevCount = curCount;
            }
        }

        return result;
    }

    private static boolean compareCountsEquals(int[] first, int[] second) {
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }

        return true;
    }

    private static int[] countLettersSlow(String word) {
        int[] count = new int[26];

        for (char letter : word.toCharArray()) {
            count[letter - 'a']++;
        }

        return count;
    }

    private static int[] countLetters(String word) {
        int[] count = new int[26];

        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }

        return count;
    }
}
