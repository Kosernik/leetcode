package MonthlyChallenges.Year24.October;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();

        int[] test0 = {2736, 7236};
        System.out.println(solution.maximumSwap(test0[0]) == test0[1]);
        System.out.println("----");

        int[] test1 = {9973, 9973};
        System.out.println(solution.maximumSwap(test1[0]) == test1[1]);
        System.out.println("----");

        int[] test2 = {992736, 997236};
        System.out.println(solution.maximumSwap(test2[0]) == test2[1]);
        System.out.println("----");

        int[] test3 = {10010, 11000};
        System.out.println(solution.maximumSwap(test3[0]) == test3[1]);
        System.out.println("----");

        int[] test4 = {1993, 9913};
        System.out.println(solution.maximumSwap(test4[0]) == test4[1]);
        System.out.println("----");

        int[] test5 = {21121, 22111};
        System.out.println(solution.maximumSwap(test5[0]) == test5[1]);
        System.out.println("----");

        int[] test6 = {910010, 911000};
        System.out.println(solution.maximumSwap(test6[0]) == test6[1]);
        System.out.println("----");

        int[] test7 = {0, 0};
        System.out.println(solution.maximumSwap(test7[0]) == test7[1]);
        System.out.println("----");
    }

    /**
     * LeetCode №670. Maximum Swap
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param num - a non-negative integer. 0 <= num <= 10^8
     * @return - the maximum valued number you can get after at most 1 swap.
     */
    public int maximumSwap(int num) {
        if (num == 100_000_000) return num;

        int maxLength = 8;
        int[] digits = new int[maxLength];

        int idx = 0;

        while (num > 0) {
            int remainder = num % 10;

            digits[maxLength - idx - 1] = remainder;

            idx++;
            num /= 10;
        }

        idx = maxLength - idx;

        while (idx < maxLength) {
            int right = maxLength - 1;
            int digit = digits[idx];

            int maxDigit = digits[right];
            int maxIdx = right;

            while (right > idx) {
                if (digits[right] > maxDigit) {
                    maxDigit = digits[right];
                    maxIdx = right;
                }
                right--;
            }

            if (digit >= maxDigit) {
                idx++;
            } else {
                digits[idx] = maxDigit;
                digits[maxIdx] = digit;
                break;
            }
        }

        return convertToNumber(digits);
    }

    private int convertToNumber(int[] digits) {
        int converted = 0;

        for (int digit : digits) {
            converted = converted * 10 + digit;
        }

        return converted;
    }
}
