package MonthlyChallenges.Year25.August;

public class FruitsIntoBasketsII {

    /**
     * LeetCode №3477. Fruits Into Baskets II.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param fruits  - an array of positive integers.
     * @param baskets - an array of positive integers. fruits.length = baskets.length.
     * @return - the number of fruit types that remain unplaced after all possible allocations are made.
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int result = 0;

        CustomLinkedList listOfBaskets = new CustomLinkedList(-1);
        CustomLinkedList node = listOfBaskets;

        for (int basket : baskets) {
            node.next = new CustomLinkedList(basket);
            node = node.next;
        }

        for (int fruit : fruits) {
            node = listOfBaskets;
            boolean found = false;

            while (node.next != null) {
                if (node.next.value >= fruit) {
                    node.next = node.next.next;
                    found = true;
                    break;
                } else {
                    node = node.next;
                }
            }

            if (!found) result++;
        }

        return result;
    }


    static class CustomLinkedList {
        int value;
        CustomLinkedList next = null;

        CustomLinkedList(int value) {
            this.value = value;
        }
    }
}
