package Array;

import java.util.Arrays;

/**
 * Created by happiness on 2018/10/31.
 *
 *
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

 */

public  class A14_M_Sort_Array_By_Parity {
    public static void main(String args[]) {
//        int[] arr = {6, 4, 2, 3, 5, 7, 0, 1};
        int[] arr = {3, 1, 2, 4};
        sortArrayByParity(arr);

    }

    /*
    *   自己写的，也是最佳答案
    *   当时思路：  翻转数组元素，需要一个临时变量来交换
    *
    *   Time Complexity:O(N)
    *   Space Complexity: O(1)
    *
    *
    * */
    public static  int[] sortArrayByParity(int[] A) {
        int j = 0, k = A.length - 1;
        while (j < k){
            if (A[j] % 2 == 0){
                j++;
            }else {
                int temp = A[k];
                A[k] = A[j];
                A[j] = temp;
                k--;
            }
        }
        return A;
    }
}
