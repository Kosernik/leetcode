package Problems;

public class KokoEatingBananas {

    /**
     * LeetCode #875. Koko Eating Bananas.
     *
     * Complexity - O(NlogN)
     * Memory - O(1)
     *
     * @param piles - an array of positive integers representing the number of bananas in each pile.
     * @param h - the number of hours.
     * @return - the minimum number of bananas per hour to eat all bananas within 'h' hours.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (!canEat(piles, middle, h)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private boolean canEat(int[] piles, int candidate, int h) {
        int curHours = 0;

        for (int pile : piles) {
            curHours += (int) Math.ceil(pile / (double) candidate);
            if (curHours > h) return false;
        }

        return true;
    }

    private int getMax(int[] piles) {
        int max = piles[0];

        for (int pile : piles) max = Math.max(max, pile);

        return max;
    }
}
