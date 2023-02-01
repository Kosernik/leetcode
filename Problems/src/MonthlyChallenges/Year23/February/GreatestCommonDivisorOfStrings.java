package MonthlyChallenges.Year23.February;

import java.util.Arrays;

public class GreatestCommonDivisorOfStrings {

    /**
     * LeetCode #1071. Greatest Common Divisor of Strings.
     *
     * @param str1 - a string.
     * @param str2 - a string.
     * @return - the largest string x such that x divides both str1 and str2.
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() == str2.length()) {
            if (str1.equals(str2)) {
                return str1;
            } else {
                return "";
            }
        } else if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        int first = str1.length();
        int second = str2.length();
        char[] firstLetters = str1.toCharArray();
        char[] secondLetters = str2.toCharArray();

        for (int length = str2.length(); length > 0; length--) {
            if (second % length != 0 || first % length != 0) {
                continue;
            }
            char[] candidate = Arrays.copyOfRange(secondLetters, 0, length);
            if (concatenated(secondLetters, candidate) && concatenated(firstLetters, candidate)) {
                return new String(candidate);
            }
        }
        return "";
    }

    private boolean concatenated(char[] word, char[] candidate) {
        int idx = 0;
        for (char c : word) {
            if (c != candidate[idx]) return false;
            idx = (idx + 1) % candidate.length;
        }
        return true;
    }
}
