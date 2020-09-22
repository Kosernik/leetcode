package MonthlyChallenges.September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    /**
     * Returns a list of elements that appear more than n/3 times.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - array of integers.
     * @return - a list of elements that appear more than n/3 times.
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majors = new ArrayList<>();
        if (nums == null || nums.length == 0) return majors;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if ((entry.getValue() > (nums.length)/3)) {
                majors.add(entry.getKey());
            }
        }

        return majors;
    }
}
