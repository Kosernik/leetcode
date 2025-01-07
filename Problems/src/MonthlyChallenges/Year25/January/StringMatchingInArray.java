package MonthlyChallenges.Year25.January;

import java.util.*;

public class StringMatchingInArray {

    /**
     * LeetCode №1408. String Matching in an Array.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param words - a string of unique words. Each word contains only lowercase English letters.
     * @return - a list of all strings in words that is a substring of another word.
     */
    public List<String> stringMatching(String[] words) {
        List<String> substrings = new ArrayList<>();

        int length = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, int[]> lettersCounts = new HashMap<>();
        for (String word : words) {
            lettersCounts.put(word, getLettersCount(word));
        }

        for (int i = 0; i < length - 1; i++) {
            String candidate = words[i];
            int[] candidateCount = lettersCounts.get(candidate);
            boolean isSubstring = false;

            for (int j = i + 1; j < length && !isSubstring; j++) {
                int[] wordCount = lettersCounts.get(words[j]);

                if (hasAllLetters(candidateCount, wordCount)) {
                    if (isSubstring(candidate, words[j])) {
                        isSubstring = true;
                    }
                }
            }

            if (isSubstring) {
                substrings.add(candidate);
            }
        }

        return substrings;
    }

    private boolean isSubstring(String candidate, String word) {
        char firstLetter = candidate.charAt(0);
        for (int i = 0; i < word.length() - candidate.length() + 1; i++) {
            if (word.charAt(i) == firstLetter) {
                boolean validCandidate = true;

                for (int j = 0; j < candidate.length(); j++) {
                    if (word.charAt(i + j) != candidate.charAt(j)) {
                        validCandidate = false;
                        break;
                    }
                }

                if (validCandidate) return true;
            }
        }

        return false;
    }

    private boolean hasAllLetters(int[] candidateCount, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            if (candidateCount[i] > wordCount[i]) return false;
        }

        return true;
    }

    private int[] getLettersCount(String word) {
        int[] count = new int[26];

        for (char letter : word.toCharArray()) {
            count[letter - 'a']++;
        }

        return count;
    }
}
