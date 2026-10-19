#include <vector>
#include <algorithm>

using namespace std;

class Solution {

    /**
    * LeetCode 2089. Find Target Indices After Sorting Array.
    * <p>
    * Comoplexity - O(NlogN)
    * Memory - O(1)
    * <p>
    * A target index is an index i such that nums[i] == target.
    *
    * @param nums - an array of integers.
    * @param target - an integer.
    * @return - a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target
    * indices, returns an empty list. The returned list is sorted in increasing order.
    */
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        std::vector<int> result;

        sort(nums.begin(), nums.end());

        auto startIterator = lower_bound(nums.begin(), nums.end(), target);

        if (startIterator == nums.end()) return result;

        int idx = startIterator - nums.begin();

        while (idx < nums.size() && nums[idx] == target)
        {
            result.push_back(idx);
            idx++;
        }

        return result;
    }
};
