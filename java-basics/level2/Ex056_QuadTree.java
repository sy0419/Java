
import java.util.Arrays;

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

public class Ex056_QuadTree {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(solution(new int[][] {{1,1,1,1,1,1,1,1}, {0,1,1,1,1,1,1,1},
            {0,0,0,0,1,1,1,1}, {0,1,0,0,1,1,1,1},
            {0,0,0,0,0,0,1,1}, {0,0,0,0,0,0,0,1},
            {0,0,0,0,1,0,0,1}, {0,0,0,0,1,1,1,1}})));
    }

    public static int[] solution(int[][] arr) {

        return null;
    }
}