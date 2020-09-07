package MonthlyChallenges.September;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern solution = new WordPattern();
//        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        solution.testWordPattern();
    }

    /**
     * Verifies if a string "str" follows the "pattern". Follows means pattern[letter] == str[word] and
     * str[word] == pattern[letter].
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param pattern - a string containing only english lowercase letters.
     * @param str - a string of words, contains only english lowercase letters.
     * @return - True - if str follows the pattern, False - otherwise.
     */
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        else if (pattern == null || str == null) return false;
        else if (pattern.length() == 0 && str.length() == 0) return true;

        Map<String, Character> patterns = new HashMap<>();
        String[] charToStr = new String[26];

        String[] splitted = str.split(" ");
        char[] letters = pattern.toCharArray();

        if (splitted.length != letters.length) return false;


        for (int i = 0; i < letters.length; i++) {
            char currPattern = letters[i];
            String currStr = splitted[i];

            if (charToStr[currPattern - 'a'] != null) {
                if (!currStr.equals(charToStr[currPattern - 'a'])) return false;

                if (!patterns.containsKey(currStr)) return false;

                if (currPattern != patterns.get(currStr)) return false;
            } else {
                if (patterns.containsKey(currStr)) return false;
                else patterns.put(currStr, currPattern);

                charToStr[currPattern - 'a'] = currStr;
            }
        }

        return true;
    }

    private void testWordPattern() {
        String[][] tests = {
                {"abba", "dog cat cat dog"},
                {"abba", "dog cat cat fish"},
                {"aaaa", "dog cat cat dog"},
                {"abba", "dog dog dog dog"},
                {"aaaa", "dog dog dog dog"},
                {"", ""},
                {"a", "adbsd"},
                {null, null},
                {null, "assd"},
                {"b", null},
                {"a", "ad sf"},
                {"ab", "afsd"},
                {"aa", "abdff"}
        };
        boolean[] results = {true, false, false, false, true, true, true, true, false, false, false, false, false};

        if (tests.length != results.length) {
            System.out.println("Need tests for tests!!!");
            return;
        }
        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            if (wordPattern(tests[i][0], tests[i][1]) != results[i]) {
                failed++;
                System.out.println("Wrong result for test # " + i);
                System.out.println("Got: " + !results[i] + ", instead of " + results[i]);
            }
        }

        System.out.println("Success rate: " + (tests.length - failed) * 100.0 / tests.length);
    }
}
