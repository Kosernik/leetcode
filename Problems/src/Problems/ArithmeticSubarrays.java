package Problems;

import java.util.*;

public class ArithmeticSubarrays {

    /**
     * LeetCode #1630. Arithmetic Subarrays.
     *
     * Complexity O(M * (N*NlogN + N)), N = nums.length, M = l.length = r.length
     * Memory - O(M)
     *
     * @param nums - an array of integers.
     * @param l - an array of non-negative integers, 0 <= l[i] < nums.length.
     * @param r - an array of non-negative integers, 0 <= r[i] < nums.length.
     *          l.length = r.length.
     * @return - Returns a list of boolean elements result, where result[i] is true if the subarray nums[l[i]],
     *           nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        Map<String, Boolean> computed = new HashMap<>();

        for (int i = 0; i < l.length; i++) {
            int startIdx = l[i];
            int endIdx = r[i];

            if (computed.containsKey(startIdx + "*" + endIdx)) {
                result.add(computed.get(startIdx + "*" + endIdx));
                continue;
            }

            if (startIdx >= endIdx) {
                result.add(Boolean.FALSE);
            } else {
                int[] rangeCopy = Arrays.copyOfRange(nums, startIdx, endIdx+1);
                Arrays.sort(rangeCopy);
                result.add(isArithmeticSubarray(rangeCopy));
            }
            computed.put(startIdx + "*" + endIdx, result.get(result.size()-1));
        }

        return result;
    }

    // Checks if array is arithmetic.
    private boolean isArithmeticSubarray(int[] numbers) {
        int difference = numbers[1] - numbers[0];

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] - numbers[i-1] != difference) return false;
        }

        return true;
    }
}
