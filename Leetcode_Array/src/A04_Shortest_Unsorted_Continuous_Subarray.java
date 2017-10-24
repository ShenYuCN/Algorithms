import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by happiness on 17/9/18.
 * <p/>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * <p/>
 * You need to find the shortest such subarray and output its length.
 * <p/>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 *
 *
 * 这个题注意特殊情况， 数组元素只有一个，或者已经是升序的数组
 */
public class A04_Shortest_Unsorted_Continuous_Subarray {

    public static void main(String args[]) {

//        int[] ss = {1,2,3,4};
//        int[] ss = {2, 6, 4, 8, 10, 9, 15};
//        int[] ss = {2,3,3,2,4};
//        int[] ss = {1, 4, 2, 5, 3};

//        int[] ss = {1, 3, 5, 2, 4};
        int[] ss = {2,6,4,8,10,9,15};
//        System.out.println(findUnsortedSubarray(ss));
//        System.out.println(useStack(ss));
//        System.out.println(findUnsortedSubarray_2(ss));
        System.out.println(four(ss));
    }


    /**
     * Brute Force [Time Limit Exceeded]
     * <p/>
     * Time  complexity: O(n2)
     * Space complexity: O(1) Constant space is used.
     */
    public static int findUnsortedSubarray_bubble(int[] nums) {


        int h = 0, l = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {

            for (int k = i + 1; k < nums.length; k++) {

                if (nums[i] > nums[k]) {
                    l = Math.min(l, i);
                    h = Math.max(h, k);
                }
            }
        }
        return h - l == -nums.length ? 0 : h - l + 1;
    }

    /**
     * 利用排序
     * <p/>
     * Time  complexity: O(nlogn)
     * Space complexity: O(n) We are making copy of original array.
     */
    public static int useSort(int[] nums) {
        int[] onums = nums.clone();
        Arrays.sort(nums);
        int end = 0, start = nums.length;

        for (int i = 0; i < nums.length; i++) {

            if (onums[i] != nums[i]) {

                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        // 考虑 输入数组length为1的情况
        return end - start == -nums.length ? 0 : end - start + 1;
    }


    /**
     *  使用栈
     *
     *
     *   Time  complexity:  O(n) Stack of size
     *   Space complexity: O(n). Stack size grows upto n
    */
    public static int useStack(int[] nums) {


        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;

    }

    /**
     * 这种方法先将最大最小值取出来
     * 然后分别从前遍历最小坐标，从后遍历最大坐标
     * <p/>
     * <p/>
     * Time  complexity:O(n)  Four O(n) loops are used.
     * Space complexity:O(1)
     */

    public static int four(int[] nums) {


        if (nums.length == 1) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i + 1]);

        }

        flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i - 1]);
        }

        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min)
                break;
        }

        for (r = nums.length - 1; r >= 0; r--) {
            if (nums[r] < max)
                break;
        }

        return r - l +1;

    }
}
