/**
 * Created by happiness on 2017/7/29.
 */
public class Maximum_Average_Subarray_I {


    public static void main(String args[]) {

        int[] ss = {1, 12, -5, -6, 50, 3};

        System.out.println("BruteForce:" + BruteForce(ss, 4));


        System.out.println("CumulativeSum:" + CumulativeSum(ss,4));
    }

    /*
    *
    *  Time complexity   O(k * n)
    *  Space complexity O(1)
    *
    * */
    public static double BruteForce(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            res = Math.max(res, sum / k);
//            System.out.println("sum/k:" + sum/k);
//            System.out.println("res:" + res);

        }
        return res;

    }

    /*
       *
       *  Time complexity   O( n)
       *  Space complexity O(n)
       *
       * */
    public static double CumulativeSum(int[] nums, int k) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] += nums[i] + sum[i - 1];
        }

        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (nums[i] - nums[i - k]) * 1.0 / k);
        }
        return res;


    }


}
