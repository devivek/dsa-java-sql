# Problem : https://leetcode.com/problems/zigzag-conversion/
# Difficulty: Medium
# Company Tags : Flipkart

class Solution:
    
    # Approach 1
        # Time complexity: O(n)
        # n is the length of the string s
        # Space complexity: O(1) -> no additional space is requred except storing the result --> O(n)
    
    def convert(self, s: str, numRows: int) -> str:
        # numRows = 3; cycle = 4;
        cycleLength = numRows * 2 - 2
        if(cycleLength == 0 or numRows >= len(s)):
            return s
        result = []
        for i in range(0, numRows, 1):
            # result += ' | '
            for j in range(0, len(s), cycleLength):
                index = j + i;
                if(index < len(s)):
                    result.append(s[index]) 
                headOfCycle = index - (index % cycleLength)
                endOfCycle = headOfCycle + cycleLength -1
                distanceFromHeadOfCycle = index - headOfCycle
                newIndex = endOfCycle - distanceFromHeadOfCycle + 1
                if(i != 0 and i != numRows-1  and  (cycleLength>numRows) and (newIndex) < len(s)):
                    result.append(s[newIndex])
                
        return ''.join(result)
    
    # Approach 2
        # use list of list
        # time : O(N)
        # space : O(N)
    def convert2(self, s: str, numRows: int) -> str:
        if(numRows == 1 or numRows >= len(s)):
            return s
        dir = 1
        i = 0
        res = [[] for _ in range(0, numRows, 1)]

        for char in s:
            res[i].append(char)
            # handle the direction
            if(i == 0):
                dir = 1
            elif(i == numRows-1):
                dir = -1
            i += dir
        
        for idx in range(0, numRows, 1):
            res[idx] = ''.join(res[idx])
        
        return ''.join(res)


# test cases
s = Solution()
print(s.convert("PAYPALISHIRING", 4))  # Output: "PIN ALSIG YAHR PI"
