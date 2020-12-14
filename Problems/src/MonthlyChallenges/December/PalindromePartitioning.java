package MonthlyChallenges.December;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    public static void main(String[] args) {
//        System.out.println("ab".substring(1,2));
//        System.out.println("ab".substring(2));

        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> tst0 = solution.partition("aab");
        for (List<String> lst : tst0) {
            System.out.println(lst.toString());
        }
    }

    /**
     * LeetCode #131.
     *
     * @param s - a string of english lowercase characters.
     * @return - all possible combinations of palindromes.
     */
    public List<List<String>> partition(String s) {
        Map<String, List<List<String>>> computed = new HashMap<>();

        List<List<String>> part = getPalindromes(s, computed);

        return part;
    }

    private List<List<String>> getPalindromes(String s, Map<String, List<List<String>>> computed) {
        if (computed.containsKey(s)) return computed.get(s);
        else if (s.length() == 0) return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        if (isPalindrome(s)) {
            List<String> lst = new ArrayList<>();
            lst.add(s);
            result.add(lst);
        }

        for (int len = 1; len < s.length(); len++) {
            String subS = s.substring(0, len);
            if (!isPalindrome(subS)) continue;

            String substring = s.substring(len, s.length());
            List<List<String>> combinations = getPalindromes(substring, computed);
            for (List<String> list : combinations) {
                List<String> curr = new ArrayList<>();
                curr.add(subS);
                curr.addAll(list);
                result.add(curr);
            }
            computed.put(substring, combinations);
        }

        return result;
    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length()-1;

        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) return false;
        }

        return true;
    }
}
