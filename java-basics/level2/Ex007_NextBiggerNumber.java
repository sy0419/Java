// 다음 큰 숫자

// 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
// 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
// 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
// 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
// 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

// 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

// 제한 사항
// n은 1,000,000 이하의 자연수 입니다.

// 입출력 예
//  n	result
// 78	 83
// 15	 23

// 입출력 예 설명
// 입출력 예#1
// 문제 예시와 같습니다.

// 입출력 예#2
// 15(1111)의 다음 큰 숫자는 23(10111)입니다.

public class Ex007_NextBiggerNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));

        System.out.println(solution2(78));
        System.out.println(solution2(15));
    }

    public static int solution(int n) {

        // n의 2진수에서 1의 개수 저장 # Store the number of 1 bits in n
        int nBitCount = Integer.bitCount(n);

        // 결과값 저장 변수 # Variable to store result
        int result = 0;

        // n보다 큰 숫자부터 순차 탐색 # Check numbers larger than n
        for (int i = n + 1; i < 1000000; i++) {

            // 현재 숫자의 1 개수 계산 # Count 1 bits of current number
            int bitCount = Integer.bitCount(i);

            // 1의 개수가 같다면 결과 저장 # If bit counts match, save result
            if (bitCount == nBitCount) {
                result = i;

                // 가장 작은 다음 숫자이므로 종료 # Stop because smallest valid number found
                break;
            }
        }

        // 결과 반환 # Return result
        return result;
    }

    public static int solution2(int n) {

        // n의 2진수 1 개수 저장 # Store the number of 1 bits in n
        int nBitCount = Integer.bitCount(n);

        // n보다 1 큰 값부터 시작 # Start from n + 1
        int i = n + 1;

        // 조건 만족할 때까지 반복 # Repeat until condition is satisfied
        while (true) {

            // 1의 개수가 같다면 바로 반환 # Return immediately if bit counts match
            if (Integer.bitCount(i) == nBitCount) {
                return i;
            }

            // 다음 숫자 탐색 # Move to next number
            i++;
        }
    }
}