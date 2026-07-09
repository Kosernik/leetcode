package MonthlyChallenges.Year26.July;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ConcatenateNonZeroDigitsAndMultiplyBySumII {
    public static void main(String[] args) {
        ConcatenateNonZeroDigitsAndMultiplyBySumII solution = new ConcatenateNonZeroDigitsAndMultiplyBySumII();

        String s0 = "10203004";
        int[][] queries0 = {{0, 7}, {1, 3}, {4, 6}};
        int[] answer0 = {12340, 4, 9};
        int[] result0 = solution.sumAndMultiply(s0, queries0);

        for (int i = 0; i < answer0.length; i++) {
            System.out.println(answer0[i] + " " + result0[i]);
        }
        System.out.println("Done!");
    }


    private final int MODULO = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        NavigableMap<Integer, Integer> indices = new TreeMap<>();

        List<Long> noZeroes = new ArrayList<>();
        noZeroes.add(0L);
        List<Integer> sums = new ArrayList<>();
        sums.add(0);

        long prevNumber = 0L;
        int prevSum = 0;

        int idx = 1;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            if (digit == 0) continue;

            long number = prevNumber * 10 + digit;
            if (number >= MODULO) number %= MODULO;

            noZeroes.add(number);

            int sum = prevSum + digit;
            if (sum >= MODULO) sum %= MODULO;

            sums.add(sum);

            prevNumber = number;
            prevSum = sum;

            indices.put(i, idx);
            idx++;
        }

        int[] result = new int[queries.length];

        System.out.println(noZeroes.toString());
        System.out.println(sums.toString());

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int leftOriginal = query[0], rightOriginal = query[1];

            var left = indices.ceilingEntry(leftOriginal);
            if (left == null || left.getKey() > rightOriginal) {
                result[i] = 0;
                continue;
            }

            int leftIdx = left.getValue();
            var rightIdx = indices.floorEntry(rightOriginal).getValue();

            long startNum = noZeroes.get(leftIdx - 1);
            long endNum = noZeroes.get(rightIdx);

            int numberLength = rightIdx - leftIdx + 1;

            long startSum = sums.get(leftIdx - 1);
            long endSum = sums.get(rightIdx);

            long x = endNum - startNum * getPowerTen(numberLength);
            long sum = endSum - startSum;
            System.out.println(x + " " + sum + ", number length " + numberLength + ", tens " + getPowerTen(numberLength));

            int res = (int) ((x * sum) % MODULO);
            result[i] = res;
        }

        return result;
    }

    private int getPowerTen(int power) {
        return (int) (Math.pow(10, power) % MODULO);
    }


    /**
     * LeetCode №3756. Concatenate Non-Zero Digits and Multiply by Sum II.
     *
     * @param s       - a string of digits.
     * @param queries - an array of queries. query[0] - left index, query[1] - right index.
     * @return - an array of results for each query.
     */
    public int[] sumAndMultiplyTLE(String s, int[][] queries) {
        NavigableMap<Integer, Integer> indices = new TreeMap<>();
        List<Short> noZeroes = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            short digit = (short) (s.charAt(i) - '0');
            if (digit == 0) continue;

            noZeroes.add(digit);

            indices.put(i, idx);
            idx++;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int leftOriginal = query[0], rightOriginal = query[1];

            var left = indices.ceilingEntry(leftOriginal);
            if (left == null || left.getKey() > rightOriginal) {
                result[i] = 0;
                continue;
            }

            var right = indices.floorEntry(rightOriginal);

            result[i] = getAnswer(left.getValue(), right.getValue(), noZeroes);
        }

        return result;
    }

    private int getAnswer(int left, int right, List<Short> noZeroes) {
        long number = 0;
        int sum = 0;

        for (int i = left; i <= right; i++) {
            number = number * 10 + noZeroes.get(i);
            if (number >= MODULO) number %= MODULO;

            sum += noZeroes.get(i);
        }

        return (int) ((number * sum) % MODULO);
    }
}
