# https://leetcode.com/problems/divide-two-integers/description/
# Hard

# Let us have an example: 58/5:
# 58 = (11) * 5 + 3

# 58 = (2^3 + 2^1 + 2^0) * 5 + 3
# 58 = [(2^3 * 5) + (2^1 * 5) + (2^0 * 5)] + 3

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        isPositive: bool = (dividend<0) == (divisor<0)
        dividend = abs(dividend)
        divisor = abs(divisor)
        
        if divisor > dividend:
            return 0
        if divisor == dividend:
            return 1 if isPositive else -1
        if divisor == 1:
            return dividend if isPositive else -1 * dividend
        
        i = 0
        while (divisor << (i+1)) < dividend:
            i += 1
        result = 2**i + self.divide(dividend - (divisor << i), divisor)
        return result if isPositive else -1 * result