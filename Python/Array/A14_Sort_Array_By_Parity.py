"""
* 给定整数数组A，要求将A中元素重排，使得所有偶数元素在前，奇数元素在后。
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


 Note:

 1 <= A.length <= 5000
 0 <= A[i] <= 5000
"""
def m_sortArrayByParity(A):
    """
    :type A: List[int]
    :rtype: List[int]
    """
    j = 0
    k = len(A) - 1
    while j < k:
    	if A[j] % 2 != 0:
    		A[j], A[k] = A[k], A[j]
    		k -= 1
    	else:
    		j += 1
    return A 


arr = [3,2,1,4]
print(m_sortArrayByParity(arr))
