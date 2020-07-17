package MonthlyChallenges;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] test = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(solution.topKFrequent(test, 2)));
    }

    // O(n)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        } else if (nums.length == 1) {
            return new int[]{nums[0]};
        }

        // Подсчет количества копий копий каждого элемента
        Map<Integer, Integer> countElements = new HashMap<>();
        for (int element : nums) {
            int currCount = countElements.getOrDefault(element, 0);
            countElements.put(element, currCount + 1);
        }

        // Массив списков из элементов, где индекс в массиве означат количество копий элемента в исходном массиве
        ArrayList<Integer>[] frequencies = new ArrayList[nums.length+1];

        for (Map.Entry<Integer, Integer> entry : countElements.entrySet()) {
            ArrayList<Integer> currList = frequencies[entry.getValue()];
            if (currList == null) {
                currList = new ArrayList<>();
                frequencies[entry.getValue()] = currList;
            }
            currList.add(entry.getKey());
        }


        int[] topFrequentElements = new int[k];
        int resIdx = k-1, srcIdx = nums.length-1;

        // Заполнение результирующего масива элементами
        while (resIdx >= 0) {
            ArrayList<Integer> currList = null;
            // Поиск следующего по частоте появления списка элементов
            while (currList == null) {
                currList = frequencies[srcIdx];
                srcIdx--;
            }
            // Добавление всех элементов списка в результат
            for (int element : currList) {
                topFrequentElements[resIdx] = element;
                resIdx--;
            }
        }

        return topFrequentElements;
    }

}
