package MonthlyChallenges.Year25.September;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ReplaceNonCoprimeNumbersInArray {

    public static void main(String[] args) {
        ReplaceNonCoprimeNumbersInArray solution = new ReplaceNonCoprimeNumbersInArray();

        int[] nums0 = {6, 4, 3, 2, 7, 6, 2};
        System.out.println(solution.replaceNonCoprimes(nums0).toString());
    }

    /**
     * LeetCode №2197. Replace Non-Coprime Numbers in Array.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the final modified array after replacing all adjacent non-coprime numbers in nums with their LCM.
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            while (!stack.isEmpty() && gcd(stack.peekLast(), current) > 1) {
                int top = stack.removeLast();

                current = lcm(top, current, gcd(top, current));
            }

            stack.addLast(current);
        }

        while (!stack.isEmpty()) {
            result.add(stack.removeFirst());
        }

        return result;
    }

    /**
     * Greatest Common Divider
     *
     * @param a - a positive integer.
     * @param b - a positive integer.
     * @return - the greatest common divider.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b, int gcd) {
        return (int) ((a * (long) b) / gcd);
    }
}
