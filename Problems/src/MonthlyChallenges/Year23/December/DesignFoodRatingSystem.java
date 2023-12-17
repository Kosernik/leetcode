package MonthlyChallenges.Year23.December;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignFoodRatingSystem {
    /**
     * LeetCode №2353. Design a Food Rating System,
     */
    class FoodRatings {
        private final Map<String, PriorityQueue<Food>> cuisinesMap;
        private final Map<String, Food> names;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.names = new HashMap<>();
            this.cuisinesMap = new HashMap<>();

            for (int i = 0; i < foods.length; i++) {
                Food curFood = new Food(foods[i], cuisines[i], ratings[i]);

                if (!cuisinesMap.containsKey(cuisines[i])) {
                    cuisinesMap.put(cuisines[i], new PriorityQueue<>());
                }
                PriorityQueue<Food> curPQ = cuisinesMap.get(cuisines[i]);
                curPQ.offer(curFood);

                names.put(foods[i], curFood);
            }
        }

        public void changeRating(String food, int newRating) {
            Food foodItem = names.get(food);

            PriorityQueue<Food> pq = cuisinesMap.get(foodItem.cuisine);
            pq.remove(foodItem);


            foodItem.updateRating(newRating);
            pq.offer(foodItem);
        }

        public String highestRated(String cuisine) {
            return cuisinesMap.get(cuisine).peek().name;
        }

        class Food implements Comparable<Food> {
            String name;
            String cuisine;
            int rating;

            Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            void updateRating(int newRating) {
                this.rating = newRating;
            }

            @Override
            public int compareTo(Food other) {
                if (this.rating == other.rating) {
                    return String.CASE_INSENSITIVE_ORDER.compare(this.name, other.name);
                }
                return Integer.compare(other.rating, this.rating);
            }
        }
    }
}
