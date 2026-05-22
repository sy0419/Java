// n^2 배열 자르기

// 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

// n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
// i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
// 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
// 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
// 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
// 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 107
// 0 ≤ left ≤ right < n2
// right - left < 105

// 입출력 예
// n	left	right	      result
// 3	 2	      5	         [3,2,2,3]
// 4	 7	     14	     [4,3,3,3,4,4,4,4]


// N² Array Slice

// Given integers n, left, and right, create a 1D array through the following process.

// Create an empty n × n 2D array.
// For i = 1, 2, 3, ..., n, repeat the following:
// Fill all empty cells in the area from (1,1) to (i,i) with the number i.
// Concatenate all rows into a single 1D array.
// Let this array be arr. Keep only arr[left] to arr[right] and remove the rest.
// Complete the solution function to return the resulting array.

// Constraints
// 1 ≤ n ≤ 10⁷
// 0 ≤ left ≤ right < n²
// right - left < 10⁵

// Example Input / Output
// n	left	right	      result
// 3	 2	      5	         [3,2,2,3]
// 4	 7	     14	     [4,3,3,3,4,4,4,4]

import java.util.Arrays;

public class Ex021_NSquareCut {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }

    public static int[] solution(int n, long left, long right) {
        // 결과 배열 생성 # Create result array
        int[] result = new int[(int) (right - left + 1)];

        // left ~ right 범위 탐색 # Traverse from left to right
        for (long i = left; i <= right; i++) {

            // 현재 index의 행 계산 # Calculate row index
            long row = i / n;

            // 현재 index의 열 계산 # Calculate column index
            long col = i % n;

            // 큰 값 + 1 규칙 적용 # Apply max(row, col) + 1 rule
            result[(int) (i - left)] = (int) (Math.max(row, col) + 1);
        }
        // 결과 반환 # Return result
        return result;
    }
}