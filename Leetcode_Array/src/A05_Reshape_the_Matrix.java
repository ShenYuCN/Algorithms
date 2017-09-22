import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by happiness on 17/9/19.
 * 重塑模型
 * <p/>
 * <p/>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
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


        int[][] res = matrixReshape(ss, 2, 4);

        System.out.println(ss[1][0]);

        for (int j = 0; j < res.length; j++) {
            System.out.println("res" + Arrays.toString(res[j]));

        }

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[] allArr = new int[r * c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] elementArr = nums[i];

            count += elementArr.length;
            for (int j = 0; j < elementArr.length; j++) {
                allArr[i * elementArr.length + j] = elementArr[j];
            }

        }

        if (count < allArr.length) return nums;


        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            int[] temp = new int[c];
            for (int j = 0; j < c; j++) {
                temp[j] = allArr[i * c + j];
            }
            res[i] = temp;
        }

        return res;
    }

    /**
     * Using Queue
     * <p/>
     * <p/>
     * Time  complexity: O(m*n)
     * Space complexity: O(m*n) The queue formed will be of size m*n
     */
    public static int[][] queue(int[][] nums, int r, int c) {

        if (nums.length == 0 || r * c != nums.length * nums[0].length) return nums;

        int[][] res = new int[r][c];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

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
