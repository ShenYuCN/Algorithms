import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by happiness on 17/12/4.
 * <p/>
 * <p/>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p/>
 * Example 1
 * <p/>
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * <p/>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p/>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p/>
 * 关键点：不使用多余空间
 * 时间复杂度为为线性的
 */
public class A12_Missing_Number {
    public static void main(String args[]) {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(sy(arr));
//        excellent_solution(arr);
//        so_2(arr);
    }


    /**
     * 思路，使用排序，然后对比
     * <p/>
     * <p/>
     * Time  complexity: O(nlgn)
     * Space complexity: O(1)or O(N) .  In the sample code, we sorted nums in place,
     * allowing us to avoid allocating additional space.
     * If modifying nums is forbidden, we can allocate an O(n) size copy and sort that instead.
     */
    public static int sy(int[] nums) {

        Arrays.sort(nums);

        //Ensure that n is at the last index.  0 is at the first index
        if (nums[nums.length - 1] != nums.length) return nums.length;
        if (nums[0] != 0) return 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return -1;

    }

    /**
     * 使用hashSet
     * <p/>
     * <p/>
     * Time  complexity: O(n)
     * Space complexity: O(n).nums contains n−1 distinct elements,
     * so it costs  O(n) space to store a set containing all of them.
     */
    public static int so_2(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length + 1;i++){
            if (!set.contains(i)) return i;
        }

        return  -1;

    }

    public static void excellent_solution(int[] nums) {

        int newIndex = 0;
        for (int num : nums) {
            if (num != 0) nums[newIndex++] = num;
        }
        while (newIndex < nums.length) {
            nums[newIndex++] = 0;
        }
    }

}
