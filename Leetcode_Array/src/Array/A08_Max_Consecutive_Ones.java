package Array;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by happiness on 17/10/13.
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p/>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p/>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class A08_Max_Consecutive_Ones {
    public static void main(String args[]) {

        int[] nums = {1, 3, 1, 15};
        System.out.println((findMaxConsecutiveOnes(nums)));

    }


    public static int ss_findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {


        int now = 0;
        int max = 0;
        for (int n : nums) {
            // max = Math.max(max, now = n == 0 ? 0 : ++now); // ++NOW 先赋值，再使用，可以是 now + 1，不能是i++,


            max = Math.max(max, now = (n == 1 ? now + 1 : 0));

//            三元复杂表达式，还是用N + 1，避免使用N++或者++N
//            max = Math.max(max, now = (n == 1 ? ++now : 0));


            /*  解释：
            if (n == 1) now++;
            else now = 0;
            max = Math.max(max, now);



            if (n == 1) {
                now++;
            } else {
                now = 0;
            }
            max = Math.max(max, now);
            */
        }
        return max;

    }

}

