package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();

        System.out.println(solution.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }

    /**
     * LeetCode #1376. Time Needed to Inform All Employees.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n - the number of employees.
     * @param headID - the ID of the head manager.
     * @param manager - a list of managers for each employee.
     * @param informTime - a list of times needed for each manager to inform it`s employees.
     * @return - the time needed to inform all the employees.
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) return informTime[0];

        Map<Integer, List<Integer>> employees = getEmployees(manager);

        return getTime(headID, informTime, employees);
    }

    private int getTime(int employee, int[] informTime, Map<Integer, List<Integer>> employees) {
        if (!employees.containsKey(employee)) return 0;
        int time = 0;

        for (int e : employees.get(employee)) {
            time = Math.max(time, getTime(e, informTime, employees));
        }

        return time + informTime[employee];
    }

    private Map<Integer, List<Integer>> getEmployees(int[] manager) {
        // manager -> list of employees
        Map<Integer, List<Integer>> employees = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            List<Integer> curEmployees = employees.getOrDefault(m, new ArrayList<>());
            curEmployees.add(i);
            employees.put(m, curEmployees);
        }

        return employees;
    }
}
