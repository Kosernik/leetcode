#include <iostream>
#include <queue>
#include <vector>

using namespace std;

/**
* LeetCode №3619. Count Islands With Total Value Divisible by K.
*
* Complexity - O(N*M) N = grid.size(), M = grid[0].size().
* Memory - O(N*M)
*/
class Solution {
   private:
    vector<vector<int>> neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

   public:
    int countIslands(vector<vector<int>>& grid, int k) {
        int totalIslands = 0;

        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid[0].size(); col++) {
                if (grid[row][col] > 0) {
                    long long value = computeValue(row, col, grid);
                    if ((value % k) == 0) {
                        totalIslands += 1;
                    }
                }
            }
        }

        return totalIslands;
    }

   private:
    long long computeValue(int& row, int& col, vector<vector<int>>& grid) {
        long long totalValue = grid[row][col];
        grid[row][col] = 0;

        queue<vector<int>> queue;
        queue.push({row, col});

        while (!queue.empty()) {
            auto curCell = queue.front();
            queue.pop();

            for (auto neighbour : neighbours) {
                int nextRow = curCell[0] + neighbour[0];
                int nextCol = curCell[1] + neighbour[1];

                if (0 <= nextRow && nextRow < grid.size() && 0 <= nextCol &&
                    nextCol < grid[0].size() && grid[nextRow][nextCol] > 0) {
                    queue.push({nextRow, nextCol});
                    totalValue += grid[nextRow][nextCol];
                    grid[nextRow][nextCol] = 0;
                }
            }
        }

        return totalValue;
    }
};

int main() {
    Solution solution;

    vector<vector<int>> grid1 = {{0, 2, 1, 0, 0},
                                 {0, 5, 0, 0, 5},
                                 {0, 0, 1, 0, 0},
                                 {0, 1, 4, 7, 0},
                                 {0, 2, 0, 0, 8}};
    int k1 = 5;
    int result1 = 2;
    int solAnswer1 = solution.countIslands(grid1, k1);
    std::cout << (solAnswer1 == result1) << std::endl;

    vector<vector<int>> grid398 = {{0, 0, 0},
                                   {0, 0, 1},
                                   {11, 0, 6},
                                   {0, 10, 2},
                                   {0, 0, 0},
                                   {8, 0, 0}};
    int k398 = 19;
    int result398 = 1;
    int solAnswer398 = solution.countIslands(grid398, k398);
    std::cout << (solAnswer398 == result398) << std::endl;

    return 0;
}
