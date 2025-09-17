// 2차원 정수 배열 board와 정수 k가 주어집니다.
// i + j <= k를 만족하는 모든 (i, j)에 대한 board[i][j]의 합을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ board의 길이 ≤ 100
// 1 ≤ board[i]의 길이 ≤ 100
// 1 ≤ board[i][j] ≤ 10,000
// 모든 board[i]의 길이는 같습니다.
// 0 ≤ k < board의 길이 + board[i]의 길이

public class Ex121_sumUnderK {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}}, 2));  // 테스트 케이스 실행, # Run test case
    }

    public static int solution(int[][] board, int k) {
        int sum = 0;  // 조건을 만족하는 값들의 합을 저장할 변수, # Variable to store the sum of values that meet the condition
        for (int i = 0; i < board.length; i++) {  // 행 순회, # Loop through rows
            for (int j = 0; j < board[i].length; j++) {  // 열 순회, # Loop through columns
                if (i + j <= k) {  // 인덱스의 합이 k 이하인지 확인, # Check if the sum of indices i + j is less than or equal to k
                    sum += board[i][j];  // 조건 만족 시 값 누적, # Add the value to sum if condition is met
                }
            }
        }
        return sum;  // 최종 합계 반환, # Return the final sum
    }
}