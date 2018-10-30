'''
832. Flipping an Image  转置矩阵
To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
'''
class Solution:



    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        [[1,1,0],[1,0,1],[0,0,0]]

        Time Complexity:
		O(N^2)
		思路： 两次循环，外循环取出每一行，内循环先前后翻转，再自己取反
        """
        return [[1 ^ i for i in row[::-1]] for row in A ]


        	
s = Solution() 

A = [[1,1,0],[1,0,1],[0,0,0]]
print( str(s.flipAndInvertImage(A)))