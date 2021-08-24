package MonthlyChallenges.August21;

public class ComplexNumberMultiplication {
    // LeetCode #537.
    public String complexNumberMultiply(String num1, String num2) {
        int[] first = splitNumber(num1);
        int[] second = splitNumber(num2);

        int real = first[0] * second[0] - first[1] * second[1];
        int imaginary = first[0] * second[1] + first[1] * second[0];

        return real + "+" + imaginary + 'i';
    }

    private int[] splitNumber(String number) {
        int[] result = new int[2];

        int idxOfPlus = 0;
        while (number.charAt(idxOfPlus) != '+') idxOfPlus++;

        result[0] = Integer.parseInt(number.substring(0, idxOfPlus));
        result[1] = Integer.parseInt(number.substring(idxOfPlus+1, number.length()-1));

        return result;
    }
}
