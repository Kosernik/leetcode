package MonthlyChallenges.Year24.April

import java.util.*
import kotlin.collections.ArrayDeque


class RevealCardsInIncreasingOrder {

    /**
     * 950. Reveal Cards In Increasing Order
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     */
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val result: IntArray = IntArray(deck.size)

        Arrays.sort(deck)
        val queue: ArrayDeque<Int> = ArrayDeque<Int>()
        for (idx in deck.indices) queue.addLast(idx)

        var sortedIdx = 0
        while (!queue.isEmpty()) {
            val idx = queue.removeFirst()
            result[idx] = deck[sortedIdx]
            sortedIdx += 1

            if (!queue.isEmpty()) {
                queue.addLast(queue.removeFirst())
            }
        }

        return result
    }
}
