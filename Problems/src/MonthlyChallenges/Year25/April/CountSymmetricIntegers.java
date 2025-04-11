package MonthlyChallenges.Year25.April;

public class CountSymmetricIntegers {
    public static void main(String[] args) {
        CountSymmetricIntegers solution = new CountSymmetricIntegers();

        int low0 = 1, high0 = 100, result0 = 9;
        System.out.println(solution.countSymmetricIntegers(low0, high0) == result0);

        int low1 = 9, high1 = 100, result1 = 9;
        System.out.println(solution.countSymmetricIntegers(low1, high1) == result1);

        int low2 = 999, high2 = 10000, result2 = 615;
        System.out.println(solution.countSymmetricIntegers(low2, high2) == result2);
    }

    /**
     * LeetCode №2843. Count Symmetric Integers.
     * <p>
     * Complexity - O(N), N = high - low.
     * Memory - O(1)
     *
     * @param low  - the lower bound of an interval.
     * @param high - the higher bound of an interval, Inclusive.
     * @return - the number of symmetric integers in the range [low, high].
     */
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        int lowLength = computeLength(low);
        if (lowLength % 2 == 1) {  //  Odd length
            low = (int) Math.pow(10, lowLength);
        }

        for (int i = low; i <= high; i++) {
            int length = computeLength(i);

            if (length % 2 == 1) {  //  Odd length
                i *= 10;
                continue;
            }

            int rightHalf = 0;
            int leftHalf = 0;

            int half = length / 2;

            int curNumber = i;
            for (int j = 0; j < half; j++) {
                rightHalf += curNumber % 10;
                curNumber /= 10;
            }
            for (int j = 0; j < half; j++) {
                leftHalf += curNumber % 10;
                curNumber /= 10;
            }

            if (rightHalf == leftHalf) {
                count++;
            }
        }

        return count;
    }

    private int computeLength(int number) {
        int length = 0;
        while (number > 0) {
            length++;
            number /= 10;
        }
        return length;
    }
}
