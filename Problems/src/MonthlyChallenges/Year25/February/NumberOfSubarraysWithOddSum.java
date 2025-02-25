package MonthlyChallenges.Year25.February;

public class NumberOfSubarraysWithOddSum {

    /**
     * LeetCode №1524. Number of Sub-arrays With Odd Sum.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param arr - an array of positive integers.
     * @return - the number of subarrays with an odd sum. Result is modulo 1_000_000_007.
     */
    public int numOfSubarrays(int[] arr) {
        int MODULO = 1_000_000_007;
        long result = 0;

        //  oddEvenCount[i][0] = even count, oddEvenCount[i][1] = odd count
        int[][] oddEvenCount = new int[arr.length + 1][2];
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
//            curSum = (curSum + arr[i]) % 2;
            curSum = (curSum + arr[i]) & 1;

            int curResult;
            if (curSum == 0) {
                curResult = oddEvenCount[i][1];
                oddEvenCount[i + 1][0] = 1;
            } else {    //  curSum == 1
                curResult = oddEvenCount[i][0] + 1;
                oddEvenCount[i + 1][1] = 1;
            }

            result = (result + curResult) % MODULO;

            oddEvenCount[i + 1][0] += oddEvenCount[i][0];
            oddEvenCount[i + 1][1] += oddEvenCount[i][1];
        }

        return (int) (result % MODULO);
    }
}
