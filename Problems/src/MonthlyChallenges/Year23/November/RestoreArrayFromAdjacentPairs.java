package MonthlyChallenges.Year23.November;

import java.util.*;

public class RestoreArrayFromAdjacentPairs {

    /**
     * LeetCode №1743. Restore the Array From Adjacent Pairs.
     *
     * @param adjacentPairs - an array of all pairs of adjacent neighbours in the original array.
     * @return - the original array. If there are multiple solutions, returns any of them.
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> intervals = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            int first = pair[0];
            int second = pair[1];

            if (!intervals.containsKey(first) && !intervals.containsKey(second)) {
                List<Integer> array = new ArrayList<>();
                array.add(first);
                array.add(second);

                intervals.put(first, array);
                intervals.put(second, array);
            } else if (intervals.containsKey(first) && intervals.containsKey(second)) {
                List<Integer> combined = combineLists(intervals.get(first), intervals.get(second), first, second);
                int newFirst = combined.get(0);
                int newSecond = combined.get(combined.size() - 1);

                intervals.put(newFirst, combined);
                intervals.put(newSecond, combined);

                intervals.remove(first);
                intervals.remove(second);
            } else if (intervals.containsKey(first)) {
                List<Integer> array = intervals.get(first);

                addToList(first, second, array);
                intervals.put(second, array);
                intervals.remove(first);
            } else {
                List<Integer> array = intervals.get(second);
                addToList(second, first, array);
                intervals.put(first, array);
                intervals.remove(second);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : intervals.entrySet()) {
            int idx = 0;
            for (Integer value : entry.getValue()) {
                result[idx] = value;
                idx++;
            }
        }

        return result;
    }

    private List<Integer> combineLists(List<Integer> first, List<Integer> second, int firstVal, int secondVal) {
        if (first.get(0) == firstVal) {
            if (second.get(0) == secondVal) {
                Collections.reverse(second);
            }
            second.addAll(first);
            return second;
        } else {
            if (second.get(second.size() - 1) == secondVal) {
                Collections.reverse(second);
            }
            first.addAll(second);
            return first;
        }
    }

    private void addToList(int value, int neighbour, List<Integer> list) {
        if (list.get(0) == value) {
            list.add(0, neighbour);
        } else {
            list.add(neighbour);
        }
    }
}
