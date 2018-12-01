package String;

/**
 * Created by happiness on 2018/11/6.
 *
 *
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:

 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:

 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:

 The input string length won't exceed 1000.

 回文字串的数量

 */

public class S03_Palindromic_Substrings {

    public static void main(String args[]) {

//        String str = "abc";
//        String str = "acdehgghedad";
        String str = "aaa";
        System.out.println(countSubstrings(str));


    }



    /////////////////////////  方法一 start   类似S02， 逐步遍历   //////////////////////////////////////////////
    /*
    *   从左从最中间往两边遍历
    *
    *   Time complexity: O(N*N)
    *   Space Complexity: O(1)
    * */

    static int mCount = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);

        }

        return mCount;
    }

    public  static void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            mCount++;
            left--;
            right++;
        }
    }
}
