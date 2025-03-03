package MonthlyChallenges.Year25.March;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {

    /**
     * LeetCode №2161. Partition Array According to Given Pivot.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums  - an array of integers.
     * @param pivot - an integer, pivot equals to an element of nums.
     * @return - rearranged nums.
     */
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> greater = new ArrayList<>();

        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                nums[idx] = nums[i];
                idx++;
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            }
        }

        int numberOfPivots = nums.length - greater.size() - idx;
        for (int i = 0; i < numberOfPivots; i++, idx++) {
            nums[idx] = pivot;
        }

        for (int number : greater) {
            nums[idx] = number;
            idx++;
        }

        return nums;
    }
}
