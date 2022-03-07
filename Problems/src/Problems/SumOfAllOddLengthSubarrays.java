package Problems;

public class SumOfAllOddLengthSubarrays {

    /**
     * LeetCode #1588. Sum of All Odd Length Subarrays.
     *
     * @param arr - an array of integers.
     * @return - the sum of all odd-length subarrays of arr.
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int[] preSum = new int[arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            preSum[i+1] = preSum[i] + arr[i];
        }

        for (int size = 1; size <= arr.length; size += 2) {
            for (int i = 0; i <= (arr.length - size); i++) {
                sum += preSum[i+size] - preSum[i];
            }
        }

        return sum;
    }
}
