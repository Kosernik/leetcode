package MonthlyChallenges.Year25.September;

public class FindClosestPerson {

    /**
     * LeetCode №3516. Find Closest Person.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param x - the position of the first person.
     * @param y - the position of the second person.
     * @param z - the position of the third person.
     * @return - 1 if Person 1 arrives first, 2 if Person 2 arrives first,  0 if both arrive at the same time.
     */
    public int findClosest(int x, int y, int z) {
        int timeX = Math.abs(z - x);
        int timeY = Math.abs(z - y);

        if (timeX < timeY) {
            return 1;
        } else if (timeX > timeY) {
            return 2;
        } else {
            return 0;
        }
    }
}
