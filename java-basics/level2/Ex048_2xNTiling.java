// 2 x n 타일링
// 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 
// 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 
// 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.

// 타일을 가로로 배치 하는 경우
// 타일을 세로로 배치 하는 경우
// 예를들어서 n이 7인 직사각형은 다음과 같이 채울 수 있습니다.
// 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.

// 제한사항
// 가로의 길이 n은 60,000이하의 자연수 입니다.
// 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

// 입출력 예
// n	result
// 4	  5
// 입출력 예 설명
// 입출력 예 #1
// 다음과 같이 5가지 방법이 있다.

// 2 × N Tiling
// There is a rectangular tile with a width of 2 and a height of 1. 
// Using this rectangular tile, we want to completely fill a floor with a height of 2 and a width of n. 
// There are two ways to place the tile.

// Placing the tile horizontally
// Placing the tile vertically
// For example, a rectangle with n equal to 7 can be filled in the following ways.
// Given the width n of the rectangle, complete the solution function to return the number of ways to fill the rectangle.

// Constraints
// The width n is a natural number less than or equal to 60,000.
// Since the number of possible ways can become very large, return the remainder when the number of ways is divided by 1,000,000,007.

// Example
// n	result
// 4	  5

// Example Explanation
// Example #1
// There are 5 ways to fill the rectangle as follows.

public class Ex048_2xNTiling {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int a = 1; // n=1일 때의 경우의 수 # Number of ways when n=1
        int b = 2; // n=2일 때의 경우의 수 # Number of ways when n=2

        switch (n) {
            case 1 -> {
                return a; // n=1인 경우의 수를 반환한다. # Return the number of ways when n=1
            }
            case 2 -> {
                return b; // n=2인 경우의 수를 반환한다. # Return the number of ways when n=2
            }
            default -> {
                for (int i = 3; i <= n; i++) {
                    // 이전 두 값의 합으로 다음 경우의 수를 계산한다. # Calculate the next number of ways using the previous two values
                    int next = (a + b) % 1_000_000_007;

                    a = b; // 현재 값을 이전 값으로 이동한다. # Move the current value to the previous value
                    b = next; // 다음 값을 현재 값으로 이동한다. # Move the next value to the current value
                }
            }
        }

        return b; // n번째 경우의 수를 반환한다. # Return the number of ways for n
    }
}