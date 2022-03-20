package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        AddToArrayFormOfInteger solution = new AddToArrayFormOfInteger();

        int[] test0 = {1,2,0,0};
        int k0 = 34;

        System.out.println(solution.addToArrayForm(test0, k0));

        int[] test1 = {9,9,9,9,9,9,9,9,9,9};
        int k1 = 1;

        System.out.println(solution.addToArrayForm(test1, k1));

        int[] test2 = {9};
        int k2 = 1000;

        System.out.println(solution.addToArrayForm(test2, k2));
    }

    /**
     * LeetCode #989. Add to Array-Form of Integer.
     *
     *
     * @param num -an number represented as an array.
     * @param k - an integer.
     * @return - the result of adding k to num.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = num.length-1; i >= 0; i--) {
            result.add(num[i] );
        }

        int index = 0;
        while (k != 0) {
            int digit = k % 10;
            if (index == result.size()) {
                result.add(digit);
            } else {
                addDigit(result, digit, index);
            }
            index++;
            k /= 10;
        }

        Collections.reverse(result);
        return result;
    }

    private void addDigit(List<Integer> number, int digit, int index) {
        int carry = digit;

        while (carry != 0 && index < number.size()) {
            int curNumber = number.get(index) + carry;

            number.set(index, curNumber % 10);
            carry = curNumber / 10;
            index++;
        }

        if (carry != 0) number.add(carry);
    }
}
