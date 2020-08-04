package ExploreCards.HashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        String[][] tests = {{"egg", "add"}, {"foo", "bar"}, {"paper", "title"}, {"bar", "foo"}, {"title", "paper"}};
        boolean[] results = {true, false, true, false, true};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(solution.isIsomorphic(tests[i][0], tests[i][1]) == results[i]);
        }
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> pairStoT = new HashMap<>();
        Map<Character, Character> pairTtoS = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char sCh = sArray[i];
            char tCh = tArray[i];
            if (!pairStoT.containsKey(sCh)) {
                if (pairTtoS.containsKey(tCh)) return false;
                pairStoT.put(sCh, tCh);
                pairTtoS.put(tCh, sCh);
            }

            if (pairStoT.get(sCh) != tCh) return false;
        }
        return true;
    }
}
