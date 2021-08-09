package MonthlyChallenges.August21;

public class AddStrings {
    public static void main(String[] args) {
        AddStrings solution = new AddStrings();
    }

    // LeetCode #415.
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int length = Math.min(num1.length(), num2.length());
        int idx1 = num1.length()-1;
        int idx2 = num2.length()-1;

        for (int i = 0; i < length; i++) {
            int curNumber = (num1.charAt(idx1--) - '0') + (num2.charAt(idx2--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }

        while (idx1 >= 0) {
            int curNumber = (num1.charAt(idx1--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }
        while (idx2 >= 0) {
            int curNumber = (num2.charAt(idx2--) - '0') + carry;
            result.append(curNumber % 10);
            carry = curNumber / 10;
        }

        if (carry > 0) result.append(carry);
        result.reverse();
        return result.toString();
    }
}
