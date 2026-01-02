package MonthlyChallenges.Year21.February21;

public class ShortestDistanceToACharacter {
    // LeetCode #821.
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];

        int prev = -10_001;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        prev = 10_001;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }
}
