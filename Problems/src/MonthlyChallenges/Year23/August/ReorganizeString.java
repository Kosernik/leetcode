package MonthlyChallenges.Year23.August;

import java.util.ArrayList;
import java.util.List;

public class ReorganizeString {

    /**
     * LeetCode #767. Reorganize String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of lowercase english letters.
     * @return - a string 's' after rearranging all letters such that any two adjacent characters are not the same.
     * If the rearrangement is not possible - returns an empty string.
     */
    public String reorganizeString(String s) {
        int[] counts = new int[26];

        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        int maxCount = 0;
        char maxChar = ' ';

        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxChar = (char) ('a' + i);
            }
        }

        List<StringBuilder> blocks = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(maxChar);
            blocks.add(builder);
        }

        int idx = 0;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (letter == maxChar) continue;

            int curCount = counts[letter - 'a'];
            for (int i = 0; i < curCount; i++) {
                blocks.get(idx).append(letter);
                idx = (idx + 1) % maxCount;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder block : blocks) {
            result.append(block);
        }

        String candidate = result.toString();
        if (isValid(candidate)) {
            return candidate;
        } else {
            return "";
        }
    }

    private boolean isValid(String candidate) {
        char prev = '*';
        for (char letter : candidate.toCharArray()) {
            if (prev == letter) {
                return false;
            }
            prev = letter;
        }
        return true;
    }
}
