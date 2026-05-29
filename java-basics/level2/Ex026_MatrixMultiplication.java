// 행렬의 곱셈

// 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

// 제한 조건
// 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
// 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
// 곱할 수 있는 배열만 주어집니다.

// 입출력 예
//          arr1	                                arr2	                                 return
//    [[1, 4], [3, 2], [4, 1]]	              [[3, 3], [3, 3]]	                 [[15, 15], [15, 15], [15, 15]]
// [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]

// Matrix Multiplication

// Given two 2D matrices arr1 and arr2,
// return the result of multiplying arr1 by arr2.

// Constraints
// The number of rows and columns of arr1 and arr2
// is between 2 and 100.
// Matrix values are integers between -10 and 20.
// Only multipliable matrices are provided.

// Example Input / Output
//          arr1	                                arr2	                                 return
//    [[1, 4], [3, 2], [4, 1]]	              [[3, 3], [3, 3]]	                 [[15, 15], [15, 15], [15, 15]]
// [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]

import java.util.Arrays;

public class Ex026_MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                solution(
                        new int[][]{{1, 4}, {3, 2}, {4, 1}},
                        new int[][]{{3, 3}, {3, 3}}
                )));

        System.out.println(Arrays.deepToString(
                solution(
                        new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
                        new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}
                )));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length]; // 결과 행렬 생성 # Create result matrix

        // arr1의 행 반복 # Iterate rows of arr1
        for (int i = 0; i < arr1.length; i++) {

            // arr2의 열 반복 # Iterate columns of arr2
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0; // 현재 위치 값 저장 # Store current cell value

                // 행 × 열 계산 # Calculate row × column multiplication
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                    // arr1 행 × arr2 열 누적합 # Accumulate row × column multiplication
                }
                result[i][j] = sum; // 결과 저장 # Store result value
            }
        }
        return result;
    }
}