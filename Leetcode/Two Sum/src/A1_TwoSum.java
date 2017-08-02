/**
 * Created by ShenYu on 2017/3/7.
 * 给一个数组和一个值，求数组中2个元素的位置，使之这两个元素的和为这个值
 */
public class A1_TwoSum {
    public static  void  main(String args[]){

        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /**
     * 遍历
     * 时间复杂度 O(n2）
     * 空间复杂度O(1)
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j)
                if((nums[i] + nums[j])==target){
                    return new int[]{i,j};
                }
        }
        throw new IllegalArgumentException("Oh,No Solution");
    }
}
