package MonthlyChallenges.Year26.November;

public class MaximumSubarrayWithEqualProducts {
    public static void main(String[] args) {
        MaximumSubarrayWithEqualProducts solution = new MaximumSubarrayWithEqualProducts();

        int[] nums0 = {1, 2, 1, 2, 1, 1, 1};
        int answer0 = 5;
        int result0 = solution.maxLength(nums0);
        System.out.println(answer0 == result0);

        int[] nums1 = {2, 3, 4, 5, 6};
        int answer1 = 3;
        int result1 = solution.maxLength(nums1);
        System.out.println(answer1 == result1);

        int[] nums2 = {1, 2, 3, 1, 4, 5, 1};
        int answer2 = 5;
        int result2 = solution.maxLength(nums2);
        System.out.println(answer2 == result2);

        int[] nums796 = {9, 2, 7, 9, 2, 10, 6, 8, 6, 9, 6, 10, 3, 5, 4};
        int answer796 = 3;
        int result796 = solution.maxLength(nums796);
        System.out.println(answer796 == result796);

        int[] nums822 = {2, 6, 1, 3, 10, 8, 10, 8, 4, 7, 7, 5, 2, 6, 6, 9, 6, 10, 3, 4, 7, 10, 1, 10, 6, 3, 1, 3, 5, 4, 4, 4, 10, 4, 10, 2, 8, 1, 10, 10, 4, 3, 7, 1, 5, 5, 9, 4, 8, 1};
        int answer822 = 5;
        int result822 = solution.maxLength(nums822);
        System.out.println(answer822 == result822);
    }

    /**
     * LeetCode №3411. Maximum Subarray With Equal Products.
     * <p>
     * An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:
     * * prod(arr) is the product of all elements of arr.
     * * gcd(arr) is the GCD of all elements of arr.
     * * lcm(arr) is the LCM of all elements of arr.
     *
     * @param nums - an array of positive integers.
     * @return - the length of the longest product equivalent subarray of nums.
     */
    public int maxLength(int[] nums) {
        long[][] precomputedGCD = getGCD(nums);
        long[][] precomputedLCM = getLCM(nums);

        for (int length = nums.length; length > 1; length--) {
            for (int startIdx = 0, endIdx = startIdx + length - 1; endIdx < nums.length; startIdx++, endIdx++) {
                long curProd = computeProduct(startIdx, endIdx, nums);
                long curGCD = precomputedGCD[startIdx][endIdx];
                long curLCM = precomputedLCM[startIdx][endIdx];

                if (curProd == (curGCD * curLCM)) return length;
            }
        }

        return 1;
    }

    private long computeProduct(int start, int end, int[] numbers) {
        long product = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            product *= numbers[i];
        }
        return product;
    }

    private long[][] getGCD(int[] nums) {
        long[][] gcds = new long[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            gcds[i][i] = nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcds[i][j] = (int) gcd(gcds[i][j - 1], nums[j]);
            }
        }

        return gcds;
    }

    private long[][] getLCM(int[] nums) {
        long[][] lcms = new long[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            lcms[i][i] = nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                lcms[i][j] = lcm(lcms[i][j - 1], nums[j]);
            }
        }

        return lcms;
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}
