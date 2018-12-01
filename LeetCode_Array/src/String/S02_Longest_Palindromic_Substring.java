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

 最大回文字字串<最长回文字串>

 */



public class S02_Longest_Palindromic_Substring {
    public  static void main(String args[]) {
//        String str = "babad";
        String str = "acdehgghedad";
        System.out.println(longestPalindrome(str));
        System.out.println(Manacher(str));


    }
    /////////////////////////  方法一 start  //////////////////////////////////////////////
    /*
    *   从左往右遍历字符，再以这个字符作为回文对称轴向两边扩展
    *
    *   Time complexity: O(N*N)
    *   Space Complexity: O(1)
    * */
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

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) { // 这里最后一次跳出循环时已经左右各扩一个字符了
            L--;
            R++;
        }
        // 这里减一 因为上面已经扩了
        return R - L - 1;
    }
    /////////////////////////  方法一  end //////////////////////////////////////////////



    /*
    *   动态规划
    *
    *   Time complexity: O(N*N*N)
    *   java7 之前 substring 的复杂度为O(1)，之后为O(N)
    *   Space Complexity: O(1)
    * */
    public static String dynamicProgramming(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

//    public int longestPalindrome(String s) {
//        int n=s.length();
//        boolean[][] pal=new boolean[n][n];
//        //pal[i][j] 表示s[i...j]是否是回文串
//        int maxLen=0;
//        for (int i=0;i<n;i++){  // i作为终点
//            int j=i;    //j作为起点
//            while (j>=0){
//                if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
//                    pal[j][i]=true;
//                    maxLen=Math.max(maxLen, i-j+1);
//                }
//                j--;
//            }
//        }
//        return maxLen;
//    }

    public static  String Manacher(String s) {
        String ss = "#";
        for (int i = 0; i < s.length(); i++){
            ss += s.charAt(i);
            ss += "#";
        }
        return ss;

    }
    //把每个字符串不管是奇字符串还是偶字符串，都在字符左右加标识符（任意在这里用 # ）
    //比如 1 2 1  就变成 # 1 # 2 # 1 #  这样处理不管奇数偶数都变成偶数长度的数组
    public  static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[2*str.length()+1];
        int index = 0;
        for (int i =0;i<res.length;i++){
            res[i] = (i&1)==0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static  int maxLcpsLength(String str){
        if (str==null||str.length()<1){
            return 0;
        }

        char[] charArr = manacherString(str);
        //存储i位置的最大回文半径
        int[] pArr = new int[charArr.length];
        int max = Integer.MIN_VALUE;
        int r = -1;
        int c = -1;
        for (int i = 0;i<charArr.length;i++){
            //把四种情况用一个判断条件写出来，给i位置的回文半径赋一个初始值
            pArr[i] = r>i ? Math.min(r-i,pArr[2*c-i]) : 1;
            while (i+pArr[i]<charArr.length&&i-pArr[i]>-1){
                //如果在第一种或者第四种情况下，扩展的位置相等回文扩大
                if (charArr[i+pArr[i]]==charArr[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>r){
                r = i + pArr[i];
                c = i;
            }
            max = Math.max(max,pArr[i]);
        }
        //因为最开始回文半径赋值为1，所以多了1 得减去
        return max-1;
    }

//    作者：一凡呀
//    链接：https://www.jianshu.com/p/e289d4bc78cb
//    來源：简书
//    简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
}
