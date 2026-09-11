package MonthlyChallenges.Year26.September;

import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumbers {
    public static void main(String[] args) {
        Unique3DigitEvenNumbers solution = new Unique3DigitEvenNumbers();

        int[] digits = {0, 2, 2};
        System.out.println(solution.totalNumbers(digits));
    }

    /**
     * LeetCode №3483. Unique 3-Digit Even Numbers.
     * <p>
     * Complexity - O(N^3)
     * Memory - O(N^3)
     *
     * @param digits - an array of digits. 0 <= digits[i] <= 9. 3 <= digits.length <= 10
     * @return - the number of distinct three-digit even numbers that can be formed using digits. Each copy of a digit
     * can only be used once per number, and there may not be leading zeros.
     */
    public int totalNumbers(int[] digits) {
        int length = digits.length;

        Set<Integer> uniques = new HashSet<>();

        for (int i = 0; i < length; i++) {
            int digit = digits[i];
            if ((digit & 1) == 1) continue;

            for (int first = 0; first < length; first++) {
                int firstNumber = digits[first];
                if (firstNumber == 0 || first == i) continue;
                firstNumber *= 100;

                for (int middle = 0; middle < length; middle++) {
                    if (middle == i || middle == first) continue;

                    uniques.add(firstNumber + digits[middle] * 10 + digit);
                }
            }
        }

        return uniques.size();
    }
}
