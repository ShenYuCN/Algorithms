package Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by happiness on 17/9/19.
 * 重塑矩阵
 * <p/>
 * <p/>
 * In MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix,respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.
 * Example 1:
 * Input:
 * <p/>
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * <p/>
 * Output:
 * [[1,2,3,4]]
 * <p/>
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * <p/>
 * <p/>
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * <p/>
 * <p/>
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class A05_Reshape_the_Matrix {
    public static void main(String args[]) {

        int[][] ss = {{1, 2}, {3, 4}};


//        int[][] res = matrixReshape(ss, 2, 4);
        int[][] res = S_divisionAndModulus(ss, 1, 4);
//        System.out.println(ss[1][0]);

        for (int j = 0; j < res.length; j++) {
            System.out.println("res" + Arrays.toString(res[j]));

        }

    }
    /*
 *
 *   A4: A3的优化，一次循环
 *
 *
 *   Time Complexity : O(m)
 *   Space Complexity: O(m*n)  The resultant matrix of size m*n is used
 * */
    public static int[][] S_divisionAndModulus(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r *c ) return nums;
        int n = nums[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < nums.length * n; i ++){
            res[i/c][i%c] = nums[i/n][i%n];
        }
        return res;
    }


    /*
    *    A1: 自己的思路，使用队列，先都取出来，再分配
    *    Using Queue
    *
    *   Time Complexity : O(m*n)
    *   Space Complexity: O(m*n)  The queue formed will be of size m*n
    * */
    public static int[][] M__S_matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;
        Queue<Integer> queue = new LinkedList<>();
        for (int[] row : nums) {
            for (int i : row) {
                queue.add(i);
            }
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

    /*
    *
    *   A2:不使用队列，新数组元素直接从给定数组取，通过每行的元素数量叠加
    *
    *
    *   Time Complexity : O(m*n)
    *   Space Complexity: O(m*n)  The resultant matrix of size m*n is used
    * */
    public static int[][] M_matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;

        int[][] res = new int[r][c];
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }

    /*
      *
      *   A3:不使用队列，新数组元素直接从给定数组取,和A2相似，计算方式通过模数运算
      *
      *
      *   Time Complexity : O(m*n)
      *   Space Complexity: O(m*n)  The resultant matrix of size m*n is used
      * */
    public static int[][] divisionAndModulus(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c) return nums;

        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }


}
