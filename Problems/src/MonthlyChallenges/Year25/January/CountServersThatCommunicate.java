package MonthlyChallenges.Year25.January;

public class CountServersThatCommunicate {
    public static void main(String[] args) {
        CountServersThatCommunicate solution = new CountServersThatCommunicate();

        int[][] test1 = {{1, 0}, {1, 1}};
        System.out.println(solution.countServers(test1) == 3);
        System.out.println();

        int[][] test3 = {{1, 1}, {1, 1}};
        System.out.println(solution.countServers(test3) == 4);
        System.out.println();

        int[][] test4 = {{1, 1}, {0, 1}};
        System.out.println(solution.countServers(test4) == 3);
        System.out.println();
    }

    /**
     * LeetCode №1267. Count Servers that Communicate.
     * <p>
     * Complexity - O(N*M), N = height of a matrix, M = width of a matrix.
     * Memory - O(M)
     *
     * @param grid - a 2d matrix of 0 and 1.
     * @return - the number of servers that communicate with any other server.
     */
    public int countServers(int[][] grid) {
        int connectedServers = 0;

        int height = grid.length;
        int width = grid[0].length;

        boolean[] columnVisited = new boolean[width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] != 0) {
                    boolean foundServers = false;

                    if (!columnVisited[col]) {
                        for (int r = 0; r < row; r++) {
                            if (grid[r][col] != 0) {
                                foundServers = true;
                                break;
                            }
                        }
                        for (int r = row + 1; r < height; r++) {
                            if (grid[r][col] == 1) {
                                foundServers = true;
                                grid[r][col] = -1;
                                connectedServers++;
                            } else if (grid[r][col] == -1) {
                                foundServers = true;
                            }
                        }
                        columnVisited[col] = true;
                    }

                    for (int c = col + 1; c < width; c++) {
                        if (grid[row][c] == 1) {
                            foundServers = true;
                            grid[row][c] = -1;
                            connectedServers++;
                        } else if (grid[row][c] == -1) {
                            foundServers = true;
                        }
                    }

                    if (grid[row][col] == 1 && foundServers) {
                        connectedServers++;
                    }

                    grid[row][col] = -1;

                    col = width;
                }
            }
        }

        return connectedServers;
    }
}
