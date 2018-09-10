'''
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:
'''
class Solution:
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        now = 0;res = 0
        for num in nums:
        	if num == 1:
        		now += 1
        	else:
        		now = 0
        	res = max(now,res)
        return res

    def findMaxConsecutiveOnes_2(self, nums):
    	'''
    	思路：(''.join(map(str,nums))) 整形列表转字符串
    	字符串用.split函数分割成数组

    	或者
        return max(map(lambda x: len(x), ''.join([str(num) for num in nums]).split('0')))

    	'''
        a = (''.join(map(str,nums))).split('0')
        return max(map(len,a))


    def findMaxConsecutiveOnes_3(self, nums):
    	'''
		transform the input, like
		[0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1], to
		[0, 1, 2, 3, 0, 1, 2, 0, 0, 1, 2, 3, 4], and the max element would be the result.
    	'''
        for i in range(1, len(nums)):
            if nums[i]:
                nums[i] += nums[i - 1]
        return max(nums)




so = Solution()
nums = [1,1,0,1,1,1]
print(so.findMaxConsecutiveOnes(nums))