package MonthlyChallenges.July21;

import java.util.Arrays;

public class CustomSortString {
    // LeetCode #791.
    public String customSortString(String order, String str) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 27);
        int count = 0;
        for (char ch : order.toCharArray()) {
            alphabet[ch - 'a'] = count;
            count++;
        }

        Character[] res = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(i);
        }

        Arrays.sort(res, (a, b) -> Integer.compare(alphabet[(char)a-'a'], alphabet[(char)b-'a']));
        StringBuilder sorted = new StringBuilder();
        for (Character ch : res) {
            sorted.append(ch);
        }

        return sorted.toString();
    }
}
