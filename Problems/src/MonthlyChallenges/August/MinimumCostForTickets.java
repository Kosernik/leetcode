package MonthlyChallenges.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MinimumCostForTickets {
    public static void main(String[] args) {
        MinimumCostForTickets solution = new MinimumCostForTickets();
        solution.testMincostTickets();

//        List<Integer> days = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 1; i <= 365; i++) {
//            int cur = random.nextInt(8);
//            if (cur == 2) {
//                days.add(i);
//            }
//        }
//        System.out.println(days.toString());
    }

    /**
     * Calculating the minimal cost of travel using 3 types of tickets (1day pass, 7days pass, 30days pass).
     *
     * Complexity - O(1) (O(365))
     * Memory - O(1) (O(366))
     *
     * @param days - array of days, when one needs to travel.
     *             Days are 1-indexed (1st of january = 1, 31st of December = 365), no leap years.
     * @param costs - array of length 3. costs[0] - cost for 1-day ticket, costs[1] - cost for 7-day ticket,
     *              costs[2] - cost for 30-day ticket
     * @return - minimal cost of traveling.
     */
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length != 3) return 0;

        // Array of costs for traveling
        int[] daysCosts = new int[366];

        // Initializing travel-days as -1
        for (int day : days) {
            daysCosts[day] = -1;
        }

        // Iterating over array of costs and calculating cost of traveling if needed or using previous days cost.
        for (int i = 1; i <= 365; i++) {
            // We need to travel at this day
            if (daysCosts[i] == -1) {
                // Calculating the cost of using 7day pass
                int sevenDays = (i - 7) >= 0 ? (daysCosts[i - 7] + costs[1]) : costs[1];

                // Calculating the cost of using 30day pass
                int month = (i - 30) >= 0 ? (daysCosts[i - 30] + costs[2]) : costs[2];

                // Using minimal cost of 1day pass or 7days pass or 30days pass
                // If using 1day pass, we add cost of previous day and cost of 1day pass
                daysCosts[i] = Math.min(Math.min(costs[0] + daysCosts[i - 1], sevenDays), month);
            }
            // Using cost from previous day
            else {
                daysCosts[i] = daysCosts[i-1];
            }
        }
//        System.out.println(Arrays.toString(daysCosts));

        return daysCosts[365];
    }

    private void testMincostTickets() {
        int[][] testDays = {{1,4,6,7,8,20},{1,2,3,4,5,6,7,8,9,10,30,31},
                {1, 2, 3, 4, 5, 7, 10, 12, 16, 17, 18, 20, 21, 22, 29, 30, 33, 34, 35, 37, 38, 40, 41, 42, 46, 48, 54, 55, 56, 58, 59, 60, 61, 62, 63, 64, 67, 69, 70, 71, 72, 74, 75, 78, 84, 85, 86, 87, 89, 94, 96, 97, 104, 105, 106, 108, 110, 111, 113, 121, 122, 124, 125, 135, 136, 138, 143, 144, 145, 146, 147, 151, 152, 153, 156, 157, 159, 160, 162, 163, 164, 170, 171, 172, 175, 177, 181, 182, 184, 185, 189, 191, 192, 193, 195, 196, 197, 198, 201, 202, 204, 205, 211, 214, 216, 219, 220, 221, 222, 223, 224, 225, 227, 229, 230, 232, 234, 236, 237, 238, 242, 243, 244, 246, 247, 249, 251, 252, 259, 260, 264, 265, 268, 270, 273, 275, 276, 277, 279, 282, 284, 286, 289, 290, 291, 292, 293, 294, 296, 301, 302, 303, 304, 305, 306, 309, 311, 312, 313, 315, 317, 318, 319, 324, 329, 330, 331, 333, 335, 336, 339, 340, 341, 347, 348, 349, 350, 352, 353, 355, 358, 359, 360, 361, 362, 364},
                {2, 5, 6, 16, 19, 22, 46, 53, 55, 72, 73, 75, 81, 88, 93, 105, 106, 108, 124, 142, 180, 186, 189, 190, 201, 204, 206, 219, 226, 238, 255, 265, 267, 282, 295, 299, 301, 304, 309, 312, 314, 320, 337, 341, 343, 349, 353, 355, 362},
                {2, 5, 6, 16, 19, 22, 46, 53, 55, 72, 73, 75, 81, 88, 93, 105, 106, 108, 124, 142, 180, 186, 189, 190, 201, 204, 206, 219, 226, 238, 255, 265, 267, 282, 295, 299, 301, 304, 309, 312, 314, 320, 337, 341, 343, 349, 353, 355, 362}};
        int[][] testCosts = {{2,7,15},{2,7,15},{2,7,15},{2,7,15},{4,6,10}};
        int[] results = {11,17,175,97,88};
        int failed = 0;

        for (int i = 0; i < testCosts.length; i++) {
            int currResult = mincostTickets(testDays[i], testCosts[i]);
            if (currResult != results[i]) {
                failed++;
                System.out.println("Failed test #" + i);
                System.out.println("Got: " + currResult + ", instead of: " + results[i]);
            }
        }

        System.out.println("Success rate: " + (testDays.length-failed)*100.0/testDays.length);
    }
}
