package Problems;

import java.util.*;

public class IntersectionOfTwoArraysII {

    /**
     * LeetCode #350. Intersection of Two Arrays II.
     *
     * Complexity - O(N + M), N = nums1.length, M = nums2.length.
     * Memory - O(M)
     *
     * @param nums1 - an array of integers.
     * @param nums2 - an array of integers.
     * @return - an array of intersection of nums1 and nums2.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        } else if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums1) {
            int curCount = map.getOrDefault(element, 0);
            map.put(element, curCount+1);
        }
        List<Integer> intersection = new LinkedList<>();
        for (int element : nums2) {
            if (map.containsKey(element)) {
                int count = map.get(element);
                if (count != 0) {
                    map.put(element, count-1);
                    intersection.add(element);
                }
            }
        }

        int[] result = convertToArray(intersection);
        return result;
    }


    /**
     * LeetCode #350. Intersection of Two Arrays II.
     *
     * Complexity - O((N + M)logM), N = nums1.length, M = nums2.length.
     * Memory - O(M)
     *
     * @param nums1 - an array of integers.
     * @param nums2 - an array of integers.
     * @return - an array of intersection of nums1 and nums2.
     */
    public int[] intersectBinSearch(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) return intersectBinSearch(nums2, nums1);

        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int number : nums1) {
            int leftIdx = binSearchLeft(nums2, number);
            if (leftIdx != -1) {
                int numberOfNumbers = binSearchRight(nums2, number) - leftIdx + 1;
                int usedNumbers = counts.getOrDefault(number, 0);

                if (usedNumbers < numberOfNumbers) {
                    counts.put(number, usedNumbers+1);
                    intersection.add(number);
                }
            }
        }

        int[] result = convertToArray(intersection);
        return result;
    }

    private int[] convertToArray(List<Integer> intersection) {
        int[] result = new int[intersection.size()];
        int idx = 0;
        for (Integer element : intersection) {
            result[idx] = element;
            idx++;
        }
        return result;
    }

    private int binSearchLeft(int[] arr, int target) {
        int left = 0, right = arr.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;
            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        if (left == arr.length) return -1;
        return arr[left] == target ? left : -1;
    }

    private int binSearchRight(int[] arr, int target) {
        int left = 0, right = arr.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (arr[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right-1;
    }
}
