package MonthlyChallenges.Year24.December;

public class MaxChunksToMakeSorted {

    /**
     * LeetCode №769. Max Chunks To Make Sorted.
     * <p>
     * Complexity - O(N), N = arr.length.
     * Memory - O(1)
     *
     * @param arr - an array of integers from 0 to N-1. All the elements of arr are unique.
     * @return - the largest number of chunks it is possible to make to sort the array.
     */
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;

        int length = arr.length;

        int curStart = 0;
        int curMax = -1;
        int requiredLength;
        boolean startFound = false;

        for (int i = 0; i < length; i++) {
            int number = arr[i];

            curMax = Math.max(curMax, number);
            requiredLength = curMax - curStart + 1;

            if (number == curStart) {
                startFound = true;
            }

            if (startFound) {
                int curLength = i - curStart + 1;

                if (curLength == requiredLength) {
                    chunks++;

                    startFound = false;
                    curStart = i + 1;
                    curMax = -1;
                }
            }
        }

        return chunks;
    }
}
