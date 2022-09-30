package MonthlyChallenges.Year22.September;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {

    /**
     * LeetCode #218. The Skyline Problem.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param buildings - an array of coordinates of the buildings.
     *                  building[i][0] - the coordinate of the start of a building.
     *                  building[i][1] - the coordinate of the end of a building.
     *                  building[i][2] - the height of a building.
     * @return - a list of coordinates of a skyline of the city.
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        //  coordinate, (-height for the start of a building, height for the end of the building)
        List<int[]> heights = new ArrayList<>();

        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});  //  The start of the building have negative height
            heights.add(new int[]{building[1], building[2]});   //  The end of a building have positive height
        }
        heights.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(0);
        int prevHeight = 0;

        for (int[] height : heights) {
            if (height[1] >= 0) {    // the end of a building
                pq.remove(height[1]);
            } else { // the start of the building
                pq.offer(-height[1]);
            }

            int curHeight = pq.peek();
            if (curHeight != prevHeight) {
                List<Integer> point = new ArrayList<>();
                point.add(height[0]);
                point.add(curHeight);
                result.add(point);

                prevHeight = curHeight;
            }
        }

        return result;
    }
}
