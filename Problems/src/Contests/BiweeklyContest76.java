package Contests;

public class BiweeklyContest76 {
    public static void main(String[] args) {
        BiweeklyContest76 solution = new BiweeklyContest76();

        solution.testMethod("Test");
    }


    private void testMethod(String s) {
        System.out.println(s);
    }

    //  1
    public int findClosestNumber(int[] nums) {
        int bestPositive = 100_001;
        int bestNegative = -100_001;

        for (int number : nums) {
            if (number == 0) return number;
            else if (number > 0) {
                bestPositive = Math.min(bestPositive, number);
            } else {
                bestNegative = Math.max(bestNegative, number);
            }
        }

        if ((-bestNegative) < bestPositive) {
            return bestNegative;
        } else {
            return bestPositive;
        }
    }

    //  2
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > total && cost2 > total) return 1L;
        long result = 0;

        int curCost1 = 0;

        while (curCost1 <= total) {
            int remainder = total - curCost1;

            result += remainder / cost2 + 1;
            curCost1 += cost1;
        }

        return result;
    }

    //  3
    class ATM {
        //  20  50  100  200  500
        private final long[] cashCount;
        private final int[] cashBanknotes = {20,50,100,200,500};

        public ATM() {
            cashCount = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                cashCount[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            if (amount < 20 || (amount%10 != 0)) return new int[] {-1};

            int[] banknotes = new int[5];
            int idx = 4;

            while (amount > 0) {
                if (idx < 0) break;

                if (amount >= cashBanknotes[idx]) {
                    int required = amount / cashBanknotes[idx];
                    int gotBanknotes = (int) Math.min(cashCount[idx], required);

                    amount = amount - gotBanknotes * cashBanknotes[idx];
                    banknotes[idx] += gotBanknotes;
                    cashCount[idx] -= gotBanknotes;
                }
                idx--;
            }

            if (amount == 0) {
                return banknotes;
            } else {
                deposit(banknotes);
                return new int[] {-1};
            }
        }
    }

    //  4
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;

        return -1;
    }
}
