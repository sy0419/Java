// 다음 큰 숫자
// 양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
// x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
// 예를 들어,
// f(2) = 3 입니다.
// 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
// 수          비트          다른 비트의 개수
// 2        000...0010
// 3        000...0011             1
// f(7) = 11 입니다.
// 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
// 수            비트        다른 비트의 개수
// 7        000...0111
// 8        000...1000             4
// 9        000...1001             3
// 10       000...1010             3
// 11       000...1011             2

// 정수들이 담긴 배열 numbers가 매개변수로 주어집니다.
// numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아
// return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ numbers의 길이 ≤ 100,000
// 0 ≤ numbers의 모든 수 ≤ 10^15

// 입출력 예
// numbers        result
// [2, 7]         [3, 11]


// Next Number
// For a positive integer x, define the function f(x) as follows:
// The smallest number greater than x that differs from x in only 1 or 2 bit positions.
// For example,
// f(2) = 3.
// Among the numbers greater than 2, 3 is the smallest number
// whose binary representation differs from that of 2 in at most two bit positions.
// Number      Binary           Number of different bits
// 2         000...0010
// 3         000...0011                    1
//
// f(7) = 11.
// Among the numbers greater than 7, 11 is the smallest number
// whose binary representation differs from that of 7 in at most two bit positions.
//
// Number      Binary           Number of different bits
// 7         000...0111
// 8         000...1000                   4
// 9         000...1001                   3
// 10        000...1010                   3
// 11        000...1011                   2

// Given an integer array numbers, return an array containing
// the value of f(x) for each number in the same order.

// Constraints
// 1 ≤ numbers.length ≤ 100,000
// 0 ≤ numbers[i] ≤ 10^15

// Example
// numbers        result
// [2, 7]         [3, 11]

import java.util.*;

public class Ex053_NextNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[] {2, 7})));
    }

    public static long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            int position = 0;

            // 가장 오른쪽의 0인 비트 위치부터 확인한다. # Start checking from the rightmost bit.
            while ((number & (1L << position)) != 0) {
                // 해당 위치의 비트가 1이면 다음 위치를 확인한다. # Check the next position if the bit is 1.
                position++;
            }

            // 가장 오른쪽의 0을 1로 변경한다. # Change the rightmost 0 bit to 1.
            number = number | (1L << position);
            if (position > 0) {
                // 바로 오른쪽의 1을 0으로 변경한다. # Change the bit immediately to the right to 0.
                number = number & ~(1L << (position - 1));
            }

            // 계산된 값을 결과 배열에 저장한다. # Store the calculated value in the result array.
            result[i] = number;
        }
        
        return result;
    }
}