import java.util.Arrays;

/**
 * Created by happiness on 2018/8/16.
 *
 *
 *
 *
    数组拆分
 Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

 最小：Sm = min(a1,b1)+....+ min(an+bn)
 数组之和： Sa = a1+b1+ ... + an + bn
 假设差值:  d1 = b1-a1   Sd = d1 +....+ dn
 Sa = b1 - a1 + 2a1  + .....  + bn - an + 2an
    =  Sd + 2Sm

 Sm = (Sa - Sd)/2

 Sa 确定，Sd最小则Sm最大， 排序后相邻2元素差值最小


 */
public class A16_Array_Partition_I {

    public static void main(String args[]) {
//        int[] arr = {6, 4, 2, 3, 5, 7, 0, 1};
        int[] arr =  {1,4,3,2};



            System.out.println(S_arrayPairSum(arr));


    }

    /*
    *   Time Complexity:O(N) N是A的元素数量
    *   Space Complexity: O(1)
    *
    * */
    public  static int S_arrayPairSum(int[] nums) {

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i=i+2){
            res += nums[i];
        }

        return res;
    }
}
