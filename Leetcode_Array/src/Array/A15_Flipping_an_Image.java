package Array;
import java.util.Arrays;

/**
 * Created by happiness on 2018/8/13.
 *
 *
 *
 Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

 To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

 To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

 Example 1:

 Input: [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

 用python 更简单，左右翻转【::-1】
 [[1 ^ i for i in row[::-1]] for row in A]

 *
 */
public class A15_Flipping_an_Image {
    public static void main(String args[]) {
//        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        System.out.println(sy(arr));
//        excellent_solution(arr);
//        so_2(arr);
//        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1}};
        A = A_flipAndInvertImage(A);

        for (int[] array : A ){
            System.out.println(Arrays.toString(array));

        }

    }

    /*
    *   Time Complexity:O(N) N是A的元素数量
    *   Space Complexity: O(1)
    *
    * */
    public  static int[][] S_flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A) {
            for (int i = 0; i < (C+1) / 2; ++i) { // 这里一定要走中间那个值，因为中间的值也要做取反操作，如果没带上，结果不对
                int tmp = row[i];
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp ^ 1;
            }
        }

        return A;
    }
    /*
    * 高赞答案
    * */
    public  static  int[][] A_flipAndInvertImage(int[][] A) {
        int n = A.length;
        System.out.println(n);

        for (int[] row : A) {
            System.out.println(Arrays.toString(row));

            for (int i = 0; i * 2 < n; i++) {
                // System.out.println(row[i] +"  "+ row[n - i - 1]);

                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return A;
    }
}
