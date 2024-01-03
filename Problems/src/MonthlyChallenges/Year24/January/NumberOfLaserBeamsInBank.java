package MonthlyChallenges.Year24.January;

public class NumberOfLaserBeamsInBank {

    /**
     * LeetCode №2125. Number of Laser Beams in a Bank.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param bank - an array of strings representing the floor plan. '0' - empty cell, '1' - a cell with a laser.
     * @return - the total number of laser beams in the bank.
     */
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int prevRowLasers = 0;

        for (String row : bank) {
            int curCount = 0;
            for (char cell : row.toCharArray()) {
                curCount += cell == '0' ? 0 : 1;
            }

            if (curCount != 0) {
                beams += prevRowLasers * curCount;
                prevRowLasers = curCount;
            }
        }

        return beams;
    }
}
