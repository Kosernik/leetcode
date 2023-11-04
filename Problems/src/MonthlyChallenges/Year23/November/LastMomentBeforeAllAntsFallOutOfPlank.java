package MonthlyChallenges.Year23.November;

public class LastMomentBeforeAllAntsFallOutOfPlank {

    /**
     * LeetCode #1503. Last Moment Before All Ants Fall Out of a Plank.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param n     - the length of a plank.
     * @param left  - an array of coordinates of ants moving left.
     * @param right - an array of coordinates of ants moving right.
     *              All values of left and right are unique, and each value can appear only in one of the two arrays.
     * @return - the moment when the last ant(s) fall out of the plank.
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;

        for (int ant : left) {
            lastMoment = Math.max(lastMoment, ant);
        }
        for (int ant : right) {
            lastMoment = Math.max(lastMoment, n - ant);
        }

        return lastMoment;
    }
}
