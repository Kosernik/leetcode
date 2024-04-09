package MonthlyChallenges.Year24.April

import kotlin.math.min

class TimeNeededToBuyTickets {

    /**
     * LeetCode №2073. Time Needed to Buy Tickets
     *
     * Complexity - O(N)
     * Memory - O(1)
     */
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var ticketsNeeded = tickets[k]
        var result = ticketsNeeded

        for (person in 0 until k) {
            result += min(tickets[person], ticketsNeeded)
        }

        ticketsNeeded -= 1

        for (person in (k + 1) until tickets.size) {
            result += min(tickets[person], ticketsNeeded)
        }

        return result
    }
}
