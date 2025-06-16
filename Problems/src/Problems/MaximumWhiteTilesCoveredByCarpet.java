package Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MaximumWhiteTilesCoveredByCarpet {
    public static void main(String[] args) {
        MaximumWhiteTilesCoveredByCarpet solution = new MaximumWhiteTilesCoveredByCarpet();

        int[][] tiles0 = {{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}};
        int carpetLen0 = 10;
        int result0 = 9;
        System.out.println(solution.maximumWhiteTiles(tiles0, carpetLen0) == result0);

        int[][] tiles2 = {{1, 5}, {12, 18}, {20, 25}, {30, 32}};
        int carpetLen2 = 10;
        int result2 = 9;
        System.out.println(solution.maximumWhiteTiles(tiles2, carpetLen2) == result2);

        int[][] tiles1 = {
                {3745, 3757}, {3663, 3681}, {3593, 3605}, {3890, 3903}, {3529, 3539}, {3684, 3686}, {3023, 3026},
                {2551, 2569}, {3776, 3789}, {3243, 3256}, {3477, 3497}, {2650, 2654}, {2264, 2266}, {2582, 2599},
                {2846, 2863}, {2346, 2364}, {3839, 3842}, {3926, 3935}, {2995, 3012}, {3152, 3167}, {4133, 4134},
                {4048, 4058}, {3719, 3730}, {2498, 2510}, {2277, 2295}, {4117, 4128}, {3043, 3054}, {3394, 3402},
                {3921, 3924}, {3500, 3514}, {2789, 2808}, {3291, 3294}, {2873, 2881}, {2760, 2760}, {3349, 3362},
                {2888, 2899}, {3802, 3822}, {3540, 3542}, {3128, 3142}, {2617, 2632}, {3979, 3994}, {2780, 2781},
                {3213, 3233}, {3099, 3113}, {3646, 3651}, {3956, 3963}, {2674, 2691}, {3860, 3873}, {3363, 3370},
                {2727, 2737}, {2453, 2471}, {4011, 4031}, {3566, 3577}, {2705, 2707}, {3560, 3565}, {3454, 3456},
                {3655, 3660}, {4100, 4103}, {2382, 2382}, {4032, 4033}, {2518, 2531}, {2739, 2749}, {3067, 3079},
                {4068, 4074}, {2297, 2312}, {2489, 2490}, {2954, 2974}, {2400, 2418}, {3271, 3272}, {3628, 3632},
                {3372, 3377}, {2920, 2940}, {3315, 3330}, {3417, 3435}, {4146, 4156}, {2324, 2340}, {2426, 2435},
                {2373, 2376}, {3621, 3626}, {2826, 2832}, {3937, 3949}, {3178, 3195}, {4081, 4082}, {4092, 4098},
                {3688, 3698}};
        int carpetLen1 = 1638;
        int result1 = 822;
        System.out.println(solution.maximumWhiteTiles(tiles1, carpetLen1) == result1);
    }

    /**
     * LeetCode №2271. Maximum White Tiles Covered by a Carpet.
     *
     * @param tiles     - a 2d array of coordinates of tiles. Tiles are not overlapping.
     * @param carpetLen - the length of a carpet.
     * @return - the maximum number of tiles that can be covered by the carpet.
     */
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));

        int[] prefix = new int[tiles.length];

        //  tiles[i][0] -> i
        NavigableMap<Integer, Integer> startToIdx = new TreeMap<>();
        startToIdx.put(Integer.MAX_VALUE, tiles.length - 1);

        startToIdx.put(tiles[0][0], 0);
        prefix[0] = tiles[0][1] - tiles[0][0] + 1;
        if (prefix[0] >= carpetLen) return carpetLen;

        for (int i = 1; i < tiles.length; i++) {
            int curLength = (tiles[i][1] - tiles[i][0] + 1);
            if (curLength >= carpetLen) return carpetLen;   //  Tile is bigger than the carpet, no need to continue.

            prefix[i] = prefix[i - 1] + curLength;
            startToIdx.put(tiles[i][0], i);
        }

        //   Carpet is big enough to cover everything
        if (carpetLen >= (tiles[tiles.length - 1][1] - tiles[0][0] + 1)) return prefix[prefix.length - 1];

        int result = 0;
        int prevTiles = 0;

        long lastTileIdx = tiles[tiles.length - 1][1];
        long carpetLength = carpetLen - 1;

        for (int i = 0; i < tiles.length; i++) {
            int[] tile = tiles[i];
            int curStart = tile[0];

            int targetEnd = (int) Math.min(lastTileIdx, curStart + carpetLength);

            int nextStartIdx = startToIdx.floorKey(targetEnd);

            int idxInPrefix = startToIdx.get(nextStartIdx);

            int diff = 0;
            if (tiles[idxInPrefix][1] > targetEnd) {
                diff = tiles[idxInPrefix][1] - targetEnd;
            }

            int curLength = prefix[idxInPrefix] - prevTiles - diff;
            result = Math.max(result, curLength);
            prevTiles = prefix[i];
        }

        return result;
    }
}
