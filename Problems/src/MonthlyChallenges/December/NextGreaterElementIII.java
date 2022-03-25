package MonthlyChallenges.December;

import java.util.*;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII solution = new NextGreaterElementIII();

        int[] tests = {12, 21, 123, 2, 9, 2147483647, 43210, 2147483646, 2122222222, 230241};
        int[] results = {21, -1, 132, -1, -1, -1, -1, -1, -1, 230412};

        for (int i = 0; i < tests.length; i++) {
            int res = solution.nextGreaterElement(tests[i]);
            if (res != results[i]) {
                System.out.println("Got " + res + ", instead of " + results[i] + " for number " + tests[i]);
            }
        }

        Random random = new Random();
        System.out.println("Randoms:");

        for (int i = 0; i < 123; i++) {
            int n = random.nextInt(Integer.MAX_VALUE);
            int res = solution.nextGreaterElement(n);
            int resB = solution.nextGreaterElementBrute(n);
            if (res != resB) {
                System.out.println("Got " + res + ", instead of " + resB + " for number " + n);
            }
        }

        System.out.println("Done!");
    }

    /**
     * LeetCode #556.
     *
     *
     * Generates the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     *
     * @param n - positive integer.
     * @return - the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     */
    public int nextGreaterElement(int n) {
        if (n <= 9) return -1;

        char[] number = String.valueOf(n).toCharArray();

        for (int i = number.length - 2; i >= 0; i--) {
            if (number[i] < number[i+1]) {
                int idx = i+1;
                int candidate = number[i+1];
                int candidateIdx = i+1;
                while (idx < number.length) {
                    if (number[idx] > number[i] && number[idx] < candidate) {
                        candidate = number[idx];
                        candidateIdx = idx;
                    }
                    idx++;
                }
                swap(number, i, candidateIdx);

                char[] rightPart = Arrays.copyOfRange(number, i+1, number.length);
                Arrays.sort(rightPart);
                for (int j = 0; j < rightPart.length; j++) {
                    number[i+j+1] = rightPart[j];
                }

                break;
            }
        }

        long result = Long.parseLong(new String(number));

        if (result == n || result > Integer.MAX_VALUE) return -1;
        else return (int) result;
    }

    private void swap(char[] number, int a, int b) {
        char temp = number[a];
        number[a] = number[b];
        number[b] = temp;
    }


    /**
     * LeetCode #556.
     * (BruteForce solution)
     * <p>
     * Generates the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     *
     * @param n - positive integer.
     * @return - the smallest integer which has exactly the same digits existing in the integer "n" and is greater in
     * value than "n".
     */
    public int nextGreaterElementBrute(int n) {
        List<Integer> digits = new ArrayList<>();

        int num = n;
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }

        Set<Long> numbers = new HashSet<>();
        int res = Integer.MAX_VALUE;
        generate(digits, numbers, n, 0);

        if (numbers.size() == 0) return -1;
        else {
            for (long number : numbers) {
                res = Math.min(res, (int) number);
            }
            return res;
        }
    }

    private void generate(List<Integer> digits, Set<Long> numbers, int n, long number) {
        if (digits.size() == 0) {
            if (number > n && number <= Integer.MAX_VALUE) numbers.add(number);
        } else {
            number *= 10;
            for (int i = 0; i < digits.size(); i++) {
                int digit = digits.get(i);
                digits.remove(i);
                number += digit;

                generate(digits, numbers, n, number);

                number -= digit;
                digits.add(i, digit);
            }
        }
    }
}
