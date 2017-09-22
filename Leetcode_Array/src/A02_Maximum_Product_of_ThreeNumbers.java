import java.util.Arrays;

/**
 * Created by happiness on 2017/8/2.
 *
 *
 *
 * 628

 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24


 iterative | BrE ˈɪt(ə)rətɪv, AmE ˈɪdəˌreɪdɪv, ˈɪdərədɪv |
 adjective
 迭代的
 */
public class A02_Maximum_Product_of_ThreeNumbers {

    public static void main(String args[]) {

        int[] ss = {1,3,2,4};

        System.out.println("maximumProduct:" + maxProduct(ss));
        //        System.out.println("javaSort:" + javaSort(ss));

    }


    /**
    *
    *  sort 方法为快速排序
    *
    *   Time  complexity: O(nlog2)
    *   Space complexity: O(log(n))
    */
     public static  int javaSort(int[] nums) {

        Arrays.sort(nums);
        // 考虑负整数的情况
        return Math.max(nums[0] * nums[1] * nums[nums.length-1], nums[nums.length-1] * nums[nums.length -2]* nums[nums.length-3]);

    }





    /**
    *
    *  min1,min2    ******   max3, max2,max1
    *
    *   Time  complexity: O(n)
    *   Space complexity: O(1)
    */
     public static int maxProduct(int[] nums) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            }else if(x < min2) {         // x lies between min1 and min2
                min2 = x;
            }


            

            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2){        // x lies betweeen max1 and max2
                max3 = max2;
                max2 = x;
            }else if(x > max3){          // x lies betwen max2 and max3
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }

}
