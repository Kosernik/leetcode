class Solution {

/**
LeetCode №2778. Sum of Squares of Special Elements.

Complexity - O(N)
Memory - O(1)
*/
public:
    int sumOfSquares(vector<int>& nums) {
        int result = 0;

        int length = nums.size();

        for(int i = 1; i <= length; i++) {
            if ((length % i) == 0) {
                result += nums[i-1] * nums[i-1];
            }
        }

        return result;
    }
};
