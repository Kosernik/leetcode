package MonthlyChallenges.Year26.May;

public class RotatedDigits {
    public static void main(String[] args) {
        RotatedDigits solution = new RotatedDigits();

        System.out.println(solution.rotatedDigits(10) == 4);
    }

    /**
     * LeetCode №788. Rotated Digits.
     * <p>
     * Complexity - O(N), N = n.
     * Memory - O(1)
     *
     * @param n - a positive integer.
     * @return - the number of good integers in the range [1, n].
     */
    public int rotatedDigits(int n) {
        int[] rotated = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (rotate(i, rotated)) count++;
        }

        return count;
    }

    private boolean rotate(int number, int[] rotated) {
        int original = number;
        int curRotated = 0;

        int multiply = 1;
        while (number > 0) {
            int digit = rotated[number % 10];

            if (digit == -1) return false;

            curRotated = digit * multiply + curRotated;
            multiply *= 10;
            number /= 10;
        }

        return original != curRotated;
    }
}
