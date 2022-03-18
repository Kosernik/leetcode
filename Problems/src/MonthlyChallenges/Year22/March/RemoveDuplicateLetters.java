package MonthlyChallenges.Year22.March;

import java.util.ArrayDeque;

public class RemoveDuplicateLetters {

    /**
     * LeetCode #316. Remove Duplicate Letters.
     * LeetCode #1081. Smallest Subsequence of Distinct Characters.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of english lowercase letters.
     * @return - the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly
     *           once.
     */
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        char[] letters = s.toCharArray();

        for (char letter : letters) {
            counts[letter-'a']++;
        }

        boolean[] usedLetters = new boolean[26];

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char letter : letters) {
            counts[letter-'a']--;

            if (!usedLetters[letter-'a']) {
                while (!stack.isEmpty() && letter < stack.peek() && counts[stack.peek()-'a'] != 0) {
                    usedLetters[stack.pop()-'a'] = false;
                }

                stack.push(letter);
                usedLetters[letter-'a'] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
