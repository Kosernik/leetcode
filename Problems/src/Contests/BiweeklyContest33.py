from typing import List

class Solution:
    def thousandSeparator(self, n: int) -> str:
        parsed = str(n)
        if n >= -999 and n <= 999:
            return parsed
        for i in range(len(parsed)-3, -1, -3):
            parsed = parsed[:i] + "." + parsed[i:]

        if parsed[0] == ".":
            return parsed[1:]
        return parsed

    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        vertices = [0] * n
        result = list()

        for edge in edges:
            vertices[edge[1]] += 1

        for i in range(n):
            if vertices[i] == 0:
                result.append(i)

        return result

    def minOperations(self, nums: List[int]) -> int:
        allZeroes = True
        for i in range(len(nums)):
            if nums[i] != 0:
                allZeroes = False
        if allZeroes:
            return 0

        subs = 0
        for i in range(len(nums)):
            if nums[i] % 2 != 0:
                nums[i] -= 1
                subs += 1

        if subs > 0:
            return self.minOperations(nums) + subs

        count = 0
        odd = False
        while not odd:
            for i in range(len(nums)):
                num = nums[i] // 2
                nums[i] //= 2
                if num % 2 != 0:
                    odd = True

            count += 1

        return self.minOperations(nums) + count


sol = Solution()
