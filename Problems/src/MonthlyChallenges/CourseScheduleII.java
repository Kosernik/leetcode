package MonthlyChallenges;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        System.out.println("Test 1");
        int n0 = 2;
        int[][] preqs0 = {{1,0}};
        System.out.println(Arrays.toString(solution.findOrder(n0, preqs0)));

        System.out.println("Test 2");
        int n1 = 4;
        int[][] preqs1 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(solution.findOrder(n1, preqs1)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Массив, содержащий для каждого курса количество требуемых предварительных курсов
        int[] degree = new int[numCourses];
        // Карта, содержащая для каждого курса список открываемых курсов
        Map<Integer, List<Integer>> courses = new HashMap<>();

        // Заполнение массива и карты
        for (int[] prerequisite : prerequisites) {
            List<Integer> currCourse = courses.getOrDefault(prerequisite[1], new ArrayList<>());
            currCourse.add(prerequisite[0]);
            courses.put(prerequisite[1], currCourse);

            degree[prerequisite[0]]++;
        }

        // Очередь из курсов, список курсов по порядку прохожденияб набор уже пройденых курсов
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> orderOfCourses = new ArrayList<>();

        // Добавление в очередь курсов, у которых нет требований по предварительному прохождению других курсов.
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            // Чтение номера текущего курса, добавление его в результат и в список пройденых курсов
            int currCourse = queue.poll();
            orderOfCourses.add(currCourse);

            // Чтение списка курсов, открываемых после прохождения текущего курса
            List<Integer> children = courses.get(currCourse);
            // Если список пустой, то переходим к следующему в очереди курсу
            if (children == null || children.size() == 0) continue;

            // Для каждого "зависимого" курса уменьшаем количество требуемых курсов
            for (int child : children) {
                degree[child]--;

                // Если у "зависимого" курса больше нет требований, добавляем его в очередь
                if (degree[child] == 0) {// && !visited.contains(child)) {
                    queue.offer(child);
                }
            }
        }

        // Проверка соответствия количества курсов в списке и общего количества курсов
        if (orderOfCourses.size() != numCourses) return new int[]{};
        // Если все курсы пройдены, то конвертируем результат в массив
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = orderOfCourses.get(i);
        }
        return result;
    }
}
