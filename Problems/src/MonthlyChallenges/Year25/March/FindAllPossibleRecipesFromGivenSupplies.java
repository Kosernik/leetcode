package MonthlyChallenges.Year25.March;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {

    /**
     * LeetCode №2115. Find All Possible Recipes from Given Supplies.
     *
     * @param recipes     - an array of names of the recipes.
     * @param ingredients - a list of ingredients, where ingredients.get(i) is a list of ingredients for recipes[i].
     * @param supplies    - an array of given ingredients.
     * @return - a list of all the recipes that you can create.
     */
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> validRecipes = new ArrayList<>();

        Set<String> availableSupplies = new HashSet<>(List.of(supplies));
        Map<String, List<String>> recipeToIngredient = new HashMap<>();

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> currentIngredients = ingredients.get(i);

            boolean canMake = true;
            int unavailableIngredients = 0;
            for (String ingredient : currentIngredients) {
                if (!availableSupplies.contains(ingredient)) {
                    canMake = false;
                    unavailableIngredients++;
                }
            }

            if (canMake) {
                validRecipes.add(recipe);
                availableSupplies.add(recipe);
            } else {
                queue.offer(new Pair(recipe, unavailableIngredients));
                recipeToIngredient.put(recipe, currentIngredients);
            }
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            PriorityQueue<Pair> nextQueue = new PriorityQueue<>();

            for (int i = qSize; i > 0; i--) {
                Pair recipePair = queue.poll();

                List<String> currentIngredients = recipeToIngredient.get(recipePair.recipe);

                boolean canMake = true;
                int unavailableIngredients = 0;
                for (String ingredient : currentIngredients) {
                    if (!availableSupplies.contains(ingredient)) {
                        canMake = false;
                        unavailableIngredients++;
                    }
                }

                if (canMake) {
                    validRecipes.add(recipePair.recipe);
                    availableSupplies.add(recipePair.recipe);
                } else {
                    recipePair.unavailableIngredients = unavailableIngredients;
                    nextQueue.offer(recipePair);
                }
            }

            if (qSize == nextQueue.size()) break;
            queue = nextQueue;
        }

        return validRecipes;
    }

    static class Pair implements Comparable<Pair> {
        String recipe;
        int unavailableIngredients = 0;

        public Pair(String recipe, int unavailableIngredients) {
            this.recipe = recipe;
            this.unavailableIngredients = unavailableIngredients;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.unavailableIngredients, o.unavailableIngredients);
        }
    }
}
