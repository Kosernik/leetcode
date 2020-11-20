package MonthlyChallenges.November;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();

//        int[] tst0 = {2,5,6,0,0,1,2};
//        int[] tst1 = {2,5,6,7,0,0,1,2};
//        int[] tst2 = {1,1,3,1};
//        int[] tst3 = {2,2,2,0,0,1};
        int[] tst4 = {4,5,6,7,0,1,2};

        System.out.println("Result: " + solution.search(tst4, 6));
    }

    /**
     * Searches for the target in a sorted and rotated at some pivot array of integers.
     *
     * Complexity - Best case - O(logN), worst case - O(N)
     * Memory - Best case - O(1), worst case - O(N)
     *
     * @param nums - array of integers, sorted in ascending order and rotated at some unknown pivot.
     * @param target - value to search.
     * @return - True - if "target" is in given array, false - otherwise.
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        else if (nums.length == 1) return nums[0] == target;
        else if (nums[0] == nums[nums.length-1]) {
            int half = nums.length/ 2;
            int[] l = Arrays.copyOfRange(nums, 0, half);
            int[] r = Arrays.copyOfRange(nums, half, nums.length);

            return search(l, target) || search(r, target);
        }

        int left = 0;
        int right = nums.length-1;
        int middle;

        while (left <= right) {
            if (nums[left] == target || nums[right] == target) return true;

            if (nums[left] < nums[right]) {
                return binarySearchInterval(nums, target, left+1, right-1);
            } else {
                middle = (right - left) / 2 + left;
                if (nums[middle] == target) return true;

                if (nums[left] < nums[middle]) {
                    if (nums[left] < target && target < nums[middle]) {
                        return binarySearchInterval(nums, target, left + 1, middle - 1);
                    } else {
                        left = middle+1;
                    }
                } else if (nums[middle] < nums[right]) {
                    if (nums[middle] < target && target < nums[right]) {
                        return binarySearchInterval(nums, target, middle + 1, right - 1);
                    } else {
                        right = middle-1;
                    }
                } else {
                    return search(Arrays.copyOfRange(nums, left, middle), target) || search(Arrays.copyOfRange(nums, middle, right), target);
                }
            }
        }

        return false;
    }

    private boolean binarySearchInterval (int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        } else if (left == right) {
            return nums[left] == target;
        }

        int middle;

        while (left <= right) {
            middle = (right - left) / 2 + left;

            if (nums[middle] == target) return true;
            else if (nums[middle] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return false;
    }
}
