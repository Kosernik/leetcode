package Problems;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

    /**
     * LeetCode #500. Keyboard Row.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param words - an array of words. Each word consists of English letters (both lowercase and uppercase).
     * @return - the words that can be typed using letters of the alphabet on only one row of American keyboard.
     */
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        byte[] letters = new byte[26];

        letters['a'-'a'] = 2; letters['b'-'a'] = 3; letters['c'-'a'] = 3; letters['d'-'a'] = 2; letters['e'-'a'] = 1;
        letters['f'-'a'] = 2; letters['g'-'a'] = 2; letters['h'-'a'] = 2; letters['i'-'a'] = 1; letters['j'-'a'] = 2;
        letters['k'-'a'] = 2; letters['l'-'a'] = 2; letters['m'-'a'] = 3; letters['n'-'a'] = 3; letters['o'-'a'] = 1;
        letters['p'-'a'] = 1; letters['q'-'a'] = 1; letters['r'-'a'] = 1; letters['s'-'a'] = 2; letters['t'-'a'] = 1;
        letters['u'-'a'] = 1; letters['v'-'a'] = 3; letters['w'-'a'] = 1; letters['x'-'a'] = 3; letters['y'-'a'] = 1;
        letters['z'-'a'] = 3;

        for (String word : words) {
            char[] chs = word.toCharArray();
            boolean valid = true;
            for (int i = 1; i < chs.length; i++) {
                if (letters[getIdx(chs[i-1])] != letters[getIdx(chs[i])]) {
                    valid = false;
                    break;
                }
            }
            if (valid) result.add(word);
        }

        String[] validWords = new String[result.size()];
        return result.toArray(validWords);
    }

    private static int getIdx(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return ch-'a';
        } else {
            return ch-'A';
        }
    }
}
