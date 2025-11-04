package MonthlyChallenges.Year25.November;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumOfAllKLongSubarraysI {
    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysI solution = new FindXSumOfAllKLongSubarraysI();

        int[] nums0 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k0 = 6, x0 = 2;
        int[] result0 = {6, 10, 12};
        System.out.println(Arrays.toString(solution.findXSum(nums0, k0, x0)));
        System.out.println(Arrays.toString(result0));
    }

    /**
     * LeetCode №3318. Find X-Sum of All K-Long Subarrays I.
     *
     * @param nums - an array of integers.
     * @param k    - the length of a subarray.
     * @param x    - the number of most frequent elements.
     * @return - an integer array result of length = n - k + 1, where result[i] is the x-sum of the subarray
     * nums[i...i + k - 1].
     */
    public int[] findXSum(int[] nums, int k, int x) {
        int length = nums.length;

        int[] result = new int[length - k + 1];

        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < k; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        //  {value, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>(x,
                (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        result[0] = getSum(counts, pq, x);

        for (int i = 1; i < result.length; i++) {
            int toRemove = nums[i - 1];
            int toAdd = nums[i + k - 1];

            int removeCount = counts.get(toRemove) - 1;
            if (removeCount == 0) {
                counts.remove(toRemove);
            } else {
                counts.put(toRemove, removeCount);
            }

            counts.put(toAdd, counts.getOrDefault(toAdd, 0) + 1);

            result[i] = getSum(counts, pq, x);
        }

        return result;
    }

    private int getSum(Map<Integer, Integer> counts, PriorityQueue<int[]> pq, int targetSize) {
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > targetSize) pq.poll();
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += pair[0] * pair[1];
        }

        return sum;
    }
}
