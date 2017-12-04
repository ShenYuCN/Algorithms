/**
 * Created by happiness on 17/12/1.
 *
 *
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.

 */


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 *     题目要求是  O(n) 时间复杂度
*/
public class A10_Third_Maximum_Number {
    public static void  main(String args[]){
//        int[] nums = {5,4,3,4};
//        int[] nums = {1,1,2};
        int[] nums = {1,2};
//        int[] nums = {1,2,-2147483648};  // -2147483648

        System.out.print(excellent_solution(nums));
//        System.out.print(Integer.MIN_VALUE);
    }



    public static int excellent_solution(int[] nums) {

//   使用这个方法无需对于三个以内单独处理，因为三个以内，肯定会只是一个值，那就可以认为是max1,两个值同理有max1
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        Integer max1 = null;  // 不能将null赋值给int，要赋值给Integer
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums){

            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;   // null 判断要用 equal

            if ( max1 == null || n > max1 ){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if ( max2 == null || n > max2){
                max3 = max2;
                max2 = n;
            }else if (max3 == null || n> max3){
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }


    public static int solution_Two (int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.add(n)) {
                pq.offer(n);
                if(pq.size() > 3 ) pq.poll();
            }
        }
        if(pq.size() == 2) pq.poll();
        return pq.peek();
    }
    /**
     *
     *   这个方法有个缺陷是默认最低为 Integer.MIN_VALUE
     *   当原数组中包含Integer.MIN_VALUE时则会返回错误
     *
     *   修正之后参考方法 excellent_solution
     *
     *   Time  complexity:
     *   Space complexity:
    */
    public static int aa(int[] nums) {


        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int n : nums){
            if (n == max1 || n == max2 || n == max3) continue;

            if (n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if (n > max2){
                max3 = max2;
                max2 = n;
            }else if (n > max3){
                max3 = n;
            }
        }
        return max3 == Integer.MIN_VALUE ? max1 : max3;
    }

    /**
     *   .....max3,max2,max1
     *
     *    这个方法可以找到最大的三个数，时间复杂度为  O(n)，只遍历一次，不排序
     *    3，2，1，2  取出值为 3，2，2 没有做重复校验
     */
    public static int third_Max_Num(int[] nums) {


        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int n : nums){
            if (n >= max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if (n >= max2){
                max3 = max2;
                max2 = n;
            }else if (n >= max3){
                max3 = n;
            }
        }
        return max3;
    }
}


