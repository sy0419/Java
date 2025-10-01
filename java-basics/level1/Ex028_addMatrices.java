// 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

// 제한 조건
// 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

import java.util.Arrays;

public class Ex028_addMatrices {
    public static void main(String[] args) {
        // 테스트 케이스 출력 확인 # Test output
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1}, {2}}, new int[][]{{4}, {6}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // 결과를 담을 배열 생성 # Initialize result array
        int[][] result = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) { // 행 반복 # Loop over rows
            for (int j = 0; j < arr1[0].length; j++) { // 열 반복 # Loop over columns
                result[i][j] = arr1[i][j] + arr2[i][j]; // 같은 위치의 값 더함 # Add corresponding elements
            }
        }

        return result; // 덧셈 결과 반환 # Return result
    }
}