import java.util.Arrays;

/**
 * Created by happiness on 2017/8/2.
 *
 *  冒泡排序
 * Time complexity O(n * n)
 */
public class BubbleSort {

    public static void main(String args[]) {

//        int[] arr = {1, 9, 7, 8, 3, 2, 5, 4};

        int[] arr = {-1, -9, -7, -8, 3, 2, 5, 4};


        // 排序之前，遍历数组
        System.out.println("排序之前:" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Java自带排序:" + Arrays.toString(arr));


//        bubbleSort(arr);
    }

    public static void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            System.out.println("第N次外循环开始-----:" + i);

            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {   // for循环从0开始加，最终把最大或者最小的放最后面
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
                System.out.println("第N次内循环:" + j + " " + Arrays.toString(nums));
            }
        }


        System.out.println("排序之后:" + Arrays.toString(nums));

    }

    public static void bubbleSort_More(int[] nums) {


        for (int i = 0; i < nums.length-1; i++) {
            System.out.println("第N次外循环开始-----:" + i);

            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。反之进行了交换，值变为了false
            boolean flag = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {   // for循环从0开始加，最终把最大或者最小的放最后面
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = false;
                }
                System.out.println("第N次内循环:" + j + " " + Arrays.toString(nums));
            }

            if (flag){


            }

        }


        System.out.println("排序之后:" + Arrays.toString(nums));

    }

}
