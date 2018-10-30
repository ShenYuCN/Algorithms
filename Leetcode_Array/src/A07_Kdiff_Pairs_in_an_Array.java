import com.sun.tools.javac.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by happiness on 17/10/10.
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.

 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).
 Note:
 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].

 */
public class A07_Kdiff_Pairs_in_an_Array {

    public static void main(String args[]) {

//        int[] nums = {1, 3, 1, 15};
        int[] nums = {3, 1, 4, 1, 5};
//        System.out.println((kdiff(nums, 2)));
//        System.out.println((kdiff(nums, 0)));

        System.out.println((findPairs(nums, 1)));

    }

    /**
     *  更容易理解
     *  map： key为元素，值为1（相同的key的话值会增加 >=2，getOrDefault）
     *
     *
     *   Time  complexity: O(n)
     *   Space complexity:
     */
    public static  int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // {3, 1, 4, 1, 5}  --》 {1=2, 3=1, 4=1, 5=1}
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }


        return count;
    }


    public  static  int  kdiff(int[] nums,int k){
        if ( k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums)
            map.put(num, i++);
        System.out.print("map:"+ map.toString() + "\n");

        int res = 0;
        for (i = 0; i < nums.length; i++) {


            // map.get(nums[i] + k) != i 是为了避免K=0，即找相同数的情况
            // 当存在相同的key时，map会将后面的key替换前面相同的key，从而导致位置上key不变但是value向后位移
            // 正常情况下，K为0时，map.get(nums[i] + k) == i，因为他们是对应的关系，但是这种关系只是一个单体个体值，不能满足pairs要求
            if (map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
                map.remove(nums[i] + k);
                res++;
            }
        }
        return res;


    }

}
