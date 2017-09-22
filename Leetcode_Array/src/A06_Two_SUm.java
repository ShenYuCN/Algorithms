import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by happiness on 17/9/22.
 * <p/>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class A06_Two_Sum {
    public static void main(String args[]) {

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(s_twoSum(nums, 9)));
        System.out.println(Arrays.toString(hashTable(nums, 9)));

    }

    /**
     *   Brute Force
     *
     *
     *   Time  complexity: O(n2)
     *   Space complexity: O(1)
    */
    public static int[] s_twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }


    /**
     *
     *      Hash Table
     *
     *   Time  complexity:O(n)
     *   Space complexity:O(n)
    */
    public  static  int[] hashTable(int[]nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && i != map.get(complement)){
                return new  int[] {i,map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}
