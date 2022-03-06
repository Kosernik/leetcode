package MonthlyChallenges.Year22.March;

public class CountAllValidPickupAndDeliveryOptions {

    private final int MODULO = 1_000_000_007;
    /**
     * LeetCode #1359. Count All Valid Pickup and Delivery Options.
     *
     * Complexity - O(1)
     * Memory - O(1)
     *
     * @param n - the number of orders, each order consist in pickup and delivery services. 1 <= n <= 500
     * @return - all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
     *           Result is modulo 'MODULO'.
     */
    public int countOrders(int n) {
        if (n == 1) return 1;

        int prev = countOrders(n-1);
        int numberOfDeliveryPositions = n * 2 - 1;

        int numberOfPermutationsForSinglePickup = (int) (((long)numberOfDeliveryPositions * prev) % MODULO);
        int result = (int) (((long)numberOfPermutationsForSinglePickup * n) % MODULO);

        return result;
    }
}
