package MonthlyChallenges.Year23.February;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays solution = new CapacityToShipPackagesWithinDDays();

        int[] weights0 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days0 = 5;

        System.out.println(solution.shipWithinDays(weights0, days0));
    }


    /**
     * LeetCode #1011. Capacity To Ship Packages Within D Days.
     * <p>
     * Complexity - O(N + N*logM). N = weights.length, M = sum(weights).
     * Memory - O(1)
     *
     * @param weights - an array of positive integers.
     * @param days    - a positive integer.
     * @return - the least weight capacity of the ship that will result in all the packages on the conveyor belt being
     * shipped within "days" days.
     */
    public int shipWithinDays(int[] weights, int days) {
        int[] maxAndSum = getMaxAndSum(weights);

        int low = Math.max(maxAndSum[0], maxAndSum[1] / days);
        int high = maxAndSum[1];
        int middle;

        while (low < high) {
            middle = (high - low) / 2 + low;

            boolean validCapacity = canShip(weights, days, middle);
            if (validCapacity) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int curCapacity = 0;
        int ships = 0;

        for (int weight : weights) {
            curCapacity += weight;
            if (curCapacity > capacity) {
                ships++;
                curCapacity = weight;
                if (ships >= days) return false;
            }
        }

        return true;
    }

    private int[] getMaxAndSum(int[] weights) {
        int[] result = new int[]{0, 0};

        for (int weight : weights) {
            result[0] = Math.max(result[0], weight);
            result[1] += weight;
        }

        return result;
    }
}
