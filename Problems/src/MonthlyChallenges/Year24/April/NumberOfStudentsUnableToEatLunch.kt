package MonthlyChallenges.Year24.April

class NumberOfStudentsUnableToEatLunch {

    /**
     * LeetCode №1700. Number of Students Unable to Eat Lunch
     *
     * Complexity - O(N)
     * Memory - O(1)
     */
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var zeroCount = 0
        var oneCount = 0

        for (student in students) {
            if (student == 0) {
                zeroCount += 1
            } else {
                oneCount += 1
            }
        }

        for (sandwich in sandwiches) {
            if (sandwich == 0) {
                if (zeroCount == 0) {
                    return oneCount
                }
                zeroCount -= 1
            } else {
                if (oneCount == 0) {
                    return zeroCount
                }
                oneCount -= 1
            }
        }

        return 0
    }
}
