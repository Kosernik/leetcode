package Problems;

public class MinimumNumberOfDaysToMakeMBouquets {

    /**
     * LeetCode #1482. Minimum Number of Days to Make m Bouquets.
     *
     * Complexity - O(N*logP), N = bloomDay.length, P = max value in bloomDay (1_000_000_000)
     * Memory - O(1)
     *
     * @param bloomDay - an array of positive integers.
     * @param m - the required number of bouquets.
     * @param k - the number of adjacent flowers from the bloomDay.
     * @return - the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is
     *           impossible to make m bouquets return -1.
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m*k) return -1;

        int left = 0, right = 1_000_000_000, middle;

        while (left < right) {
            middle = (right + left) / 2;
            int numberOfBouquets = getNumberOfBouquets(bloomDay, k, middle);

            if (numberOfBouquets < m) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private int getNumberOfBouquets(int[] bloomDay, int k, int day) {
        int count = 0;
        int curK = 0;

        for (int j : bloomDay) {
            if (j <= day) {
                curK++;
                if (curK == k) {
                    count++;
                    curK = 0;
                }
            } else {
                curK = 0;
            }
        }

        return count;
    }
}
