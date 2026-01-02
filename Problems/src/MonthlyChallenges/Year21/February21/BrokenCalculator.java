package MonthlyChallenges.Year21.February21;


public class BrokenCalculator {
    // LeetCode #991.
    public int brokenCalc(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }

        int res = 0;

        int currY = Y;
        while (currY > X) {
            res++;
            if (currY % 2 == 0) {
                currY /= 2;
            } else {
                currY += 1;
            }
        }

        return res + X - currY;
    }
}
