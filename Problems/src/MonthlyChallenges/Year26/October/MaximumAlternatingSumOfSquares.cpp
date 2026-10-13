#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

class Solution {

    /**
    * LeetCode №3727. Maximum Alternating Sum of Squares.
    *
    * Complexity - O(NlogN)
    * Memory - O(logN)
    */
public:
    long long maxAlternatingSum(std::vector<int>& nums) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            nums[i] = abs(nums[i]);
        }

        sort(nums.rbegin(), nums.rend());

        long long result = 0;

        for (int left = 0, right = size - 1; left < right; left++, right--) {
            result += nums[left] * nums[left] - nums[right] * nums[right];
        }

        if ((size & 1) == 1) {
            int mid = size / 2;
            result += nums[mid] * nums[mid];
        }

        return result;
    }
};


int main() {
    std::vector<int> test0 = {1,2,3};

    Solution Solution;

    long long res0 = Solution.maxAlternatingSum(test0);

    std::cout << res0 << std::endl;
}
