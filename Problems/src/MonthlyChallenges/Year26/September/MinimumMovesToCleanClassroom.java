package MonthlyChallenges.Year26.September;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MinimumMovesToCleanClassroom {
    public static void main(String[] args) {
        MinimumMovesToCleanClassroom solution = new MinimumMovesToCleanClassroom();

        String[] classroom0 = {"S.", "XL"};
        int energy0 = 2;
        int result0 = 2;
        System.out.println(solution.minMoves(classroom0, energy0) == result0);

        String[] classroom2 = {"L.S", "RXL"};
        int energy2 = 3;
        int result2 = -1;
        System.out.println(solution.minMoves(classroom2, energy2) == result2);

        String[] classroom3 = {".L.", "SRL", ".L."};
        int energy3 = 2;
        int result3 = 6;
        System.out.println(solution.minMoves(classroom3, energy3) == result3);

        String[] classroom4 = {"LLL", "SRL", "LLL"};
        int energy4 = 4;
        int result4 = 11;
        System.out.println(solution.minMoves(classroom4, energy4) == result4);
    }


    private final char START = 'S';
    private final char LITTER = 'L';
    private final char RESET = 'R';
    private final char OBSTACLE = 'X';
    private final char EMPTY = '.';

    private final int[][] NEIGHBOURS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * LeetCode №3568. Minimum Moves to Clean the Classroom.
     *
     * @param classroom - an array of strings representing the class layout.
     * @param energy    - the initial amount of energy.
     * @return - the minimum number of moves required to collect all litter items, or -1 if it's impossible.
     */
    public int minMoves(String[] classroom, int energy) {
        int litterCount = 0;
        int startRow = 0, startCol = 0;

        int height = classroom.length, width = classroom[0].length();
        int[][] grid = new int[height][width];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (classroom[r].charAt(c) == LITTER) {
                    grid[r][c] = 1 << litterCount;
                    litterCount++;
                } else if (classroom[r].charAt(c) == START) {
                    startRow = r;
                    startCol = c;
                }
            }
        }

        if (litterCount == 0) return 0;

        int litterMask = (1 << litterCount) - 1;

        int[][][] bestEnergy = new int[height][width][litterMask + 1];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                Arrays.fill(bestEnergy[r][c], -1);
            }
        }

        bestEnergy[startRow][startCol][0] = energy;

        Deque<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(startRow, startCol, 0, energy, 0));

        while (!queue.isEmpty()) {
            Entry entry = queue.removeFirst();

            if (entry.mask == litterMask) return entry.moves;
            if (entry.energy == 0) continue;

            for (int[] neighbour : NEIGHBOURS) {
                int nextRow = entry.row + neighbour[0];
                int nextCol = entry.column + neighbour[1];

                if (0 <= nextRow && nextRow < height && 0 <= nextCol && nextCol < width &&
                        classroom[nextRow].charAt(nextCol) != OBSTACLE) {
                    int nextMask = entry.mask | grid[nextRow][nextCol];
                    int nextEnergy = classroom[nextRow].charAt(nextCol) == RESET ? energy : entry.energy - 1;

                    if (nextEnergy > bestEnergy[nextRow][nextCol][nextMask]) {
                        bestEnergy[nextRow][nextCol][nextMask] = nextEnergy;
                        queue.addLast(new Entry(nextRow, nextCol, nextMask, nextEnergy, entry.moves + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Entry {
        int row;
        int column;
        int mask;
        int energy;
        int moves;

        Entry(int row, int column, int mask, int energy, int moves) {
            this.row = row;
            this.column = column;
            this.mask = mask;
            this.energy = energy;
            this.moves = moves;
        }
    }
}
