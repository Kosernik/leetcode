package MonthlyChallenges.March21;

public class SetMismatch {
    /**
     * LeetCode #645.
     *
     * Returns the duplicate and the missing numbers from an array of integers "nums".
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - array of integers from 1 to nums.length.
     * @return - duplicate and missing numbers.
     */
    public int[] findErrorNums(int[] nums) {
        boolean[] present = new boolean[nums.length];
        int[] result = new int[2];

        for (int number : nums) {
            if (present[number-1]) {
                result[0] = number;
            }
            present[number-1] = true;
        }
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                result[1] = i+1;
                break;
            }
        }

        return result;
    }
}
