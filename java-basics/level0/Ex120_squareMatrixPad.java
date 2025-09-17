// 이차원 정수 배열 arr이 매개변수로 주어집니다. arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100
// 1 ≤ arr의 원소의 길이 ≤ 100
// arr의 모든 원소의 길이는 같습니다.
// 1 ≤ arr의 원소의 원소 ≤ 1,000

import java.util.Arrays;

public class Ex120_squareMatrixPad {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{57, 192, 534, 2}, {9, 345, 192, 999}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2}, {3, 4}})));
    }

    public static int[][] solution(int[][] arr) {
        int row = arr.length;  // 행 개수, # Number of rows in the original array
        int col = arr[0].length;  // 열 개수, # Number of columns in the original array
        int max = Math.max(row, col);  // 정사각형 크기, # Size of the square array (max of rows and columns)
        int[][] result = new int[max][max];  // max x max 크기의 배열 생성, # Create a new max x max 2D array initialized with 0

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = arr[i][j];  // 기존 배열 값 복사, # Copy values from original array to new array
            }
        }
        return result;  // 완성된 정사각형 배열 반환, # Return the square matrix with padding zeros
    }
}