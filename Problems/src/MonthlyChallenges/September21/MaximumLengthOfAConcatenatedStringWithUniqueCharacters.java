package MonthlyChallenges.September21;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    /**
     * LeetCode 1239. Maximum Length of a Concatenated String with Unique Characters.
     *
     * @param arr - a list of words of english lowercase letters.
     * @return - the maximum length of a concatenation of words from "arr" with unique characters.
     */
    public int maxLength(List<String> arr) {
        List<String> concats = new ArrayList<>();
        concats.add("");

        for (String word : arr) {
            if (!isValid(word)) continue;

            List<String> curList = new ArrayList<>();
            for (String candidate : concats) {
                String curCandidate = candidate + word;
                if (isValid(curCandidate)) curList.add(curCandidate);
            }

            concats.addAll(curList);
        }

        int result = 0;
        for (String word : concats) result = Math.max(result, word.length());

        return result;
    }

    private boolean isValid(String word) {
        boolean[] letters = new boolean[26];
        for (char ch : word.toCharArray()) {
            if (letters[ch-'a']) return false;
            letters[ch-'a'] = true;
        }
        return true;
    }
}
