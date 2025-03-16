package MonthlyChallenges.Year25.March;

public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        MinimumTimeToRepairCars solution = new MinimumTimeToRepairCars();

        int[] ranks0 = {4, 3, 2, 1};
        int cars0 = 10;
        long result0 = 16;
        System.out.println(solution.repairCars(ranks0, cars0) == result0);
    }

    /**
     * LeetCode №2594. Minimum Time to Repair Cars.
     * <p>
     * Complexity - O(NlogM), N = ranks.length, M =Long.MAX_VALUE
     * Memory - O(1)
     * <p>
     * A mechanic with a rank r can repair n cars in r * n^2 minutes.
     *
     * @param ranks - an array of positive integers.
     * @param cars  - the total number of cars waiting to be repaired.
     * @return - the minimum time taken to repair all the cars.
     */
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = Long.MAX_VALUE;
        long middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (canRepair(middle, ranks, cars)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean canRepair(long time, int[] ranks, int cars) {
        //  time = rank * cars * cars

        for (int rank : ranks) {
            int carsFixed = (int) Math.sqrt(time / rank);
            cars -= carsFixed;

            if (cars <= 0) return true;
        }

        return false;
    }
}
