package MonthlyChallenges.May21;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        MaximumProductOfWordLengths solution = new MaximumProductOfWordLengths();
        System.out.println(solution.notSharingSameLetters("++++", "+**+") == false);
        System.out.println(solution.notSharingSameLetters("++++", "***+") == false);
        System.out.println(solution.notSharingSameLetters("+**+", "***+") == false);
        System.out.println(solution.notSharingSameLetters("++++", "***+") == false);
        System.out.println(solution.notSharingSameLetters("++++", "++++") == false);
        System.out.println(solution.notSharingSameLetters("+*+*", "+*+*") == false);
        System.out.println(solution.notSharingSameLetters("****", "****") == true);
        System.out.println(solution.notSharingSameLetters("*++*", "+**+") == true);
    }

    /**
     * LeetCode #318.
     *
     * @param words - array of strings.
     * @return - the maximum value of length(word[i]) * length(word[j])
     */
    public int maxProduct(String[] words) {
        Map<String, Integer> uniques = new HashMap<>();

        for (String word : words) {
            String letters = getLetters(word);
            if (!uniques.containsKey(letters)) {
                uniques.put(letters, word.length());
            } else {
                uniques.put(letters, Math.max(word.length(), uniques.get(letters)));
            }
        }

        if (uniques.size() <= 1) return 0;
        int result = 0;

        for (Map.Entry<String, Integer> entry : uniques.entrySet()) {
            for (Map.Entry<String, Integer> entryTwo : uniques.entrySet()) {
                if (notSharingSameLetters(entry.getKey(), entryTwo.getKey())) {
                    result = Math.max(result, entry.getValue() * entryTwo.getValue());
                }
            }
        }

        return result;
    }

    private String getLetters(String word) {
        boolean[] letters = new boolean[26];

        for (char ch : word.toCharArray()) {
            letters[ch-'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letters[i]) {
                result.append('+');
            } else {
                result.append('*');
            }
        }

        return result.toString();
    }

    private boolean notSharingSameLetters(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == '+' && word2.charAt(i) == '+') {
                return false;
            }
        }
        return true;
    }
}
