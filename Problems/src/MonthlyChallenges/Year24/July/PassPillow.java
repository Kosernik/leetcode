package MonthlyChallenges.Year24.July;

public class PassPillow {
    public static void main(String[] args) {
        PassPillow solution = new PassPillow();

        int testN = 4;
        int testTime = 15;
        System.out.println(solution.passThePillow(testN, testTime) == 4);
    }


    /**
     * LeetCode №2582. Pass the Pillow.
     * <p>
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n    - the number of persons standing in a line. Persons labeled from 1 to n.
     * @param time - a positive integer representing the time.
     * @return - the index of the person holding the pillow after time seconds.
     */
    public int passThePillow(int n, int time) {
        int personNumber = (time - 1) % (n - 1);
        int direction = (time - 1) / (n - 1);
        if (direction % 2 == 0) {   // left to right
            return personNumber + 2;
        } else {    // right to left
            return n - 1 - personNumber;
        }
    }
}
