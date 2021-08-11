package MonthlyChallenges.August21;

import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        ArrayOfDoubledPairs solution = new ArrayOfDoubledPairs();

        int[] test2 = {4,-2,2,-4};
        System.out.println(solution.canReorderDoubled(test2));
    }

    // LeetCode #954.
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int number : arr) counts.put(number, counts.getOrDefault(number, 0) + 1);

        if (counts.containsKey(0)) {
            int zeroes = counts.get(0);
            if (zeroes % 2 != 0) return false;
            counts.remove(0);
        }

        NavigableSet<Integer> set = counts.navigableKeySet();
        for (Integer key : set) {
            if (counts.get(key) == 0) continue;
            int target;
            if (key < 0) {
                target = key / 2;
                if (target * 2 != key || !counts.containsKey(target) || (counts.get(key) > counts.get(target))) return false;
            } else {
                target = key * 2;
                if (!counts.containsKey(target) || (counts.get(key) > counts.get(target))) return false;
            }
            counts.put(target, counts.get(target) - counts.get(key));
        }
        return true;
    }
}
