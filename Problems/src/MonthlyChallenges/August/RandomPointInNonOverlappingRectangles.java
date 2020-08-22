package MonthlyChallenges.August;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPointInNonOverlappingRectangles {
    //["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
    //[[[[99358434, 62418790, 99360410, 62419739], [9949520, 63556732, 9949788, 63556965]]], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]


    /**
     * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and
     * uniformily picks an integer point in the space covered by the rectangles.
     */
    class Solution {
        private TreeMap<Integer, Integer> rectangles;
        private int[][] rectsRaw;
        private int totalAmount;

        public Solution(int[][] rects) {
            totalAmount = 0;
            rectsRaw = new int[rects.length][];
            rectangles = new TreeMap<>();

            for (int  i =0; i < rects.length; i++) {
                rectsRaw[i] = Arrays.copyOf(rects[i], rects[i].length);
                rectangles.put(totalAmount, i);
                int currSurf = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
                totalAmount += currSurf;
            }
        }

        public int[] pick() {
            int random = ThreadLocalRandom.current().nextInt(0, totalAmount+1);
            int rectNumVal = rectangles.floorKey(random);
            int rectNum = rectangles.get(rectNumVal);

            int x = ThreadLocalRandom.current().nextInt(rectsRaw[rectNum][0], rectsRaw[rectNum][2]+1);
            int y = ThreadLocalRandom.current().nextInt(rectsRaw[rectNum][1], rectsRaw[rectNum][3]+1);
            return new int[] {x, y};
        }
    }
}
