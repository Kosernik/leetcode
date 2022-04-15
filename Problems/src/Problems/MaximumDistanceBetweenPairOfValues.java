package Problems;

public class MaximumDistanceBetweenPairOfValues {
    public static void main(String[] args) {
        MaximumDistanceBetweenPairOfValues solution = new MaximumDistanceBetweenPairOfValues();

        solution.testBinSearch();
        solution.testMaxDistance();
    }

    /**
     * LeetCode #1855. Maximum Distance Between a Pair of Values.
     *
     * Complexity - O(NlogM), N = nums1.length, M = nums2.length.
     * Memory - O(1)
     *
     * @param nums1 - A non-increasing array of positive integers.
     * @param nums2 - A non-increasing array of positive integers.
     * @return - The maximum distance of any valid pair. A pair of indices (i, j), where 0 <= i < nums1.length and
     *           0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j].
     *           The distance of the pair is j - i.
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;

        for (int i = 0; i < nums1.length; i++) {
            if ((nums2.length-1) - i < maxDist) break;
            int target = -nums1[i];

            int j = binarySearchReverseOrderRange(nums2, target, i);
            if (j > i) {
                maxDist = Math.max(maxDist, (j-i));
            }
        }

        return maxDist;
    }

    private int binarySearchReverseOrderRange(int[] arr, int target, int low) {
        int high = arr.length, middle;

        while (low < high) {
            middle = (high - low) / 2 + low;

            if ((-arr[middle]) > target) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        return high-1;
    }

    private void testBinSearch() {
        int[] test0 = {100,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test0, -55, 0) == 0);

        int[] test1 = {100,56,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test1, -55, 0) == 1);

        int[] test2 = {100,55,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test2, -55, 0) == 1);

        int[] test3 = {100,54,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test3, -55, 0) == 0);

        int[] test4 = {54,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test4, -55, 0) == -1);

        int[] test5 = {55,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test5, -55, 0) == 0);

        System.out.println("-----------");
        int[] test6 = {100,56,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test6, -55, 2) == 1);

        int[] test7 = {100,55,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test7, -55, 2) == 1);

        int[] test8 = {100,54,20,10,10,5};
        System.out.println(binarySearchReverseOrderRange(test8, -55, 2) == 1);
    }

    private void testMaxDistance() {
        System.out.println("Test 0");
        int[] test01 = {55,30,5,4,2};
        int[] test02 = {100,20,10,10,5};
        System.out.println(maxDistance(test01, test02) == 2);

        System.out.println("Test 1");
        int[] test11 = {2,2,2};
        int[] test12 = {10,10,1};
        System.out.println(maxDistance(test11, test12) == 1);

        System.out.println("Test 2");
        int[] test21 = {30,29,19,5};
        int[] test22 = {25,25,25,25,25};
        System.out.println(maxDistance(test21, test22) == 2);
    }
}
