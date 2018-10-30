import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by happiness on 17/11/30.
 * <p/>
 * <p/>
 * <p/>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p/>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p/>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * 这里，题目说使用list可以视为不开辟内存空间
 *
 *
 * Example:
 * <p/>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p/>
 * Output:
 * [5,6]
 */
public class A09_Find_All_Numbers_Disappeared_in_an_Array {

    public static void main(String args[]) {
//        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] arr = {1,2,2,3,3,4, 7, 8};
//        int[] arr = {1,2,3,4, 5,6,7, 8};

//        System.out.print(sy_findDisappearedNumbers(arr).toString());
        System.out.print(best(arr).toString());
//        System.out.print(bb(arr).toString());


    }
    /**
     * 所有的操作只有对于数组元素值取反。没有对于元素值加减
     * <p/>
     * <p/>
     * Time  complexity: O(n)
     * Space complexity:
     */
    public static List<Integer> best(int[] nums) {
        System.out.println(Arrays.toString(nums));
//
//        List<Integer> res = new ArrayList<Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//          // 数组长度为n，数组中元素的取值范围为[1, n]，数组index范围为[0, n - 1]。
//            // 也就是说如果数组元素没有重复，那么对于每个元素k，都对应一个index k-1.
//            // 因此我们可以利用这个性质，将出现的元素所对应的index上面的元素置负，用来表示该index所对应的元素存在 index + 1
//            int index = Math.abs(nums[i]) - 1;
//
//            System.out.println("index= " +index + "  nums[index]=  " + nums[index] );
//
//            if (nums[index] > 0) { // 如果原元素出现过取反，（一个元素可能多次出现,第二次以后出现不做处理，保持原来的正值）
//                nums[index] = -nums[index];
//                System.out.println("  change ->      nums[index]   " + nums[index] );
//            }else {
//                System.out.println("  not change - >   nums[index]   " + nums[index] );
//
//            }
//        }
//
//        System.out.println(Arrays.toString(nums));
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) res.add(i + 1); // 这里因为之前对于Index值是元素值减1，这里要返回原先的元素值，故而要加1
//        }


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0){
                nums[index] = - nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) res.add(i + 1);
        }


        return res;
    }
    /**
     * 个人思路： 利用map.contaionsKey方法---->>>>>这种新建了map开辟了新的内存，严格来讲不符合题目要求
     * <p/>
     * 1.将原数组转成map,数组的值作为key
     * 2.遍历数组，看是否contaionsKey，不是则加入list
     * <p/>
     * Time  complexity:
     * Space complexity:
     */
    public static List<Integer> sy_findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {   // 注意这里遍历的 key  为 i （1，2，3，4，5，，，）
                res.add(i);
            }

        }


        return res;
    }




    public static List<Integer> bb(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i < nums.length; i++) if (nums[i] <= n) res.add(i + 1);
        return res;
    }
}

