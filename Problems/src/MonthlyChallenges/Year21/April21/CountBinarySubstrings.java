package MonthlyChallenges.Year21.April21;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        CountBinarySubstrings solution = new CountBinarySubstrings();

        System.out.println(solution.countBinarySubstrings("00110"));
    }

    /**
     * LeetCode #696.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string of '0' and '1'.
     * @return - the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the
     * 0's and all the 1's in these substrings are grouped consecutively.
     */
    public int countBinarySubstrings(String s) {
        int length = s.length();
        int index = 0;
        int result = 0;
        int zeroes = 0;
        int ones = 0;

        while (index < length) {
            if (s.charAt(index) == '0') {
                while (index < length && s.charAt(index) == '0') {
                    index++;
                    zeroes++;
                }
                result += Math.min(zeroes, ones);

                ones = 0;
                while (index < length && s.charAt(index) == '1') {
                    index++;
                    ones++;
                }

                result += Math.min(zeroes, ones);
                zeroes = 0;
            } else {
                while (index < length && s.charAt(index) == '1') {
                    index++;
                    ones++;
                }
                result += Math.min(zeroes, ones);

                zeroes = 0;
                while (index < length && s.charAt(index) == '0') {
                    index++;
                    zeroes++;
                }
                result += Math.min(zeroes, ones);
                ones = 0;
            }
        }

        return result;
    }
}
