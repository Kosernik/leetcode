package MonthlyChallenges.February21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting solution = new LongestWordInDictionaryThroughDeleting();

        List<String> test0 = new ArrayList<>();
        test0.add("aaa");test0.add("bbb");test0.add("zzz");test0.add("aaaa");test0.add("bbbb");test0.add("zzzzz");
        System.out.println(solution.findLongestWord("aa", test0).equals(""));


        List<String> test1list = new ArrayList<>();
        test1list.add("apple");test1list.add("ewaf");test1list.add("awefawfwaf");
        test1list.add("awef");test1list.add("awefe");test1list.add("ewafeffewafewf");
        String test1String = "aewfafwafjlwajflwajflwafj";
        System.out.println(solution.findLongestWord(test1String, test1list).equals("ewaf"));
    }

    /**
     * LeetCode #524.
     *
     * Returns the longest string from a list "d" that can be formed by deleting some characters of the given string "s".
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of english lower-case letters.
     * @param d - list of strings of english lower-case letters.
     * @return - the longest string from a list "d" formed by deleting some characters from string "s"
     */
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d.isEmpty()) return "";

        int[] original = new int[26];
        for (char c : s.toCharArray()) original[c - 'a']++;

        String result = "";

        for (String word : d) {
            if (word.length() < result.length()) continue;

            int currNumber = getNumberOfLetters(original, word);
            if (currNumber != 0 && canBuild(s, word)) {
                if (word.length() > result.length() || word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }

        return result;
    }

    private int getNumberOfLetters(int[] original, String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c-'a']++;

        int numOfLetters = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] <= original[i]) {
                numOfLetters += count[i];
            }
        }

        return numOfLetters;
    }

    private boolean canBuild(String original, String candidate) {
        int idxOrig = 0;
        int idxCand = 0;

        while (idxCand < candidate.length() && idxOrig < original.length()) {
            while (idxOrig < original.length() && original.charAt(idxOrig) != candidate.charAt(idxCand)) {
                idxOrig++;
            }
            if (idxOrig >= original.length()) return false;

            idxCand++;
            idxOrig++;
        }

        return idxCand == candidate.length();
    }
}
