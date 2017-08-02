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
 */
public class Maximum_Product_of_ThreeNumbers {

    public static void main(String args[]) {

        int[] ss = {1,3,2,4};

        System.out.println("maximumProduct:" + maximumProduct(ss));
    }

    public static  int maximumProduct(int[] nums) {


       for (int i = 0; i < nums.length; i++){

            if (nums[i] > nums[i + 1]){

                int tmp = nums[i + 1];
                nums[i] = nums[i + 1];
                nums[i +1] = nums[i];
            }

       }



        for (int i = 0; i < nums.length; i++){

            System.out.println("nums:" + i + " " + nums[i]);

        }

        return nums[0] * nums[1] * nums[2];

    }

}
