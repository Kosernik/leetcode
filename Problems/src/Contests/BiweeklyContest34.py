from typing import List
from timeit import default_timer as timer

class Solution:

    def diagonalSum(self, mat: List[List[int]]) -> int:
        size = len(mat)
        sum = 0

        for i in range(size):
            sum += mat[i][i]

        for j in range(size):
            second = size - j - 1
            if j == second:
                continue
            sum += mat[j][second]

        return sum

    def numWays(self, s: str) -> int:
        numberOfOnes = 0
        for i in range(len(s)):
            if s[i] == "1":
                numberOfOnes += 1
        if numberOfOnes % 3 != 0:
            return 0
        elif numberOfOnes == 0:
            return self.ncrAlt(len(s)) % 1000000007

        zeroesToLeft = 0
        zeroesToRight = 0

        idxLeft = 0
        toCount = numberOfOnes // 3
        counted = 0

        while counted < toCount:
            if s[idxLeft] == "1":
                counted += 1
            idxLeft += 1

        idx = idxLeft
        while s[idx] != "1":
            zeroesToLeft += 1
            idx += 1

        counted = 0
        idxRight = len(s)-1
        while counted < toCount:
            if s[idxRight] == "1":
                counted += 1
            idxRight -= 1

        idx = idxRight
        while s[idx] != "1":
            zeroesToRight += 1
            idx -= 1

        res = ((zeroesToLeft + 1) * (zeroesToRight + 1)) % 1000000007

        return res

    def ncr(self, num):
        count = 0
        for i in range(1, num-1):
            count += (num - i) - 1
        return count
    def ncrAlt(self, num):
        return (num*num - 3 * num + 2) // 2


sol = Solution()
# for i in range(3, 30000):
#     if sol.ncr(i) != sol.ncrAlt(i):
#         print("Wrong answer for i: " + str(i))
#         print(sol.ncr(i),"\t", sol.ncrAlt(i))
# print("Done")

start = timer()
for i in range(3, 30000):
    sol.ncr(i)
end = timer()
print(end - start)

start = timer()
for i in range(3, 30000):
    sol.ncrAlt(i)
end = timer()
print(end - start)