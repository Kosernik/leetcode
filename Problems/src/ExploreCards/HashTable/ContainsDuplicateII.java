package ExploreCards.HashTable;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexes.containsKey(nums[i])) {
                if (i - indexes.get(nums[i]) <= k) return true;
            }
            indexes.put(nums[i], i);
        }
        return false;
    }
}
