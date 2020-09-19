package MonthlyChallenges.September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        SequentialDigits solution = new SequentialDigits();
//        List<Integer> res = solution.sequentialDigits(100, 13000);
        List<Integer> res = solution.sequentialDigits(58, 155);
        System.out.println(res);
    }

    /**
     * Returns a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
     * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
     *
     * @param low - start number of a range, inclusive.
     * @param high - finish number of a range, inclusive.
     * @return - a list of all numbers with sequential digits within a range.
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        if (high < 12) return res;

        int lenLow = (int) Math.log10(low) + 1;

        int num = 0;
        int add = 0;
        int lastDigit = 0;
        for (int i = 1; i <= lenLow; i++) {
            num *= 10;
            num += i;
            add *= 10;
            add += 1;
            lastDigit++;
        }

        int currNum = num;
        int level = (int) Math.pow(10, lenLow-1) * (11 - lenLow++);

        lastDigit++;
        while (currNum <= high) {
            if (currNum < low) {
                currNum += add;
            }
            else if (currNum > level) {
                num *= 10;
                num += lastDigit++;
                currNum = num;
                add *= 10;
                add += 1;
                level = (int) Math.pow(10, lenLow-1) * (11 - lenLow++);
            } else {
                res.add(currNum);
                currNum += add;
            }
        }

        return res;
    }
}
