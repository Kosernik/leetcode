package MonthlyChallenges.Year23.February;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();

        int[] test0 = {1, 2, 1};
        System.out.println(solution.totalFruit(test0) == 3);

        int[] test1 = {1, 0, 1, 4, 1, 4, 1, 2, 3};
        System.out.println(solution.totalFruit(test1) == 5);
    }

    /**
     * LeetCode #904. Fruit Into Baskets.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param fruits - an array of non-negative integers representing types of fruits.
     * @return - the maximum number of fruits that is possible to pick.
     */
    public int totalFruit(int[] fruits) {
        int prevFruitLength = 0;
        int prevFruit = fruits[0];
        int idx = 0;

        while (idx < fruits.length && fruits[idx] == prevFruit) {
            prevFruitLength++;
            idx++;
        }
        if (idx == fruits.length) return prevFruitLength;

        int maxFruits = prevFruitLength;

        int prevConsecutiveLength = prevFruitLength;
        int firstFruit = -1;
        int firstFruitLength = 0;

        for (int i = idx; i < fruits.length; i++) {
            if (fruits[i] == prevFruit) {
                prevConsecutiveLength++;
            } else if (fruits[i] == firstFruit) {
                int tempFruit = firstFruit;
                int tempLength = firstFruitLength;

                firstFruit = prevFruit;
                firstFruitLength = prevFruitLength;

                prevFruit = tempFruit;
                prevFruitLength = tempLength;
                prevConsecutiveLength = 1;
            } else {
                firstFruit = prevFruit;
                firstFruitLength = prevConsecutiveLength;

                prevFruit = fruits[i];
                prevFruitLength = 0;
                prevConsecutiveLength = 1;
            }

            prevFruitLength++;

            maxFruits = Math.max(maxFruits, prevFruitLength + firstFruitLength);
        }

        return maxFruits;
    }
}
