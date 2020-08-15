package MonthlyChallenges.August;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    // O(N*LogN)
    public int eraseOverlapIntervals(int[][] intervals) {
        // Пограничный случай - пустой массив
        if (intervals == null || intervals.length == 0) return 0;

        // Сортировка массива по правой координате
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        int rightCoordinate = intervals[0][1];  // Переменная, обозначающая правую границу интервалов
        int nonOverlapping = 1; // Общее количество непересекающихся интервалов

        // Проход по массиву интервалов
        // Если левая координата текущего интервала лежит или выходит за предыдущую границу интервала, то увеличиваем
        // количество непересекающихся интервалов и обновляем правую границу интервалов
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rightCoordinate) {
                nonOverlapping++;
                rightCoordinate = intervals[i][1];
            }
        }

        // Результат равен общему количеству интервалом минус количество непересекающихся интервалов
        return intervals.length - nonOverlapping;
    }
}
