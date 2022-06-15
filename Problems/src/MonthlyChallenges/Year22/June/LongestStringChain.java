package MonthlyChallenges.Year22.June;

import java.util.*;

public class LongestStringChain {

    /**
     * LeetCode #1048. Longest String Chain.
     *
     * Complexity - O(N + N*M), N - the number  of words in "words" array, M - the length of a word.
     * Memory - O(N)
     *
     * @param words - an array of words
     * @return - the length of the longest possible word chain with words chosen from the given list of words.
     */
    public int longestStrChain(String[] words) {
        int result = 1;

        //  length -> list of words
        Map<Integer, List<String>> lengths = new HashMap<>();

        for (String word : words) {
            lengths.putIfAbsent(word.length(), new ArrayList<>());
            lengths.get(word.length()).add(word);
        }

        Map<String , Integer> computed = new HashMap<>();
        for (String word : words) {
            result = Math.max(result, dfsLength(word, lengths, computed));
        }

        return result;
    }

    private int dfsLength(String word, Map<Integer, List<String>> lengths, Map<String, Integer> computed) {
        if (computed.containsKey(word)) return computed.get(word);

        int result = 0;

        for (String candidate : lengths.getOrDefault(word.length()-1, Collections.emptyList())) {
            if (isPredecessor(candidate, word)) {
                result = Math.max(result, dfsLength(candidate, lengths, computed));
            }
        }

        result++;
        computed.put(word, result);
        return result;
    }


    private boolean isPredecessor(String candidate, String word) {
        if (candidate.length()+1 != word.length()) return false;

        boolean foundMissedLetter = false;

        for (int i = 0, c = 0; c < candidate.length(); i++, c++) {
            if (word.charAt(i) != candidate.charAt(c)) {
                if (foundMissedLetter) return false;
                foundMissedLetter = true;
                c--;
            }
        }

        return true;
    }
}
