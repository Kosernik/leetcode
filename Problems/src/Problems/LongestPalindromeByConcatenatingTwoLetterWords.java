package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        LongestPalindromeByConcatenatingTwoLetterWords solution = new LongestPalindromeByConcatenatingTwoLetterWords();

        String[] test = {"lc","cl","gg"};

        System.out.println(solution.longestPalindrome(test));
    }

    /**
     * LeetCode #2131. Longest Palindrome by Concatenating Two Letter Words.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param words - an array of words of length 2.
     * @return - the length of the longest palindrome formed with words.
     */
    public int longestPalindrome(String[] words) {
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        int result = 0;
        boolean foundSymmetricalWord = false;
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String word = entry.getKey();
            if (visited.contains(word)) continue;

            String reversed = word.substring(1) + word.charAt(0);

            if (word.equals(reversed)) {
                if (entry.getValue() % 2 != 0) {
                    foundSymmetricalWord = true;
                }
                result += 2 * word.length() * (entry.getValue() / 2);
            } else {
                if (counts.containsKey(reversed)) {
                    result += 2 * word.length() * Math.min(entry.getValue(), counts.get(reversed));
                    visited.add(reversed);
                }
            }
        }

        if (foundSymmetricalWord) result += 2;
        return result;
    }
}
