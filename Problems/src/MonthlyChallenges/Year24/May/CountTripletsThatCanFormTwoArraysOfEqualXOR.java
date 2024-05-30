package MonthlyChallenges.Year24.May;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        CountTripletsThatCanFormTwoArraysOfEqualXOR solution = new CountTripletsThatCanFormTwoArraysOfEqualXOR();

        int[] test0 = {2, 3, 1, 6, 7};
        System.out.println(solution.countTriplets(test0));
    }

    /**
     * LeetCode №1442. Count Triplets That Can Form Two Arrays of Equal XOR.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param arr - an array of integers.
     * @return - the number of triplets on indices where xor of 2 sub-arrays are equal.
     */
    public int countTriplets(int[] arr) {
        int[] preXors = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            preXors[i + 1] = preXors[i] ^ arr[i];
        }

        int result = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int startXor = preXors[i];
            for (int j = i + 1; j < arr.length; j++) {
                int curXor = startXor ^ preXors[j + 1];
                if (curXor == 0) {
                    result += (j - i);
                }
            }
        }

        return result;
    }
}
