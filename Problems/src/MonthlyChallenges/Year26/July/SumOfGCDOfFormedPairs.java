package MonthlyChallenges.Year26.July;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {

    /**
     * LeetCode №3867. Sum of GCD of Formed Pairs.
     * <p>
     * Complexity - O(N + NlogN)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @return - the total sum of gcd of pairs of gcd.
     */
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int prevMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            prevMax = Math.max(prevMax, number);
            prefixGcd[i] = gcd(number, prevMax);
        }

        Arrays.sort(prefixGcd);

        long sum = 0L;

        int left = 0, right = prefixGcd.length - 1;

        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);

            left++;
            right--;
        }

        return sum;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}
