package MonthlyChallenges.Year23.November;

public class MinimumAmountOfTimeToCollectGarbage {

    /**
     * LeetCode №2391. Minimum Amount of Time to Collect Garbage.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param garbage - an array of strings representing the garbage of each house.
     * @param travel  - an array of integers representing the time needed to travel from i-th house to the i+1-th house.
     * @return - the minimum number of time needed to pick up all the garbage.
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        char GLASS = 'G';
        char PAPER = 'P';
        char METALL = 'M';
        int COLLECT_TIME = 1;

        int glassTime = 0, paperTime = 0, metallTime = 0;
        int prevGlass = 0, prevPaper = 0, prevMetall = 0;

        for (int i = 0; i < garbage.length; i++) {
            int curGlass = 0, curPaper = 0, curMetall = 0;

            for (char c : garbage[i].toCharArray()) {
                if (c == GLASS) {
                    curGlass += COLLECT_TIME;
                } else if (c == PAPER) {
                    curPaper += COLLECT_TIME;
                } else if (c == METALL) {
                    curMetall += COLLECT_TIME;
                }
            }

            if (curGlass != 0) {
                glassTime += curGlass + prevGlass;
                prevGlass = 0;
            }
            if (curPaper != 0) {
                paperTime += curPaper + prevPaper;
                prevPaper = 0;
            }
            if (curMetall != 0) {
                metallTime += curMetall + prevMetall;
                prevMetall = 0;
            }

            if (i < travel.length) {
                prevGlass += travel[i];
                prevPaper += travel[i];
                prevMetall += travel[i];
            }
        }


        return glassTime + paperTime + metallTime;
    }
}
