package MonthlyChallenges.Year26.January;

import java.util.Arrays;
import java.util.List;

public class ConstructMinimumBitwiseArrayII {
    public static void main(String[] args) {
        ConstructMinimumBitwiseArrayII solution = new ConstructMinimumBitwiseArrayII();

        List<Integer> nums0 = Arrays.asList(new Integer[]{2, 3, 5, 7});
        System.out.println(Arrays.toString(solution.minBitwiseArray(nums0)));
    }

    /**
     * LeetCode №3315. Construct the Minimum Bitwise Array II.
     * <p>
     * You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and
     * ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
     * Additionally, you must minimize each value of ans[i] in the resulting array.
     *
     * @param nums - an array of prime numbers.
     * @return - the resulting array.
     */
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            if (number == 2) {
                result[i] = -1;
            } else {
                result[i] = unsetRightmostOneBeforeZero(number);
            }
        }

        return result;
    }

    private int unsetRightmostOneBeforeZero(int number) {
        int idx = -1;

        int mask = number;
        while (mask > 0) {
            if ((mask & 1) != 1) {
                break;
            }

            idx++;
            mask = mask >> 1;
        }

        return number & ~(1 << idx);
    }

    public int[] minBitwiseArrayTLE(List<Integer> nums) {
        int[] result = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            result[i] = getMinBitwise(nums.get(i));
        }

        return result;
    }

    private int getMinBitwise(int number) {
        int start = 1;

        int i = number;
        while (i > 1) {
            i = i >> 1;
            start = start << 1;
        }

        start--;

        while (start <= number) {
            if ((start | (start + 1)) == number) return start;
            start++;
        }

        return -1;
    }
}
