package MonthlyChallenges.Year24.July;

import java.util.*;

public class SortJumbledNumbers {

    /**
     * LeetCode №2191. Sort the Jumbled Numbers.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param mapping - an array of digits which represents the mapping rule of a shuffled decimal system. All the
     *                values of mapping[i] are unique.
     *                mapping.length == 10
     *                0 <= mapping[i] <= 9
     * @param nums    - an array of integers.
     * @return - array nums sorted in non-decreasing order based on the mapped values of its elements. Elements with
     * the same mapped values appear in the same relative order as in the input.
     */
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Set<Integer>> converted = new HashMap<>();

        Map<Integer, Queue<Integer>> indices = new HashMap<>();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int curNumber = nums[i];

            int convertedNumber = convertNumber(curNumber, mapping);
            numbers.add(convertedNumber);

            if (!converted.containsKey(convertedNumber)) {
                converted.put(convertedNumber, new HashSet<>());
            }
            converted.get(convertedNumber).add(curNumber);

            if (!indices.containsKey(curNumber)) {
                indices.put(curNumber, new ArrayDeque<>());
            }
            indices.get(curNumber).offer(i);
        }

        numbers.sort(Integer::compare);


        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curConverted = numbers.get(i);

            Set<Integer> candidates = converted.get(curConverted);
            int bestIdx = Integer.MAX_VALUE;
            int bestNumber = -1;
            for (int candidate : candidates) {
                Integer curIdx = indices.get(candidate).peek();
                if (curIdx == null) continue;

                if (curIdx < bestIdx) {
                    bestIdx = curIdx;
                    bestNumber = candidate;
                }
            }
            indices.get(bestNumber).poll();

            result[i] = bestNumber;
        }

        return result;
    }

    private int convertNumber(int number, int[] mapping) {
        if (number == 0) return mapping[0];

        int converted = 0;
        int multiplier = 1;

        while (number != 0) {
            int curNum = mapping[(number % 10)] * multiplier;
            converted += curNum;

            multiplier *= 10;
            number /= 10;
        }

        return converted;
    }
}
