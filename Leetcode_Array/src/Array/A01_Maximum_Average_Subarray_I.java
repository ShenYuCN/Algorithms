package Array;
/**
 * Created by happiness on 2017/7/29.
 *
 *
 *
 *
 *
 * 643
 Given an array consisting of n integers, find the contiguous subarray of given length k
 that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75



 */
public class A01_Maximum_Average_Subarray_I {


    public static void main(String args[]) {

        int[] ss = {1, 12, -5, -6, 50, 3};

//        System.out.println("BruteForce:" + BruteForce(ss, 4));
        System.out.println("CumulativeSum:" + CumulativeSum(ss,4));
//        System.out.println("slidingWindow:" + slidingWindow(ss,4));
    }

    /*
    *
    *  Time complexity   O(n)
    *  Space complexity O(1)
    *
    *  累加新的一组四个数和时，加第5个数，减第1个数
    * */
    public  static  double slidingWindow(int[] nums,int k){
        int sum = 0;
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }

        double res = Integer.MIN_VALUE;
        for (int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i - k];
            res = Math.max(sum,res);
        }
        return res/k;
    }

    /*
     *
     *  Time complexity   O(n)
     *  Space complexity O(n)
     *
     *   建一个新的数组，长度和原数组一样，每个元素为之前 n 个数的和
     *
     *
     * */
    public static double CumulativeSum(int[] nums, int k) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }


        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;

    }



    /*
    *
    *  Time complexity   O(k * n)
    *  Space complexity O(1)
    *
    *  遍历n-k 次，每次计算k个数的和
    * */
    public static double BruteForce(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            res = Math.max(res, sum / k);

        }
        return res;

    }




}
