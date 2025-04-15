package MonthlyChallenges.Year25.April;

public class CountGoodTripletsInArray {
    public static void main(String[] args) {
        CountGoodTripletsInArray solution = new CountGoodTripletsInArray();

        int[] nums1_0 = {13, 14, 10, 2, 12, 3, 9, 11, 15, 8, 4, 7, 0, 6, 5, 1};
        int[] nums2_0 = {8, 7, 9, 5, 6, 14, 15, 10, 2, 11, 4, 13, 3, 12, 1, 0};
        int result_0 = 77;
        System.out.println(solution.goodTriplets(nums1_0, nums2_0) == result_0);
    }

    /**
     * LeetCode №2179. Count Good Triplets in an Array.
     *
     * @param nums1 - an array of length n. nums1 is a permutation of integers from 0 to n-1.
     * @param nums2 - an array of length n. nums2 is a permutation of integers from 0 to n-1. nums1.length = nums2.length.
     * @return - the total number of good triplets.
     */
    public long goodTriplets(int[] nums1, int[] nums2) {
        long count = 0;

        int length = nums1.length;

        int[] nums2indices = getIndices(nums2);
        int[] nums2in_nums1indices = new int[length];

        for (int i = 0; i < length; i++) {
            int number = nums1[i];
            int idx = nums2indices[number];
            nums2in_nums1indices[idx] = i;
        }

        BITree tree = new BITree(length);

        for (int val = 0; val < length; val++) {
            int pos = nums2in_nums1indices[val];
            int left = tree.query(pos);
            tree.update(pos, 1);

            int right = length - pos - val - 1 + left;
            count += (long) left * right;
        }

        return count;
    }

    private int[] getIndices(int[] numbers) {
        int[] indices = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            indices[numbers[i]] = i;
        }

        return indices;
    }

    class BITree {
        private int[] tree;

        BITree(int size) {
            this.tree = new int[size + 1];
        }

        void update(int index, int delta) {
            index++;
            while (index < tree.length) {
                tree[index] += delta;
                index += leastSignificantSetBit(index);
            }
        }

        int query(int index) {
            index++;
            int result = 0;

            while (index > 0) {
                result += tree[index];
                index -= leastSignificantSetBit(index);
            }

            return result;
        }

        private int leastSignificantSetBit(int number) {
            return number & -number;
        }
    }
}
