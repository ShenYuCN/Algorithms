package sort;
import java.util.Arrays;

/**
 * Created by happiness on 2017/8/2.
 * <p/>
 * 冒泡排序  两两比较相邻元素
 * Time complexity O(n * n)
 */
public class BubbleSort {

    public static void main(String args[]) {

//        int[] arr = {6, 4, 1, 8, 7, 3};

        int[] arr = {2,1,0,3,4,5,6,7};


        // 排序之前，遍历数组
//        System.out.println("排序之前:" + Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println("Java自带排序:" + Arrays.toString(arr));

//        bubble_one(arr);
        bubble_two(arr);  // 正宗冒泡
//        bubble_three(arr);
    }


    /**
     *
     *  冒泡排序思想，相邻的比较，小的往上飘
     *  n-1,n-2,n-3....1
     *
     *  和 第一种方法类似，只是第二层循环一个是从后往前一个是从前往后
     *   Time  complexity:
     *   Space complexity:
    */
    public static void bubble_two(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println(" \n 外 开始-----:" + i + Arrays.toString(nums));

            for (int j = nums.length - 1; j > i; j--) { // for循环从后面开始加，最终把最小的放最前面:  这里仅仅控制排序是从小到大还是从大到小
                if (nums[j] > nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
                System.out.println("第N次内循环:" + nums[j] +" : " + nums[j -1]+ "\n " + Arrays.toString(nums));
            }
        }


        System.out.println("排序之后:" + Arrays.toString(nums));


    }

    /**
     *
     *  冒泡排序思想优化
     *   Time  complexity:
     *   Space complexity:
     *
     *   类似  [2,1,0,3,4,5,6,7}]
     */
    public static void bubble_three(int[] nums) {

        Boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {

            flag = false;    // 初始化为 false
            for (int j = nums.length - 1; j > i; j--) {  // for循环从后面开始加，最终把最小的放最前面
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;

                    flag = true;   // 当有交换，则flag为true
                }
            }

            // 若一直没有交换，说明已经是有序的了，则flag一直为false，退出循环
        }


        System.out.println("排序之后:" + Arrays.toString(nums));


    }

    /**
     * 选择排序
     * <p/>
     * n-1,n-2,n-3....1
     * Time  complexity:
     * Space complexity:
     */
    public static void bubble_one(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println("第N次外循环开始-----:" + i);

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {   // 注意和冒泡排序的区别，这里是i和j比较。
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                System.out.println("第N次内循环:" + j + " " + Arrays.toString(nums));
            }
        }


        System.out.println("排序之后:" + Arrays.toString(nums));

    }




}
