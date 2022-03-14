package Problems;

import java.util.ArrayDeque;

public class NearestExitFromEntranceInMaze {

    /**
     * LeetCode #1926. Nearest Exit from Entrance in Maze.
     *
     * Complexity - O(N*M), N = maze.length, M = maze[0].length.
     * Memory - O(N*M)
     *
     * @param maze - a 2d square array of chars '.' and '+'. '.' - an empty cell, '+' - a wall.
     * @param entrance - the starting point in a maze.
     * @return - the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path
     *           exists. An exit is defined as an empty cell that is at the border of the maze.
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int length = 0;

        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];
        visited[entrance[0]][entrance[1]] = true;

        int[] neighbours = new int[] {0,1,0,-1,0};
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0, n = 0; i < 4; i++, n++) {
            int neighRow = entrance[0] + neighbours[n];
            int neighCol = entrance[1] + neighbours[n+1];

            if (neighRow >= 0 && neighRow < height && neighCol >= 0 && neighCol < width &&
                    maze[neighRow][neighCol] == '.') {
                queue.offerLast(new int[] {neighRow, neighCol});
                visited[neighRow][neighCol] = true;
            }
        }

        while (!queue.isEmpty()) {
            length++;

            for (int q = queue.size(); q > 0; q--) {
                int[] cell = queue.removeFirst();

                for (int i = 0, n = 0; i < 4; i++, n++) {
                    int neighRow = cell[0] + neighbours[n];
                    int neighCol = cell[1] + neighbours[n+1];

                    if (neighRow >= 0 && neighRow < height && neighCol >= 0 && neighCol < width) {
                        if (!visited[neighRow][neighCol] && maze[neighRow][neighCol] == '.') {
                            visited[neighRow][neighCol] = true;
                            queue.offerLast(new int[] {neighRow, neighCol});
                        }
                    } else {
                        return length;
                    }
                }
            }
        }

        return -1;
    }
}
