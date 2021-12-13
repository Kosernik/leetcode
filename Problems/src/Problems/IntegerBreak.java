package Problems;

public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();

        int[] tests = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20, 50, 58};
        int[] results = {1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 1458, 86093442, 1549681956};

        for (int i = 0; i < tests.length; i++) {
            int curRes = solution.integerBreak(tests[i]);
            if (curRes != results[i]) {
                System.out.println("Wrong result for number " + tests[i] + ", got " + curRes + ", instead of " + results[i]);
            }
        }
    }

    /**
     * LeetCode #343. Integer Break.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - an integer in a range 2 <= n <= 58.
     * @return - https://leetcode.com/problems/integer-break/
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        else if (n == 3) return 2;

        int numberOfThree;
        int numberOfTwo;
        if (n % 3 == 1) {
            numberOfThree = n / 3 - 1;
            numberOfTwo = 2;
        }
        else if (n % 3 == 0) {
            numberOfThree = n / 3;
            numberOfTwo = 0;
        }
        else {
            numberOfThree = n / 3;
            numberOfTwo = n % 3-1;
        }

        return (int) (Math.pow(3, numberOfThree) * Math.pow(2, numberOfTwo));
    }
}
