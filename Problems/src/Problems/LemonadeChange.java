package Problems;

public class LemonadeChange {

    /**
     * LeetCode #860. Lemonade Change.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param bills - an array of bills each customer have. bills[i] is 5 or 10 or 20.
     * @return - True if it is possible to provide every customer with the correct change. False - otherwise.
     */
    public boolean lemonadeChange(int[] bills) {
        // 5$   10$
        int[] countBills = new int[2];

        for (int bill : bills) {
            if (!canGiveChange(countBills, bill)) return false;
        }
        return true;
    }

    private boolean canGiveChange(int[] countBills, int bill) {
        if (bill == 5) {
            countBills[0]++;
            return true;
        } else if (bill == 10) {
            countBills[1]++;
            if (countBills[0] >= 1) {
                countBills[0] --;
                return true;
            } else {
                return false;
            }
        } else if (bill == 20) {
            if (countBills[1] >= 1 && countBills[0] >= 1) {
                countBills[1]--;
                countBills[0] --;
                return true;
            } else if (countBills[0] >= 3) {
                countBills[0] -= 3;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
