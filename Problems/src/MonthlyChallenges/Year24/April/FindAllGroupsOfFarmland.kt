package MonthlyChallenges.Year24.April

class FindAllGroupsOfFarmland {

    /**
     * LeetCode №1992. Find All Groups of Farmland.
     *
     * Complexity - O(N*M), N = land.size, M = land[i].size.
     * Memory - O(N*M)
     */
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val height = land.size
        val width = land[0].size

        val result: MutableList<IntArray> = mutableListOf()

        val visited: MutableList<MutableList<Boolean>> = mutableListOf()
        for (idx in land.indices) {
            val curRow = mutableListOf<Boolean>()
            for (i in 0 until width) {
                curRow.add(false)
            }
            visited.add(curRow)
        }

        for (row in 0 until height) {
            for (col in 0 until width) {
                if (land[row][col] == 0 || visited[row][col]) continue

                var rightEnd = col
                while (rightEnd < width && land[row][rightEnd] == 1) {
                    rightEnd += 1
                }

                var bottomEnd = row
                while (bottomEnd < height && land[bottomEnd][col] == 1) {
                    bottomEnd += 1
                }

                val curArr: IntArray = intArrayOf(row, col, bottomEnd - 1, rightEnd - 1)
                result.add(curArr)

                for (i in row until bottomEnd) {
                    for (j in col until rightEnd) {
                        visited[i][j] = true
                    }
                }
            }
        }

        return result.toTypedArray()
    }
}
