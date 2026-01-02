package MonthlyChallenges.Year21.May21;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbers solution = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();

        String[] tests =
                {
                        "32",
                        "82734",
                        "27346209830709182346",
                        "8",
                        "1234567890"
                };
        int[] results =
                {
                        3,
                        8,
                        9,
                        8,
                        9
                };

        for (int i = 0; i < tests.length; i++) {
            System.out.println(solution.minPartitions(tests[i]) == results[i]);
        }


    }

    public int minPartitionsSlow(String n) {
        if (n == null || n.length() == 0) return 0;
        else if (n.length() == 1) return (n.charAt(0) - '0');

        int result = n.charAt(0) - '0';
        StringBuilder reducedN = new StringBuilder();
        int idx = 1;
        while (idx < n.length() && (n.charAt(idx) - '0') <= result) {
            idx++;
        }

        if (idx == n.length()) return result;

        while (idx < n.length()) {
            int currNum = Math.max(n.charAt(idx) - '0' - result, 0);
            reducedN.append(currNum);
            idx++;
        }

        int reducedResult = minPartitions(reducedN.toString());
        return result + reducedResult;
    }

    /**
     * LeetCode #1689.
     * <p>
     * Complexity - O(N), N - the length of a string.
     * Memory - O(1)
     *
     * @param n - a string of digits without leading zeroes.
     * @return - the minimum number of positive deci-binary numbers needed so that they sum up to "n".
     */
    public int minPartitions(String n) {
        int result = 0;
        for (char ch : n.toCharArray()) {
            result = Math.max(result, ch - '0');
        }
        return result;
    }
}
