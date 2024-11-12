package MonthlyChallenges.Year24.November;

import java.util.Arrays;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        MostBeautifulItemForEachQuery solution = new MostBeautifulItemForEachQuery();

        int[][] items0 = {
                {1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}
        };
        int[] queries0 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solution.maximumBeauty(items0, queries0)));
    }

    /**
     * LeetCode №2070. Most Beautiful Item for Each Query.
     * <p>
     * Complexity - O(NlogN + MlogN), N = items.length, M = queries.length.
     * Memory - O(N)
     *
     * @param items   - a 2D array of items, where items[i] = [price-i, beauty-i]
     * @param queries - an array of queries, where queries[i] is the maximum price for this query.
     * @return - an array result of the same length as queries, where result[i] is the maximum beauty of an item whose
     * price is less than or equal to queries[i]
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prefixMaxBeauty = new int[items.length];
        prefixMaxBeauty[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            prefixMaxBeauty[i] = Math.max(prefixMaxBeauty[i - 1], items[i][1]);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < items[0][0]) {
                result[i] = 0;
                continue;
            }
            int idx = binarySearch(queries[i], items);
            result[i] = prefixMaxBeauty[idx];
        }

        return result;
    }

    private int binarySearch(int price, int[][] items) {
        int left = 0, right = items.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (items[middle][0] <= price) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right - 1;
    }
}
