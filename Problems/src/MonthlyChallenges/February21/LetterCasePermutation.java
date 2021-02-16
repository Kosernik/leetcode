package MonthlyChallenges.February21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**
     * LeetCode #784.
     *
     * Returns a list of all permutations of a given string.
     * Every letter in a string can be  changed to lower case or upper case, digits stays unchanged.
     *
     * @param S - a string of english letters and digits.
     * @return - a list of permutations of a string 'S'.
     */
    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<>();
        permutations.add(S);
        permute(S, permutations, 0);

        return permutations;
    }

    private void permute(String s, List<String> permutations, int idx) {
        if (idx >= s.length()) return;

        if (!Character.isDigit(s.charAt(idx))) {
            char ch;
            if (Character.isUpperCase(s.charAt(idx))) {
                ch =  Character.toLowerCase(s.charAt(idx));
            } else {
                ch = Character.toUpperCase(s.charAt(idx));
            }
            String curr = s.substring(0, idx) + ch + s.substring(idx+1);
            permutations.add(curr);
            permute(curr, permutations, idx+1);
        }
        permute(s, permutations, idx+1);
    }
}
