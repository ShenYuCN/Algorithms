package sort;
import java.util.Arrays;

/**
 * Created by happiness on 2017/8/2.
 * 快速排序
 *
 *
 *
 * 快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要Ο(n log n)次比较。
 * 在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。
 * 事实上，快速排序通常明显比其他Ο(n log n) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来，
 * 且在大部分真实世界的数据，可以决定设计的选择，减少所需时间的二次方项之可能性。

 步骤：

 1。从数列中挑出一个元素，称为 “基准”（pivot），
 2。重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 3。递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序


 *  Time complexity O(nLogn)
 */
public class QuickSort {

        public static  int partition(int[] sortArray, int low, int high) {
            System.out.println("\n" + "low:" + low + "  high:" + high);

            int key = sortArray[low];   // 刚开始以第一个数为标志数据
            while (low < high) {
                while (low < high && sortArray[high] >= key)
                    high--;                                       // 从后面开始找，找到比key值小的数为止

                sortArray[low] = sortArray[high];                   // 将该数放到key值的左边


                while (low < high && sortArray[low] <= key)
                    low++;                                           // 从前面开始找，找到比key值大的数为止

                sortArray[high] = sortArray[low];                 // 将该数放到key值的右边

            }

            sortArray[low] = key;                                   // 把key值填充到low位置，下次重新找key值


            System.out.println(Arrays.toString(sortArray) + "排序后 key所在的位置index " + low);
            return low;
        }


        public  static void mySort(int[] sortArray, int low, int high) {
            if (low < high) {
                int result = partition(sortArray, low, high);
                mySort(sortArray, low, result - 1);
                mySort(sortArray, result + 1, high);
            }
        }

        public static void main(String[] args) {
            QuickSort quickSort = new QuickSort();
//            int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
            int[] array = { 5, 1, 7, 8, 2, 3, 6, 4, 9 };
//            int[] array = { 5, 4,3,2,1 };

            System.out.println("before" + Arrays.toString(array));

            quickSort.mySort(array, 0, array.length - 1);

            System.out.println("after" + Arrays.toString(array));

        }
    }

