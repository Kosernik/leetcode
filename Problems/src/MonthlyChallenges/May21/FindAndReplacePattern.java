package MonthlyChallenges.May21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    /**
     * LeetCode #890.
     *
     * Complexity - O(N*M), M - pattern.length(), N - words.length
     * Memory - O(M)
     *
     * @param words - array of strings.
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
                int currCharIdx = currChar-'a';
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
}
