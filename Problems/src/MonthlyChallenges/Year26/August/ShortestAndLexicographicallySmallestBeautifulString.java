package MonthlyChallenges.Year26.August;

public class ShortestAndLexicographicallySmallestBeautifulString {
    public static void main(String[] args) {
        ShortestAndLexicographicallySmallestBeautifulString solution = new ShortestAndLexicographicallySmallestBeautifulString();

        String s0 = "100011001";
        int k0 = 3;
        String result0 = "11001";
        System.out.println(solution.shortestBeautifulSubstring(s0, k0).equals(result0));

        String s1 = "1011";
        int k1 = 2;
        String result1 = "11";
        System.out.println(solution.shortestBeautifulSubstring(s1, k1).equals(result1));

        String s2 = "000";
        int k2 = 1;
        String result2 = "";
        System.out.println(solution.shortestBeautifulSubstring(s2, k2).equals(result2));

        String s3 = "00100011001";
        int k3 = 3;
        String result3 = "11001";
        System.out.println(solution.shortestBeautifulSubstring(s3, k3).equals(result3));
    }

    /**
     * LeetCode №2904. Shortest and Lexicographically Smallest Beautiful String.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * A substring of s is beautiful if the number of 1's in it is exactly k.
     * Let len be the length of the shortest beautiful substring.
     *
     * @param s - a string of '0' and '1'.
     * @param k - a positive integer. k <= s.length()
     * @return - the lexicographically smallest beautiful substring of string s with length equal to len.
     */
    public String shortestBeautifulSubstring(String s, int k) {
        char[] letters = s.toCharArray();

        int left = 0;
        while (left < letters.length && letters[left] == '0') left++;

        int right = left;
        int count = 0;
        while (right < letters.length && count < k) {
            if (letters[right] == '1') count++;
            right++;
        }

        if (count < k) return "";

        int startIdx = left;
        int minLength = right - left;

        while (right < letters.length) {
            if (letters[right] == '1') {
                do left++;
                while (letters[left] == '0');

                int curLength = right - left + 1;

                if (curLength < minLength) {
                    startIdx = left;
                    minLength = curLength;
                } else if (curLength == minLength) {
                    startIdx = returnBestIdx(startIdx, left, minLength, letters);
                }
            }

            right++;
        }

        return s.substring(startIdx, startIdx + minLength);
    }

    private int returnBestIdx(int startIdx, int candidateIdx, int length, char[] letters) {
        for (int i = 0; i < length; i++) {
            if (letters[startIdx + i] == letters[candidateIdx + i]) continue;

            if (letters[startIdx + i] == '0') return startIdx;
            return candidateIdx;
        }
        return startIdx;
    }
}
