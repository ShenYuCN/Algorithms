import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by happiness on 17/11/30.
 *
 *
 *
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]


 */
public class A09_Find_All_Numbers_Disappeared_in_an_Array {

    public  static  void  main(String args[]){
        int[] arr = {4,3,2,7,8,2,3,1};

//        System.out.print(sy_findDisappearedNumbers(arr).toString());
//        System.out.print(aa(arr).toString());
        System.out.print(bb(arr).toString());


    }
    /**
     *
     *  个人思路： 利用map.contaionsKey方法---->>>>>这种新建了map开辟了新的内存，严格来讲不符合题目要求
     *
     *  1.将原数组转成map,数组的值作为key
     *  2.遍历数组，看是否contaionsKey，不是则加入list
     *
     *   Time  complexity:
     *   Space complexity:
    */
    public  static List<Integer> sy_findDisappearedNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {   // 注意这里遍历的 key  为 i （1，2，3，4，5，，，）
                res.add(i);
            }

        }


        return res;
    }

    /**
     *   所有的操作只有对于数组元素值取反。没有对于元素值加减
     *
     *
     *   Time  complexity: O(n)
     *   Space complexity:
    */
    public  static  List<Integer> aa(int[] nums){
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]) - 1; // 这里因为数组元素为1 ~ n,而index值为0 ~ n-1,为了保证不越界，要减1.
            // 同时因为之后对于元素值取反，因此要取绝对值减1

            if (nums[value] > 0){ // 如果原元素出现过取反，（一个元素可能多次出现），最终目的是出现过的为负值，未出现过的为正值
                nums[value] = -nums[value];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 ) res.add(i+1); // 这里因为之前对于Index值是元素值减1，这里要返回原先的元素值，故而要加1
        }
        return res;
    }


    public static List<Integer> bb(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;
    }
}

