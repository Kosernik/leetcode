package MonthlyChallenges.Year26.March;

public class MinimumNumberOfFlipsToMakeBinaryStringAlternating {
    public static void main(String[] args) {
        MinimumNumberOfFlipsToMakeBinaryStringAlternating solution = new MinimumNumberOfFlipsToMakeBinaryStringAlternating();

        String s0 = "01001001101";
        int result0 = 2;
        System.out.println(solution.minFlips(s0) + " = " + result0);
    }

    /**
     * LeetCode №1888. Minimum Number of Flips to Make the Binary String Alternating.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * Allowed operations:
     * * Type-1: Remove the character at the start of the string s and append it to the end of the string.
     * * Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
     *
     * @param s - a string of '0' and '1'
     * @return - the minimum number of type-2 operations you need to perform such that s becomes alternating.
     */
    public int minFlips(String s) {
        int[][] oddEven = new int[2][2];

        boolean even = true;
        for (int i = 0; i < s.length(); i++, even = !even) {
            if (s.charAt(i) == '0') {
                if (even) {
                    oddEven[0][0] += 1;
                } else {
                    oddEven[0][1] += 1;
                }
            } else {
                if (even) {
                    oddEven[1][0] += 1;
                } else {
                    oddEven[1][1] += 1;
                }
            }
        }

        int swaps = getMinSwaps(oddEven);
        if (s.length() % 2 == 0) return swaps;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                oddEven[0][0]--;
                oddEven[0][1]++;
            } else {
                oddEven[1][0]--;
                oddEven[1][1]++;
            }
            shift(oddEven);

            swaps = Math.min(swaps, getMinSwaps(oddEven));
        }

        return swaps;
    }

    private static int getMinSwaps(int[][] oddEven) {
        return Math.min(oddEven[0][1] + oddEven[1][0], oddEven[0][0] + oddEven[1][1]);
    }

    private void shift(int[][] oddEven) {
        int temp = oddEven[0][0];
        oddEven[0][0] = oddEven[0][1];
        oddEven[0][1] = temp;

        temp = oddEven[1][0];
        oddEven[1][0] = oddEven[1][1];
        oddEven[1][1] = temp;
    }
}
