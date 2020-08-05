package ExploreCards.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists solution = new MinimumIndexSumOfTwoLists();
        solution.testFindRestaurant();
//        String[] l1 = {"Shogun","KFC", "Tapioca Express", "Burger King", "KFC"};
//        String[] l2 = {"KFC", "Shogun", "Burger King"};
//        System.out.println(Arrays.toString(solution.findRestaurant(l1, l2)));
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) return new String[]{};
        HashMap<String, Integer> indexes1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            if (!indexes1.containsKey(list1[i])) indexes1.put(list1[i], i);
        }

        int bestSum = Integer.MAX_VALUE;
        List<String> resList = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            String currStr = list2[i];
            if (indexes1.containsKey(currStr)) {
                int currSum = i + indexes1.get(currStr);
                if (currSum == bestSum) {
                    resList.add(currStr);
                } else if (currSum < bestSum) {
                    bestSum = currSum;
                    resList.clear();
                    resList.add(currStr);
                }
            }
        }

        String[] restaurants = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            restaurants[i] = resList.get(i);
        }
        return restaurants;
    }

    private void testFindRestaurant() {
        String[][] lists1 = {
                {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                {"Shogun","KFC", "Tapioca Express", "Burger King", "KFC"},
                {"Shogun","KFC", "Tapioca Express", "Burger King"}};
        String[][] lists2 = {
                {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"},
                {"KFC", "Shogun", "Burger King"},
                {"KFC", "Shogun", "Burger King"},
                {"KFC", "Shogun", "Burger King"}};
        String[][] results = {
                {"Shogun"},
                {"Shogun"},
                {"KFC","Shogun"},
                {"KFC","Shogun"}};

        int failed = 0;
        for (int i = 0; i < lists1.length; i++) {
            String[] currRes = findRestaurant(lists1[i], lists2[i]);
            if (!Arrays.equals(currRes, results[i])) {
                failed++;
                System.out.println("Failed test #" + i);
                System.out.println(Arrays.toString(currRes));
            }
        }
        System.out.println("Success rate: " + ((results.length - failed) * 100.0) / results.length);
    }
}
