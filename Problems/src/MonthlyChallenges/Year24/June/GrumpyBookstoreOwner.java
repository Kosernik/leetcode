package MonthlyChallenges.Year24.June;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        GrumpyBookstoreOwner solution = new GrumpyBookstoreOwner();

        int[] testCustomers0 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] testGrumpy0 = {0, 1, 0, 1, 0, 1, 0, 1};
        int testMinutes0 = 3;
        System.out.println(solution.maxSatisfied(testCustomers0, testGrumpy0, testMinutes0) == 16);

    }

    /**
     * LeetCode №1052. Grumpy Bookstore Owner.
     * <p>
     * Complexity = O(N)
     * Memory - O(1)
     *
     * @param customers - an array of non-negative integers, representing the number of customers at a given minute.
     * @param grumpy    - a binary array of 0 and 1, representing if an owner is grumpy at a given minute
     *                  (0 - not grumpy, 1 - grumpy). customers.length = grumpy.length.
     * @param minutes   - the number of consecutive minutes when an owner can keep themselves not grumpy.
     * @return - the maximum number of customers that can be satisfied throughout the day.
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxSatisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                maxSatisfiedCustomers += customers[i];
            }
        }

        int timeSlot = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                timeSlot += customers[i];
            }
        }
        int bestSlot = timeSlot;

        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i - minutes] == 1) {
                timeSlot -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                timeSlot += customers[i];
            }

            bestSlot = Math.max(timeSlot, bestSlot);
        }

        return maxSatisfiedCustomers + bestSlot;
    }
}
