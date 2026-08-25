package MonthlyChallenges.Year26.August;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingMultipleOfK {
    public static void main(String[] args) {
        SmallestMissingMultipleOfK solution = new SmallestMissingMultipleOfK();

        int[] nums0 = {8, 2, 3, 4, 6};
        int k0 = 2;
        int result0 = 10;
        System.out.println(solution.missingMultiple(nums0, k0) == result0);
    }

    /**
     * LeetCode №3718. Smallest Missing Multiple of K.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of positive integers.
     * @param k    - a positive integer.
     * @return - the smallest positive multiple of k that is missing from nums. A multiple of k is any positive integer
     * divisible by k.
     */
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> multiples = new HashSet<>();

        for (int number : nums) {
            int multiplier = number / k;

            if (number == (multiplier * k)) {
                multiples.add(multiplier);
            }
        }

        int result = 1;
        while (true) {
            if (!multiples.contains(result)) {
                return result * k;
            }

            result++;
        }
    }
}
