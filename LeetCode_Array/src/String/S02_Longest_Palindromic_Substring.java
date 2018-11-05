package String;

/**
 * Created by happiness on 2018/11/1.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 最大回文字字串
 */



public class S02_Longest_Palindromic_Substring {
    public static  void main(String args[]) {
//        String str = "babad";
        String str = "acdehgghedad";
        System.out.println(longestPalindrome(str));

    }
    public  static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);


            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            System.out.println("len" + len + "  start " + start + " end " + end);

        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
