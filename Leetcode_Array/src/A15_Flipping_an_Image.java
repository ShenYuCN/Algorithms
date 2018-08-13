import java.util.Arrays;

/**
 * Created by happiness on 2018/8/13.
 *
 *
 * 转置矩阵
 Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

 To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

 To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

 Example 1:

 Input: [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 */
public class A15_Flipping_an_Image {
    public static void main(String args[]) {
//        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        System.out.println(sy(arr));
//        excellent_solution(arr);
//        so_2(arr);
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(Arrays.toString(flipAndInvertImage(A) ));

    }
    public static   int[][] flipAndInvertImage(int[][] A) {
        int[][] res = A;
        for (int i = 0; i < A.length; i ++){
            int[] temp = new int[A.length];
            for (int j = 0; j < temp.length; j++){
                temp[j] = 1 - A[i][temp.length - j -1];
            }
            res[i] = temp;
        }
        return res;
    }
    public  static int[][] S_flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}
