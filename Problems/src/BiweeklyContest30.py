import math
from typing import List

class Solution:

    def reformatDate(self, date: str) -> str:
        dates = date.split(" ")
        months = {"Jan":"01", "Feb":"02", "Mar":"03", "Apr":"04", "May":"05", "Jun":"06",
                  "Jul":"07", "Aug":"08", "Sep":"09", "Oct":"10", "Nov":"11", "Dec":"12"}
        day = str(dates[0][:2]) if dates[0][1].isdigit() else ("0" + str(dates[0][0]))
        result = dates[2] + "-" + months.get(dates[1]) + "-" + day
        return result


    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        array = [0 for i in range(int(n*(n+1)/2))]

        startIdx = 0
        i = 0
        while i < len(array):
            curSum = 0
            for j in range(startIdx, n):
                curSum += nums[j]
                array[i] = curSum
                i += 1

            startIdx += 1

        array.sort()

        res = 0
        for k in range(left-1, right):
            res += array[k]
        return res

    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 3:
            return 0

        nums.sort()
        min1 = nums[-4] - nums[0]
        min2 = nums[-3] - nums[1]
        min3 = nums[-2] - nums[2]
        min4 = nums[-1] - nums[3]

        return min(min(min1, min2), min(min3, min4))

    # def winnerSquareGame(self, n: int) -> bool:
    #     sq = int(math.sqrt(n))
    #     if sq**2 == n :
    #         return True
    #
    #     self.squares = [i ** 2 for i in range(1, int(math.sqrt(n)) + 1)]
    #     self.calculated = dict()
    #     for num in self.squares:
    #         self.calculated[num] = True
    #
    #     # print(self.squares)
    #
    #     for num in self.squares:
    #         if n-num in self.squares:
    #             return False
    #
    #     sums = set()
    #
    #     for num in self.squares:
    #         for secNum in self.squares:
    #             sums.add(num+secNum)
    #
    #     for num in self.squares:
    #         if (n-num) in sums:
    #             return True
    #
    #     return False


sol = Solution()

# print(sol.winnerSquareGame(1))
# print(sol.winnerSquareGame(2))
# print(sol.winnerSquareGame(3))
# print(sol.winnerSquareGame(4))
# print(sol.winnerSquareGame(5))
# print(sol.winnerSquareGame(6))
# print(sol.winnerSquareGame(7))
print(sol.winnerSquareGame(17))
# print(sol.winnerSquareGame(10**5))
# print(10**5)
