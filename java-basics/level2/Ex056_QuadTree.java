// 쿼드 트리
// 0과 1로 이루어진 2^n × 2^n 크기의 2차원 정수 배열 arr이 주어집니다.
// arr을 쿼드 트리와 같은 방식으로 압축합니다.
// 특정 영역의 모든 수가 같은 값이라면 해당 영역을 그 값 하나로 압축합니다.
// 모든 수가 같지 않다면 영역을 정확히 4개의 균일한 정사각형 영역으로 나누고,
// 각 영역에 대해 같은 방식으로 압축을 진행합니다.
// 최종적으로 압축된 0의 개수와 1의 개수를 배열에 담아 반환합니다.

// 제한사항
// arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭제곱수입니다.
// arr은 정사각형 배열입니다.
// arr의 모든 값은 0 또는 1입니다.

// 입출력 예
//                   arr                       result 
//         [[1,1,0,0], [1,0,0,0],              [4, 9]
//          [1,0,0,1], [1,1,1,1]]
// [[1,1,1,1,1,1,1,1], [0,1,1,1,1,1,1,1],     [10, 15]
//  [0,0,0,0,1,1,1,1], [0,1,0,0,1,1,1,1],
//  [0,0,0,0,0,0,1,1], [0,0,0,0,0,0,0,1],
//  [0,0,0,0,1,0,0,1], [0,0,0,0,1,1,1,1]]

// Quad Tree
// Given a 2^n × 2^n two-dimensional integer array arr consisting of 0s and 1s,
// compress arr using the same method as a quad tree.
// If all values inside a selected region are the same,
// compress the region into a single value.
// Otherwise, divide the region into four equal-sized square regions
// and recursively apply the same compression method to each region.
// Return an array containing the final number of compressed 0s and 1s.

// Constraints
// The number of rows in arr is between 1 and 1024 and is a power of 2.
// arr is a square matrix.
// Every value in arr is either 0 or 1.

// Examples
//                   arr                       result 
//         [[1,1,0,0], [1,0,0,0],              [4, 9]
//          [1,0,0,1], [1,1,1,1]]
// [[1,1,1,1,1,1,1,1], [0,1,1,1,1,1,1,1],     [10, 15]
//  [0,0,0,0,1,1,1,1], [0,1,0,0,1,1,1,1],
//  [0,0,0,0,0,0,1,1], [0,0,0,0,0,0,0,1],
//  [0,0,0,0,1,0,0,1], [0,0,0,0,1,1,1,1]]

import java.util.Arrays;

public class Ex056_QuadTree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][] {{1,1,1,1,1,1,1,1}, {0,1,1,1,1,1,1,1},
            {0,0,0,0,1,1,1,1}, {0,1,0,0,1,1,1,1},
            {0,0,0,0,0,0,1,1}, {0,0,0,0,0,0,0,1},
            {0,0,0,0,1,0,0,1}, {0,0,0,0,1,1,1,1}})));
    }

    public static int[] solution(int[][] arr) {
        // 압축된 0과 1의 개수를 저장한다. # Store the counts of compressed 0s and 1s.
        int[] result = new int[2];

        // 전체 배열부터 압축을 시작한다. # Start compression from the entire array.
        compress(arr, 0, 0, arr.length, result);

        return result;
    }

    private static void compress(int[][] arr, int row, int col, int size, int[] result) {
        // 현재 영역의 첫 번째 값을 기준값으로 사용한다. # Use the first value of the current region as the reference value.
        int value = arr[row][col];

        // 현재 영역이 모두 같은 값이라고 가정한다. # Assume all values in the current region are the same.
        boolean same = true;

        // 현재 영역의 모든 값을 확인한다. # Check all values in the current region.
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 현재 값이 기준값과 다른지 확인한다. # Check whether the current value differs from the reference value.
                if (arr[i][j] != value) {
                    // 다른 값이 있으면 압축할 수 없다. # If a different value exists, the region cannot be compressed.
                    same = false;
                }
            }
        }

        // 현재 영역의 모든 값이 같으면 하나의 값으로 압축한다. # Compress the region into one value if all values are the same.
        if (same) {
            // 해당 값의 압축 개수를 증가시킨다. # Increase the count of the compressed value.
            result[value]++;
        } else {
            // 현재 영역을 4개의 영역으로 나누기 위해 크기를 절반으로 줄인다. # Halve the size to divide the current region into four regions.
            int half = size / 2;

            // 왼쪽 위 영역을 다시 압축한다. # Compress the top-left region.
            compress(arr, row, col, half, result);

            // 오른쪽 위 영역을 다시 압축한다. # Compress the top-right region.
            compress(arr, row, col + half, half, result);

            // 왼쪽 아래 영역을 다시 압축한다. # Compress the bottom-left region.
            compress(arr, row + half, col, half, result);

            // 오른쪽 아래 영역을 다시 압축한다. # Compress the bottom-right region.
            compress(arr, row + half, col + half, half, result);
        }
    }
}