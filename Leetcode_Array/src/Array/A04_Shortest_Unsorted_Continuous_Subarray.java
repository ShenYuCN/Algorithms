package Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by happiness on 17/9/18.
 * <p/>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * <p/>
 * You need to find the shortest such subarray and output its length.
 * <p/>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 *
 *
 * 这个题注意特殊情况， 数组元素只有一个，或者已经是升序的数组
 */
public class A04_Shortest_Unsorted_Continuous_Subarray {

	public static void main(String args[]) {

//        int[] ss = {1,2,3,4};
//		int[] ss = {2, 1};

        int[] ss = {2,6,4,8,3,11,10,9,15};
//        System.out.println(findUnsortedSubarray(ss));
//        System.out.println(useStack(ss));
//        System.out.println(findUnsortedSubarray_2(ss));
//		System.out.println(best(ss));
        System.out.println(findUnsortedSubarray(ss));


	}
    /*
    * I use the variables beg and end to keep track of minimum subarray A[beg...end]
    * which must be sorted for the entire array A to be sorted.
    * If end < beg < 0 at the end of the for loop, then the array is already fully sorted.
    * */
    public static  int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            System.out.println("max:  "  + max  + "   A[i]   " + i + " " + A[i]);
            System.out.println("min:  "  + min  + "   A[n-1-i]   " + (n-1-i) + " " + A[n-1-i]);

            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

	/**
	 * 正常情况下是升序，从左往右，如果后面的比前面的小，那么就出现了异常
	 * 从右往左，如果前面的比后面的大，也出现了异常
	 * 找出异常区间的最大最小值
	 * 然后分别从前遍历得到异常最小坐标，从后遍历得到异常最大坐标
	 * <p/>
	 * <p/>
	 * Time  complexity:O(n)  Four O(n) loops are used.
	 * Space complexity:O(1)
	 */

	public static int best(int[] nums) {

			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			boolean flag = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1])
					flag = true;
				if (flag)
					min = Math.min(min, nums[i + 1]);

			}

			flag = false;
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[i] < nums[i - 1])
					flag = true;
				if (flag)
					max = Math.max(max, nums[i - 1]);
			}


			int l, r;
			for (l = 0; l < nums.length; l++) {
				if (nums[l] > min)
					break;
			}

			for (r = nums.length - 1; r >= 0; r--) {
				if (nums[r] < max)
					break;
			}

//            System.out.println("******");   这里如果是 1 2 3 4
//            System.out.println(l);    l = 4
//            System.out.println(r);    r = -1  所以不能打印 nums[r]  nums[l]
			return r - l < 0 ? 0 : r - l + 1;
	}


	/**
	 * 利用排序
	 * <p/>
	 * Time  complexity: O(nlogn)
	 * Space complexity: O(n) We are making copy of original array.
	 */
	public static int useSort(int[] nums) {
		int[] onums = nums.clone();
		Arrays.sort(nums);
		int end = 0, start = nums.length;

		for (int i = 0; i < nums.length; i++) {

			if (onums[i] != nums[i]) {

				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}

//		 考虑 输入数组length为1的情况
		return end - start == -nums.length ? 0 : end - start + 1;

    }


	/**
	 * Brute Force [Time Limit Exceeded]
	 * <p/>
	 * Time  complexity: O(n2)
	 * Space complexity: O(1) Constant space is used.
	 */
	public static int findUnsortedSubarray_bubble(int[] nums) {


		int h = 0, l = nums.length;
		for (int i = 0; i < nums.length - 1; i++) {

			for (int k = i + 1; k < nums.length; k++) {

				if (nums[i] > nums[k]) {
					l = Math.min(l, i);
					h = Math.max(h, k);
				}
			}
		}
		return h - l == -nums.length ? 0 : h - l + 1;
	}


	/**
	 *  使用栈
	 *
	 *
	 *   Time  complexity:  O(n) Stack of size
	 *   Space complexity: O(n). Stack size grows upto n
	*/
	public static int useStack(int[] nums) {


		Stack<Integer> stack = new Stack<Integer>();
		int l = nums.length, r = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
				l = Math.min(l, stack.pop());
			stack.push(i);
		}

		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
				r = Math.max(r, stack.pop());
			stack.push(i);
		}
		return r - l > 0 ? r - l + 1 : 0;

	}

}
