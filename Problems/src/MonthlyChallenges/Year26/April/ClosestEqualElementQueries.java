package MonthlyChallenges.Year26.April;

import java.util.*;

public class ClosestEqualElementQueries {
    public static void main(String[] args) {
        ClosestEqualElementQueries solution = new ClosestEqualElementQueries();

        int[] nums0 = {1, 3, 1, 4, 1, 3, 2};
        int[] queries0 = {0, 3, 5};
        int[] result0 = {2, -1, 3};
        List<Integer> result = solution.solveQueries(nums0, queries0);
        for (int i = 0; i < result0.length; i++) {
            System.out.println(result.get(i) == result0[i]);
        }
    }

    /**
     * LeetCode №3488. Closest Equal Element Queries.
     * <p>
     * The minimum distance between the element at index queries[i] and any other index j in the circular array, where
     * nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
     *
     * @param nums    - an array of integers.
     * @param queries - an array of indices in nums. 0 <= queries[i] < nums.length
     * @return - a list result of size = queries.length. Where result.get(i) is the minimum distance for queries[i]
     */
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();

        int length = nums.length;

        Map<Integer, List<Integer>> numbersToIndices = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int number = nums[i];
            if (!numbersToIndices.containsKey(number)) {
                numbersToIndices.put(number, new ArrayList<>());
            }
            numbersToIndices.get(number).add(i);
        }

        for (int queryIdx : queries) {
            int distance = findClosestInSortedList(queryIdx, numbersToIndices.get(nums[queryIdx]), length);
            result.add(distance);
        }

        return result;
    }

    /**
     * LeetCode №3488. Closest Equal Element Queries.
     * <p>
     * The minimum distance between the element at index queries[i] and any other index j in the circular array, where
     * nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
     *
     * @param nums    - an array of integers.
     * @param queries - an array of indices in nums. 0 <= queries[i] < nums.length
     * @return - a list result of size = queries.length. Where result.get(i) is the minimum distance for queries[i]
     */
    public List<Integer> solveQueriesAlt(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();

        int length = nums.length;

        Set<Integer> targetValues = new HashSet<>();
        for (int queryIdx : queries) {
            targetValues.add(nums[queryIdx]);
        }

        Map<Integer, List<Integer>> numbersToIndices = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int number = nums[i];
            if (!targetValues.contains(number)) continue;

            if (!numbersToIndices.containsKey(number)) {
                numbersToIndices.put(number, new ArrayList<>());
            }
            numbersToIndices.get(number).add(i);
        }

        targetValues = null;

        for (int queryIdx : queries) {
            int distance = findClosestInSortedList(queryIdx, numbersToIndices.get(nums[queryIdx]), length);
            result.add(distance);
        }

        return result;
    }

    private int findClosestInSortedList(int startIdx, List<Integer> indices, int length) {
        if (indices.size() == 1) return -1;

        int binSearchIdx = Collections.binarySearch(indices, startIdx);

        int moveLeftIdx = (binSearchIdx - 1 + indices.size()) % indices.size();
        int moveRightIdx = (binSearchIdx + 1) % indices.size();

        int moveLeft = Math.abs(indices.get(moveLeftIdx) - startIdx);
        int moveLeftDistance = Math.min(moveLeft, length - moveLeft);
        int moveRight = Math.abs(indices.get(moveRightIdx) - startIdx);
        int moveRightDistance = Math.min(moveRight, length - moveRight);

        return Math.min(moveLeftDistance, moveRightDistance);
    }

    /**
     * LeetCode №3488. Closest Equal Element Queries.
     * <p>
     * The minimum distance between the element at index queries[i] and any other index j in the circular array, where
     * nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
     *
     * @param nums    - an array of integers.
     * @param queries - an array of indices in nums. 0 <= queries[i] < nums.length
     * @return - a list result of size = queries.length. Where result.get(i) is the minimum distance for queries[i]
     */
    public List<Integer> solveQueriesTLE(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();

        for (int queryIdx : queries) {
            result.add(findClosest(queryIdx, nums));
        }

        return result;
    }

    private int findClosest(int startIdx, int[] nums) {
        int length = nums.length;
        int target = nums[startIdx];

        int left = (startIdx - 1 + length) % length;
        int right = (startIdx + 1) % length;

        int steps = 1;
        int maxSteps = length / 2 + 1;
        while (left != right && steps <= maxSteps) {
            if (nums[left] == target || nums[right] == target) {
                return steps;
            }

            left = (left - 1 + length) % length;
            right = (right + 1) % length;
            steps++;
        }

        if (left == startIdx) return -1;
        if (nums[left] == target) {
            return steps;
        }

        return -1;
    }
}
