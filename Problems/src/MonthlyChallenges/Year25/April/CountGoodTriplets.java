package MonthlyChallenges.Year25.April;

public class CountGoodTriplets {

    /**
     * LeetCode №1534. Count Good Triplets.
     * <p>
     * Complexity - O(N^3)
     * Memory - O(1)
     * <p>
     * A triplet (arr[i], arr[j], arr[k]) is good if:
     * * 0 <= i < j < k < arr.length
     * * |arr[i] - arr[j]| <= a
     * * |arr[j] - arr[k]| <= b
     * * |arr[i] - arr[k]| <= c
     *
     * @param arr - an array of integers.
     * @param a   - an integer.
     * @param b   - an integer.
     * @param c   - an integer.
     * @return - the total number of good triplets.
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int length = arr.length;

        for (int i = 0; i < length - 2; i++) {
            int first = arr[i];

            for (int j = i + 1; j < length - 1; j++) {
                if (Math.abs(first - arr[j]) <= a) {
                    int second = arr[j];

                    for (int k = j + 1; k < length; k++) {
                        if (Math.abs(second - arr[k]) <= b && Math.abs(first - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
