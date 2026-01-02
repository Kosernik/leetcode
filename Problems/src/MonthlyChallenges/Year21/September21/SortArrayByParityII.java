package MonthlyChallenges.Year21.September21;

public class SortArrayByParityII {
    /**
     * LeetCode #922. Sort Array By Parity II.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers. nums.length is even. Half of the integers in nums are even.
     * @return - an array sorted by parity.
     */
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int idxEven = 0;
        int idxOdd = 1;

        for (int number : nums) {
            if (number % 2 == 0) {
                result[idxEven] = number;
                idxEven += 2;
            } else {
                result[idxOdd] = number;
                idxOdd += 2;
            }
        }

        return result;
    }
}
