package MonthlyChallenges.Year24.January;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertArrayInto2DArrayWithConditions {

    /**
     * LeetCode №2610. Convert an Array Into a 2D Array With Conditions.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the resulting 2D array.
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : nums) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            for (int i = 1; i <= count; i++) {
                if (result.size() < i) {
                    result.add(new ArrayList<>());
                }
                result.get(i - 1).add(number);
            }
        }

        return result;
    }
}
