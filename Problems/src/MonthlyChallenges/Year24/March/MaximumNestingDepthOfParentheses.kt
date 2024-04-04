package MonthlyChallenges.Year24.March

import kotlin.math.max

class MaximumNestingDepthOfParentheses {

    /**
     * LeetCode №1614. Maximum Nesting Depth of the Parentheses.
     *
     * Complexity - O(N)
     * Memory - O(1)
     */
    fun maxDepth(s: String): Int {
        var result = 0
        var curDepth = 0

        for (letter: Char in s) {
            if (letter == '(') {
                curDepth += 1
            } else if (letter == ')') {
                result = max(result, curDepth)
                curDepth -= 1
            }
        }

        return result
    }
}
