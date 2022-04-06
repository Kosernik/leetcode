package Problems;

public class PeakIndexInMountainArray {

    /**
     * LeetCode #852. Peak Index in a Mountain Array.
     *
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param arr -an array of integers
     * @return - the index of a peak of a mountain in the array.
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length-2;

        while (left < right) {
            int middle = (right - left) / 2 + left;

            if (arr[middle-1] < arr[middle] && arr[middle] > arr[middle+1]) {
                return middle;
            } else if (arr[middle-1] < arr[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
