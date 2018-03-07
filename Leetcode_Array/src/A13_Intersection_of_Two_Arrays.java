import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by happiness on 18/3/7.
 *
 *
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 */
public class A13_Intersection_of_Two_Arrays {
    public static void main(String args[]) {
//        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        System.out.println(sy(arr));
//        excellent_solution(arr);
//        so_2(arr);
        int[] nums1 = {2,3,4,5};
        int[] nums2 = {3,4,6};
        int[] res = intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
    public  static  int[] intersection(int[] nums1, int[] nums2) {

//        List<Integer>  list = new LinkedList<>(); // 不用链表，防止加入重复元素
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int x = 0, y = 0;
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] == nums2[y]) {
                set.add(nums1[x]);
                x++;
                y++;
            } else if (nums1[x] > nums2[y]) {
                y++;
            } else if (nums1[x] < nums2[y]) {
                x++;
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
       for (int num : set){
           res[k++] = num;
       }
        return res;
    }
}


