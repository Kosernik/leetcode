package MonthlyChallenges.Year25.November;

import java.util.*;

public class FindXSumOfAllKLongSubarraysII {
    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysII solution = new FindXSumOfAllKLongSubarraysII();

        int[] nums0 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k0 = 6, x0 = 2;
        int[] result0 = {6, 10, 12};
        System.out.println(Arrays.toString(solution.findXSum(nums0, k0, x0)));
        System.out.println(Arrays.toString(result0));
    }

    /**
     * LeetCode №3321. Find X-Sum of All K-Long Subarrays II.
     * <p>
     * Complexity - TLE
     *
     * @param nums - an array of integers.
     * @param k    - the length of a subarray.
     * @param x    - the number of most frequent elements.
     * @return - an integer array result of length = n - k + 1, where result[i] is the x-sum of the subarray
     * * nums[i...i + k - 1].
     */
    public long[] findXSum(int[] nums, int k, int x) {
        long[] result = new long[nums.length - k + 1];

        //  value -> count
        Map<Integer, Integer> counts = new HashMap<>();

        //  count -> {values}
        NavigableMap<Integer, NavigableSet<Integer>> values = new TreeMap<>((a, b) -> Integer.compare(b, a));

        // count -> sum of values with this count
        Map<Integer, Long> sumOfValues = new HashMap<>();

        for (int i = 0; i < k; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int val = entry.getKey(), count = entry.getValue();
            if (!values.containsKey(count)) {
                values.put(count, new TreeSet<>((a, b) -> Integer.compare(b, a)));
            }
            values.get(count).add(val);
            sumOfValues.put(count, sumOfValues.getOrDefault(count, 0L) + val * (long) count);
        }

        result[0] = getSum(values, sumOfValues, x);

        for (int i = 1; i < result.length; i++) {
            int toRemove = nums[i - 1];
            int toAdd = nums[i + k - 1];

            if (toRemove == toAdd) {
                result[i] = result[i - 1];
                continue;
            }

            int oldRemoveCount = counts.get(toRemove);
            values.get(oldRemoveCount).remove(toRemove);
            sumOfValues.put(oldRemoveCount, sumOfValues.get(oldRemoveCount) - toRemove * (long) oldRemoveCount);

            oldRemoveCount--;
            if (oldRemoveCount == 0) {
                counts.remove(toRemove);
            } else {
                counts.put(toRemove, oldRemoveCount);

                if (!values.containsKey(oldRemoveCount)) {
                    values.put(oldRemoveCount, new TreeSet<>((a, b) -> Integer.compare(b, a)));
                }
                values.get(oldRemoveCount).add(toRemove);

                sumOfValues.put(oldRemoveCount, sumOfValues.getOrDefault(oldRemoveCount, 0L) + toRemove * (long) oldRemoveCount);
            }

            int oldAddCount = counts.getOrDefault(toAdd, 0);
            if (oldAddCount > 0) {
                values.get(oldAddCount).remove(toAdd);
                sumOfValues.put(oldAddCount, sumOfValues.get(oldAddCount) - toAdd * (long) oldAddCount);
            }
            oldAddCount++;

            counts.put(toAdd, oldAddCount);
            if (!values.containsKey(oldAddCount)) {
                values.put(oldAddCount, new TreeSet<>((a, b) -> Integer.compare(b, a)));
            }
            values.get(oldAddCount).add(toAdd);
            sumOfValues.put(oldAddCount, sumOfValues.getOrDefault(oldAddCount, 0L) + toAdd * (long) oldAddCount);

            result[i] = getSum(values, sumOfValues, x);
        }

        return result;
    }

    private long getSum(NavigableMap<Integer, NavigableSet<Integer>> values, Map<Integer, Long> sumOfValues, int targetSize) {
        long sum = 0L;

        for (var entry : values.entrySet()) {
            if (targetSize <= 0) {
                return sum;
            }

            long count = entry.getKey();
            if (entry.getValue().size() <= targetSize) {
                sum += sumOfValues.get((int) count);
                targetSize -= entry.getValue().size();
                continue;
            }

            for (int value : entry.getValue()) {
                sum += count * value;

                targetSize--;
                if (targetSize <= 0) {
                    return sum;
                }
            }
        }

        return sum;
    }
}
