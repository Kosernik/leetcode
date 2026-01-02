package MonthlyChallenges.Year21.April21;

import java.util.ArrayList;
import java.util.List;

public class PowerfulIntegers {
    /**
     * LeetCode #970.
     *
     * @param x     -- 1 <= x <= 100
     * @param y     -- 1 <= y <= 100
     * @param bound -- 0 <= bound <= 106
     * @return - a list of powerful integers.
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound < 2) {
            return new ArrayList<>();
        } else if (x == 1 && y == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(2);
            return result;
        } else if (x == 1) {
            return powerfulIntegers(y, x, bound);
        } else if (y == 1) {
            List<Integer> xPowers = getPowers(x, bound);
            List<Integer> result = new ArrayList<>();
            for (int xP : xPowers) {
                result.add(xP + 1);
            }
            return result;
        }

        boolean[] sums = new boolean[bound];

        List<Integer> firstPowers = getPowers(x, bound);

        int currY = 1;
        while (currY < bound) {
            for (int xPower : firstPowers) {
                if (currY + xPower <= bound) {
                    sums[currY + xPower - 1] = true;
                }
            }
            currY *= y;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            if (sums[i]) result.add(i + 1);
        }

        return result;
    }

    private List<Integer> getPowers(int val, int bound) {
        List<Integer> powers = new ArrayList<>();
        int currVal = 1;
        while (currVal < bound) {
            powers.add(currVal);
            currVal *= val;
        }
        return powers;
    }
}
