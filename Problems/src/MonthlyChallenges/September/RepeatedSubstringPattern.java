package MonthlyChallenges.September;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
//        String test0 = "abcabc";
//        String test0 = "aaaaaaaaaaaaaaaaaaaaaaaa";
//        String test0 = "aaaaaaaaaaaaaaaaaaaaaaaaa";
//        String test0 = "aaaaaaaaaaaaaaaabaaaaaaa";
//        System.out.println(test0.length());
//        System.out.println(solution.repeatedSubstringPattern(test0));
        solution.testRepeatedSubstringPattern();
    }

    /**
     * Method checks if a non-empty string can be constructed by taking a substring of it and appending multiple copies
     * of the substring together.
     *
     * @param s - non-empty string of english lowercase characters
     * @return True - if a string can be constructed by copying and appending substring of s, otherwise - False.
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) return false;

        int length = s.length();
        for (int i = 2; i <= length; i++) {

            if (length % i != 0) continue;
            int shift = length / i;
            int start = shift;
            int end = shift + shift;
            String currStart = s.substring(0, shift);
            boolean allEquals = true;
            for (int j = 1; j < i; j++) {
                if (!currStart.equals(s.substring(start, end))) {
                    allEquals = false;
                    break;
                }
                start += shift;
                end += shift;
            }
            if (allEquals) return true;
        }

        return false;
    }

    private void testRepeatedSubstringPattern() {
        String[] tests = {"abab",
                "aba",
                "abcabcabcabc",
                "abcabc",
                "aaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaabaaaaaaa",
                "abcabcdabcabc",
                "abcabcabcabcd",
                "dabcabcabcabc",
                "abcabcabcabca"};
        boolean[] results = {true,
                false,
                true,
                true,
                true,
                true,
                false,
                false,
                false,
                false,
                false};

        int failed = 0;
        for (int i = 0; i < tests.length; i++) {
            if (results[i] != repeatedSubstringPattern(tests[i])) {
                failed++;
                System.out.println("Wrong answer for test # " + i + ", got: " + !results[i] + ", instead of " + results[i]);
            }
        }
        System.out.println("Success rate: " + (tests.length-failed)*100.0/tests.length);
    }
}
