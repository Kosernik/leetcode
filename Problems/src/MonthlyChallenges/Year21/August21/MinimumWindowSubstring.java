package MonthlyChallenges.Year21.August21;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String[][] tests = {
                {"ADOBECODEBANC", "ABC"},
                {"baaaaabb", "abb"},
                {"baabbaaabb", "abb"},
                {"abbbbbc", "c"},
                {"babb", "baba"}
        };


        //        System.out.println(solution.minWindow(tests[0][0], tests[0][1]));
//                System.out.println(solution.minWindow(tests[1][0], tests[1][1]));

        for (String[] test : tests) {
            System.out.println(solution.minWindow(test[0], test[1]));
        }
    }

    /**
     * 76. Minimum Window Substring.
     * <p>
     * Complexity - O(N+M), N = s.length, M = t.length
     * Memory - O(N+M)
     *
     * @param s - a string of english letters.
     * @param t - a string of english letters.
     * @return - the minimum window substring of "s" such that every character in "t" (including duplicates) is included
     * in the window. If there is no such substring, returns the empty string "".
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        else if (s.equals(t)) return s;
        else if (t.length() == 1) {
            if (s.contains(t)) return t;
            else return "";
        }

        Map<Character, Integer> count = new HashMap<>();
        for (char ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int resultStartIdx = 0;
        int resultEndIdx = 0;
        int bestLength = Integer.MAX_VALUE;

        int requiredLength = count.size();

        int leftIdx = 0;
        int rightIdx = 0;
        int currentLength = 0;

        Map<Character, Integer> currentWindow = new HashMap<>();

        while (rightIdx < s.length()) {
            char ch = s.charAt(rightIdx);
            int curCount = currentWindow.getOrDefault(ch, 0);
            currentWindow.put(ch, curCount + 1);

            if (count.containsKey(ch) && count.get(ch).intValue() == currentWindow.get(ch).intValue()) {
                currentLength++;
            }

            while (leftIdx <= rightIdx && requiredLength == currentLength) {
                char curChar = s.charAt(leftIdx);

                if ((rightIdx - leftIdx + 1) < bestLength) {
                    bestLength = rightIdx - leftIdx + 1;
                    resultStartIdx = leftIdx;
                    resultEndIdx = rightIdx;
                }

                currentWindow.put(curChar, currentWindow.get(curChar) - 1);
                if (count.containsKey(curChar) && count.get(curChar) > currentWindow.get(curChar)) {
                    currentLength--;
                }

                leftIdx++;
            }

            rightIdx++;
        }

        if (bestLength == Integer.MAX_VALUE) return "";
        return s.substring(resultStartIdx, resultEndIdx + 1);
    }
}
