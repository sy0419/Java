// 삼각 달팽이
// 정수 n이 매개변수로 주어집니다. 
// 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
// 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
//
// 제한사항
// n은 1 이상 1,000 이하입니다.

// 입출력 예
// n                          result
// 4                  [1,2,9,3,10,8,4,5,6,7]
// 5           [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
// 6    [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10]

// Snail Triangle
// Given an integer n, complete the solution function to fill a triangle with numbers 
// in a counter-clockwise snail pattern, starting from the top vertex, as shown in the figure.
// Then return a new array containing all numbers in order from the first row to the last row.
//
// Constraints
// n is between 1 and 1,000.

// Examples
// n    result
// n                          result
// 4                  [1,2,9,3,10,8,4,5,6,7]
// 5           [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
// 6    [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10]

import java.util.*;

public class Ex064_SnailTriangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    public static int[] solution(int n) {
        // 삼각형 형태의 2차원 배열 생성 # Create a 2D array in a triangular shape
        int[][] triangle = new int[n][];

        // 각 행의 길이를 1, 2, 3, ... n으로 설정 # Set each row length to 1, 2, 3, ... n
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        // 현재 위치와 숫자, 이동 방향을 초기화 # Initialize the current position, number, and direction
        int row = 0;
        int col = 0;
        int num = 1;
        int direction = 0;

        // 삼각형 전체 칸의 개수를 계산 # Calculate the total number of cells
        int totalCount = n * (n + 1) / 2;

        // 전체 칸을 순회하며 숫자를 채움 # Fill all cells with numbers
        for (int i = 0; i < totalCount; i++) {
            triangle[row][col] = num;
            num++;

            // 현재 방향을 기준으로 다음 위치를 계산 # Calculate the next position based on the current direction
            int nextRow = row;
            int nextCol = col;

            switch (direction) {
                // 아래 방향 # Move down
                case 0 -> nextRow += 1;

                // 오른쪽 방향 # Move right
                case 1 -> nextCol += 1;

                // 왼쪽 위 방향 # Move up-left
                default -> {
                    nextRow -= 1;
                    nextCol -= 1;
                }
            }

            // 다음 위치가 범위를 벗어나거나 이미 채워져 있으면 방향 변경 # Change direction if the next position is out of bounds or already filled
            if (nextRow < 0 || nextRow >= n || nextCol < 0
                || (nextRow >= 0 && nextRow < n && nextCol >= triangle[nextRow].length)
                || triangle[nextRow][nextCol] != 0) {

                // 방향을 다음 방향으로 변경하고 3방향을 반복 # Change to the next direction and cycle through three directions
                direction = (direction + 1) % 3;

                // 현재 위치를 기준으로 다음 위치를 다시 계산 # Recalculate the next position from the current position
                nextRow = row;
                nextCol = col;

                switch (direction) {
                    // 아래 방향 # Move down
                    case 0 -> nextRow += 1;

                    // 오른쪽 방향 # Move right
                    case 1 -> nextCol += 1;

                    // 왼쪽 위 방향 # Move up-left
                    default -> {
                        nextRow -= 1;
                        nextCol -= 1;
                    }
                }
            }

            // 계산한 다음 위치로 현재 위치를 이동 # Move to the calculated next position
            row = nextRow;
            col = nextCol;
        }

        // 삼각형의 값을 1차원 배열로 변환 # Convert the triangle values into a 1D array
        int[] result = new int[totalCount];
        int index = 0;

        // 첫 번째 행부터 마지막 행까지 순서대로 탐색 # Traverse from the first row to the last row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                result[index] = triangle[i][j];
                index++;
            }
        }

        return result;
    }
}