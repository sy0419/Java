// 정수 n이 매개변수로 주어질 때, 다음과 같은 n × n 크기의 이차원 배열 arr를 return 하는 solution 함수를 작성해 주세요.
// arr[i][j] (0 ≤ i, j < n)의 값은 i = j라면 1, 아니라면 0입니다.
// 제한사항
// 1 ≤ n ≤ 100

import java.util.Arrays;

public class Ex117_identityMatrix {
    public static void main(String[] args) {
        // 2차원 배열을 문자열로 출력하려면 Arrays.deepToString 사용 # Use Arrays.deepToString to print 2D arrays as strings
        System.out.println(Arrays.deepToString(solution1(3))); // 예상 출력: [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        System.out.println(Arrays.deepToString(solution1(6))); // 예상 출력: 6x6 단위 행렬
        System.out.println(Arrays.deepToString(solution1(1))); // 예상 출력: [[1]]
        System.out.println(Arrays.deepToString(solution2(3))); // 예상 출력: [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        System.out.println(Arrays.deepToString(solution2(6))); // 예상 출력: 6x6 단위 행렬
        System.out.println(Arrays.deepToString(solution2(1))); // 예상 출력: [[1]]
    }

    // 방법 1: 이중 for문으로 모든 원소 확인 # Method 1: Double for-loop to check all elements
    public static int[][] solution1(int n) {
        int[][] arr = new int[n][n]; // 2차원 배열 선언 # Declare 2D array

        for (int i = 0; i < n; i++) { // 행 순회 # Traverse rows
            for (int j = 0; j < n; j++) { // 열 순회 # Traverse columns
                if (i == j) { // 대각선 위치일 때만 1 저장 # Store 1 only on diagonal
                    arr[i][j] = 1;
                }
            }
        }
        return arr; // 결과 배열 반환 # Return result array
    }

    // 방법 2: 한 for문으로 대각선 원소만 1로 설정 # Method 2: Single for-loop to set diagonal elements only
    public static int[][] solution2(int n) {
        int[][] answer = new int[n][n]; // 2차원 배열 선언 # Declare 2D array

        for (int i = 0; i < n; i++) {
            answer[i][i] = 1; // 대각선 위치에 1 저장 # Set 1 on diagonal positions only
        }

        return answer; // 결과 배열 반환 # Return result array
    }
}