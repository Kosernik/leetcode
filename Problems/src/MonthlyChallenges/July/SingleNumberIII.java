package MonthlyChallenges.July;

import java.util.*;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Boolean> seen = new HashMap<>();

        for (int number : nums) {
            if (seen.containsKey(number)) {
                seen.put(number, false);
            } else {
                seen.put(number, true);
            }
        }

        List<Integer> singles = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> entry : seen.entrySet()) {
            if (entry.getValue()) {
                singles.add(entry.getKey());
            }
        }
        int[] result = new int[singles.size()];

        for (int i = 0; i < singles.size(); i++) {
            result[i] = singles.get(i);
        }
        return result;
    }
}
