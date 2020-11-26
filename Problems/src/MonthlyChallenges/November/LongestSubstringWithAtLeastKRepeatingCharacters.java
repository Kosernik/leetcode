package MonthlyChallenges.November;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String test = "aaabb";
        LongestSubstringWithAtLeastKRepeatingCharacters solution = new LongestSubstringWithAtLeastKRepeatingCharacters();

        System.out.println("------------0");
        System.out.println(solution.longestSubstring(test, 3));
        System.out.println("------------1");
        System.out.println(solution.longestSubstring("bbaaacbd", 3));
    }

    /**
     * LeetCode #395.
     *
     * @param s - a string consisting of english lower characters.
     * @param k - minimum number of repeated characters in a substring
     * @return - the length of the longest valid substring.
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) return 0;
        else if (k <= 1) return s.length();

        Map<Character, List<Integer>> indexes = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!indexes.containsKey(s.charAt(i))) {
                indexes.put(s.charAt(i), new ArrayList<>());
            }
            indexes.get(s.charAt(i)).add(i);
        }

        List<Integer> splitIndexes = new ArrayList<>();

        boolean valid = true;
        for (Map.Entry<Character, List<Integer>> entry : indexes.entrySet()) {
            if (entry.getValue().size() < k) {
                valid = false;
                splitIndexes.addAll(entry.getValue());
            }
        }

        if (valid) return s.length();
        Collections.sort(splitIndexes);

        int startIdx = 0;
        List<String> subStrings = new ArrayList<>();

        for (Integer idx : splitIndexes) {
            subStrings.add(s.substring(startIdx, idx));
            startIdx = idx+1;
        }
        subStrings.add(s.substring(startIdx));

        int res = 0;
        for (String str : subStrings) {
            res = Math.max(res, longestSubstring(str, k));
        }

        return res;
    }
}
