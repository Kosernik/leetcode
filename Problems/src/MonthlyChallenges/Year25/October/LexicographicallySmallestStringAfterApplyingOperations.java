package MonthlyChallenges.Year25.October;

public class LexicographicallySmallestStringAfterApplyingOperations {
    public static void main(String[] args) {
        LexicographicallySmallestStringAfterApplyingOperations solution = new LexicographicallySmallestStringAfterApplyingOperations();

        String s1 = "74";
        int a1 = 5, b1 = 1;
        System.out.println(solution.findLexSmallestString(s1, a1, b1));
    }

    /**
     * LeetCode №1625. Lexicographically Smallest String After Applying Operations.
     * <p>
     * Operations:
     * *   Add a to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456"
     * and a = 5, s becomes "3951".
     * *   Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".
     *
     * @param s - a string of digits. s.length is even.
     * @param a - a digit. 1 <= a <= 9.
     * @param b - a positive integer. 1 <= b <= s.length - 1.
     * @return - the lexicographically smallest string you can obtain by applying the above operations any number of
     * times on s.
     */
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;

        int length = s.length();
        boolean[] visited = new boolean[length];
        int shifts = (b % 2) == 0 ? 0 : 9;

        s = s.concat(s);

        for (int i = 0; !visited[i]; i = (i + b) % length) {
            visited[i] = true;

            for (int j = 0; j < 10; j++) {
                for (int shift = 0; shift <= shifts; shift++) {
                    char[] letters = s.substring(i, i + length).toCharArray();

                    for (int k = 1; k < length; k += 2) {
                        letters[k] = (char) ((letters[k] - '0' + j * a) % 10 + '0');
                    }
                    for (int k = 0; k < length; k += 2) {
                        letters[k] = (char) ((letters[k] - '0' + shift * a) % 10 + '0');
                    }

                    String candidate = new String(letters);
                    if (candidate.compareTo(smallest) < 0) smallest = candidate;
                }
            }
        }

        return smallest;
    }
}
