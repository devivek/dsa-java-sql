# https://leetcode.com/problems/divide-two-integers/description/
# Hard

# Let us have an example: 58/5:
# 58 = (11) * 5 + 3

# 58 = (2^3 + 2^1 + 2^0) * 5 + 3
# 58 = [(2^3 * 5) + (2^1 * 5) + (2^0 * 5)] + 3

class Solution {
    public int divide(int dividend, int divisor) {
         // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isPositive = (dividend < 0) == (divisor < 0);

        // Work with absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Initialize result
        int result = 0;

        // Perform division using bit manipulation
        while (absDividend >= absDivisor) {
            int shift = 0;
            while (absDividend >= (absDivisor << shift)) {
                shift++;
            }
            shift--; // Go back one step since the last shift exceeded absDividend
            result += (1 << shift);
            absDividend -= (absDivisor << shift);
        }

        // Return the result with the correct sign
        return isPositive ? result : -result;
    }
}