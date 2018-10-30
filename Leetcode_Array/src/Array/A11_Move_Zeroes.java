package Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by happiness on 17/12/4.
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.


 重点：不能copy array


 */
public class A11_Move_Zeroes {
    public static void  main(String args[]){
        int[] arr = {0,1,0,3,12};
//        sy(arr);
        excellent_solution(arr);
//        so_2(arr);
    }

    public  static  void excellent_solution(int[] nums){

        int newIndex = 0;
        for (int num : nums){
            if (num != 0) nums[newIndex++] = num;
        }
        System.out.println(newIndex);

        while (newIndex < nums.length){
            nums[newIndex ++] = 0;
        }

        //  或者执行下面的遍历
//        for (int i = newIndex; i < nums.length; i++){
//            nums[i] = 0;
//        }
    }


    /**
     *   相当于两个数组
     *   [1,3,0,5]
     *   新的数组j从0开始取值，如果不为0则加入新数组，
     *
     *
     *   Time  complexity:
     *   Space complexity:
    */
    public static void  so_2(int[] nums){
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
    public static void  sy(int[] nums){

        Queue<Integer> queue = new LinkedList<Integer>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                queue.offer(nums[i]);
                index++;
            }
        }

        for (int i = 0; i < nums.length;i++){
            if (i < index){
                nums[i] = queue.poll();
            }else {
                nums[i] = 0;
            }

        }

    }
}
