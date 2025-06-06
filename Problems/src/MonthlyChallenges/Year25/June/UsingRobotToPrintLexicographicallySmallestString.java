package MonthlyChallenges.Year25.June;

import java.util.Stack;

public class UsingRobotToPrintLexicographicallySmallestString {
    public static void main(String[] args) {
        UsingRobotToPrintLexicographicallySmallestString solution = new UsingRobotToPrintLexicographicallySmallestString();

        String s0 = "zza";
        String result0 = "azz";
        System.out.println(solution.robotWithString(s0).equals(result0));

        String s1 = "zzb";
        String result1 = "bzz";
        System.out.println(solution.robotWithString(s1).equals(result1));

        String s2 = "bac";
        String result2 = "abc";
        System.out.println(solution.robotWithString(s2).equals(result2));

        String s3 = "baca";
        String result3 = "aacb";
        System.out.println(solution.robotWithString(s3).equals(result3));

        String s4 = "bgcrzgsdgrthbnghhghjvbhns";
        String result4 = "bbbhnsvjhghhgnhtrgdsgzrcg";
        System.out.println(solution.robotWithString(s4).equals(result4));
    }

    /**
     * LeetCode №2434. Using a Robot to Print the Lexicographically Smallest String.
     *
     * @param s - a string of lowercase english letters.
     * @return - the lexicographically smallest string that can be written on the paper after the robot will perform
     * all operations.
     */
    public String robotWithString(String s) {
        char[] letters = s.toCharArray();

        int[] countLetters = new int[26];
        for (char letter : letters) {
            countLetters[letter - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Stack<Character> unprinted = new Stack<>();

        int nextChar = 'a';

        for (char letter : letters) {
            unprinted.push(letter);
            countLetters[letter - 'a']--;

            while (nextChar != 'z' && countLetters[nextChar - 'a'] == 0) {
                nextChar++;
            }

            while (!unprinted.isEmpty() && unprinted.peek() <= nextChar) {
                result.append(unprinted.pop());
            }
        }

        return result.toString();
    }
}
