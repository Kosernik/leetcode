package Problems;

public class AverageSalaryExcludingMinimumAndMaximumSalary {

    /**
     * LeetCode #1491. Average Salary Excluding the Minimum and Maximum Salary.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param salary - an array of salaries.
     * @return - the average salary of employees excluding the minimum and maximum salary.
     */
    public double average(int[] salary) {
        long totalSum = 0L;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = 0;

        for (int sal : salary) {
            totalSum += sal;
            minSalary = Math.min(minSalary, sal);
            maxSalary = Math.max(maxSalary, sal);
        }

        totalSum = totalSum - minSalary - maxSalary;

        return totalSum / (double) (salary.length - 2.0);
    }
}
