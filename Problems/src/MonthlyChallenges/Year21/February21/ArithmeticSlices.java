package MonthlyChallenges.Year21.February21;

public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices solution = new ArithmeticSlices();

        System.out.println("Test 0");
        int[] test0 = {1, 3, 4, 5, 8};
        System.out.println(solution.numberOfArithmeticSlices(test0));

        System.out.println("\nTest 1");
        int[] test1 = {1, 3, 4, 5};
        System.out.println(solution.numberOfArithmeticSlices(test1));
    }

    /**
     * LeetCode #413.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param A - array of integers.
     * @return - number of arithmetic slices in a given array.
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;

        int res = 0;

        int diff;
        int prev = 0;


        while (true) {
            if (prev + 1 >= A.length) break;

            int idx = prev + 1;
            diff = A[idx] - A[prev];

            while ((idx + 1) < A.length && (A[idx + 1] - A[idx]) == diff) {
                idx++;
            }

            int length = idx - prev + 1;

            if (length >= 3) {
                res += (length - 2) * (length - 1) / 2;
            }

            prev = idx;
        }

        return res;
    }
}
