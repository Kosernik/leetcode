package MonthlyChallenges.Year26.August;

public class DistributeElementsIntoTwoArraysI {

    /**
     * LeetCode №3069. Distribute Elements Into Two Arrays I.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param nums - an array of integers.
     * @return - the resulting array.
     */
    public int[] resultArray(int[] nums) {
        int[] result = new int[nums.length];

        int left = 0, right = nums.length - 1;
        result[left] = nums[0];
        result[right] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (result[left] > result[right]) {
                left++;
                result[left] = nums[i];
            } else {
                right--;
                result[right] = nums[i];
            }
        }

        reverseTail(right, result);

        return result;
    }

    private void reverseTail(int start, int[] numbers) {
        int end = numbers.length - 1;

        while (start < end) {
            int temp = numbers[end];
            numbers[end] = numbers[start];
            numbers[start] = temp;

            start++;
            end--;
        }
    }
}
