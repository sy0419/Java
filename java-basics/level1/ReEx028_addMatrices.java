
import java.util.Arrays;

public class ReEx028_addMatrices {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 2}, {2, 3}}, new int[][] {{3, 4}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][] {{1}, {2}}, new int[][] {{3}, {4}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return result;
    }
}