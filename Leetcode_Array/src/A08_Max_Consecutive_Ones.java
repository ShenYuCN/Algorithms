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
//        System.out.println((kdiff(nums, 2)));
        System.out.println((findMaxConsecutiveOnes(nums)));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        Map<Integer,Integer> map  = new HashMap<>();

        int now = 0;
        int max = 0;
        for (int n:nums){
            max = Math.max(max,now = n == 0 ? 0 : ++now); // ++NOW 先赋值，再使用，不能是i++,或者是 now + 1
            max = Math.max(max,now = n == 1 ? now + 1: 0);

            /*  解释：
            if (n == 1) now++;
            else now = 0;
            res = Math.max(max,now);
            */
        }
        return max;


    }

}
