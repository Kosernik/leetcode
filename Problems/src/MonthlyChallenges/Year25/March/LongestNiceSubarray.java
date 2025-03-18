package MonthlyChallenges.Year25.March;

public class LongestNiceSubarray {

    /**
     * LeetCode №2401. Longest Nice Subarray.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param nums - an array of positive integers.
     * @return - the length of the longest nice subarray.
     */
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;

        int[] counts = new int[31];

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            addToCounts(number, counts);

            while (start < i && !validSubarray(counts)) {
                int numberToDelete = nums[start];
                removeFromCounts(numberToDelete, counts);
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }

    private void addToCounts(int number, int[] counts) {
        for (int j = 0; j < counts.length; j++) {
            if ((number & (1 << j)) == (1 << j)) {
                counts[j]++;
            }
        }
    }

    private void removeFromCounts(int number, int[] counts) {
        for (int j = 0; j < counts.length; j++) {
            if ((number & (1 << j)) == (1 << j)) {
                counts[j]--;
            }
        }
    }

    private boolean validSubarray(int[] counts) {
        for (int count : counts) {
            if (count >= 2) {
                return false;
            }
        }

        return true;
    }
}
