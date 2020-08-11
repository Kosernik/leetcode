package MonthlyChallenges.August;

import java.util.Arrays;

public class HIndex {

    // Бинарный поиск
    // O(N*logN) - сложность
    // O(1) - память
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        if (citations[citations.length-1] <= 1) {
            return citations[citations.length-1];
        }

        int length = citations.length;
        int left = 0;
        int right = length-1;

        while (left < right) {
            int middle = (right - left) / 2 + left;
            int numberOfArticles = length - middle;
            int currCitation = citations[middle];

            if (currCitation >= numberOfArticles) {
                right = middle;
            } else {
                left = middle+1;
            }
        }
        return length - left;
    }

    // O(N) - сложность
    // O(N) - память
    public int hIndexFast(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int length = citations.length;
        int[] counts = new int[length+1];

        for (int cit : citations) {
            counts[Math.min(cit, length)]++;
        }

        int numOfCits = 0;

        for (int i = length; i >= 0; i--) {
            numOfCits += counts[i];
            if (numOfCits >= i) {
                return i;
            }
        }
        return 0;
    }
}
