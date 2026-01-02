package MonthlyChallenges.Year21.May21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    /**
     * LeetCode #890.
     * <p>
     * Complexity - O(N*M), M - pattern.length(), N - words.length
     * Memory - O(M)
     *
     * @param words   - array of strings.
     * @param pattern - a string.
     * @return - a list of all words in "words" that follows "pattern".
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Integer>> patternMap = getPattern(pattern);
        int length = pattern.length();

        for (String word : words) {
            boolean[] usedLetters = new boolean[26];
            boolean[] processed = new boolean[length];
            boolean valid = true;

            for (int i = 0; i < length; i++) {
                char currChar = word.charAt(i);
                int currCharIdx = currChar - 'a';
                if (usedLetters[currCharIdx] && processed[i]) {
                    continue;
                } else if (usedLetters[currCharIdx] && !processed[i]) {
                    valid = false;
                    break;
                } else if (!usedLetters[currCharIdx] && !processed[i]) {
                    char patternCharAtIdx = pattern.charAt(i);
                    List<Integer> listOfIndexes = patternMap.get(patternCharAtIdx);
                    for (int idx : listOfIndexes) {
                        if (word.charAt(idx) != currChar || processed[idx]) {
                            valid = false;
                            break;
                        }
                        processed[idx] = true;
                    }
                    usedLetters[currCharIdx] = true;
                }
            }

            if (valid) result.add(word);
        }

        return result;
    }

    private Map<Character, List<Integer>> getPattern(String pattern) {
        Map<Character, List<Integer>> patternMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            List<Integer> currList = patternMap.getOrDefault(pattern.charAt(i), new ArrayList<>());
            currList.add(i);
            patternMap.put(pattern.charAt(i), currList);
        }

        return patternMap;
    }


    /**
     * LeetCode #890. Find and Replace Pattern.
     * <p>
     * Complexity - O(N*M), N = words.length, M = pattern.length() = words[i].length().
     * Memory - O(1)
     *
     * @param words   - an array of words of lowercase English letters.
     * @param pattern - a pattern string of lowercase English letters. words[i].length == pattern.length
     * @return - the list of words from 'words' that matches pattern.
     */
    public List<String> findAndReplacePatternAlt(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (samePattern(word, pattern)) result.add(word);
        }

        return result;
    }

    private boolean samePattern(String word, String pattern) {
        Map<Character, Character> letters = new HashMap<>();
        boolean[] usedLetters = new boolean[26];

        char[] wordLetters = word.toCharArray();
        char[] patternLetters = pattern.toCharArray();

        for (int i = 0; i < wordLetters.length; i++) {
            if (letters.containsKey(wordLetters[i])) {
                if (letters.get(wordLetters[i]) != patternLetters[i]) return false;
                continue;
            }
            if (usedLetters[patternLetters[i] - 'a']) return false;
            usedLetters[patternLetters[i] - 'a'] = true;
            letters.put(wordLetters[i], patternLetters[i]);
        }

        return true;
    }
}
