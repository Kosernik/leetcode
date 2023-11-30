package MonthlyChallenges.Year23.November;

public class MinimumOneBitOperationsToMakeIntegersZero {
    public static void main(String[] args) {
        MinimumOneBitOperationsToMakeIntegersZero solution = new MinimumOneBitOperationsToMakeIntegersZero();

        int[] tests = {3, 6, 0, 1, 9, 17582};
        int[] results = {2, 4, 0, 1, 14, 30923};

        for (int i = 0; i < tests.length; i++) {
            System.out.println(solution.minimumOneBitOperations(tests[i]) + " - " + results[i]);
        }

//        System.out.println(Integer.toBinaryString(solution.changeBit(6)));
    }


    /**
     * LeetCode №1611. Minimum One Bit Operations to Make Integers Zero.
     *
     * @param n - a non-negative integer.
     * @return - the minimum number of operations to transform n into 0.
     */
    public int minimumOneBitOperations(int n) {
        int ans = n;
        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;
        return ans;
    }

}
