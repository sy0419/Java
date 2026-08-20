// 가장 큰 수
// 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
// 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
// 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

// 제한 사항
// numbers의 길이는 1 이상 100,000 이하입니다.
// numbers의 원소는 0 이상 1,000 이하입니다.
// 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

// 입출력 예
//     numbers                   return
//    [6, 10, 2]                 "6210"
// [3, 30, 34, 5, 9]            "9534330"

// Largest Number
// Given zero or positive integers, determine the largest number that can be created by concatenating the integers.
// For example, if the given integers are [6, 10, 2], the possible numbers are [6102, 6210, 1062, 1026, 2610, 2106], and the largest number among them is 6210.
// Given an array of zero or positive integers numbers, write a solution function that rearranges their order to create the largest possible number and returns the result as a string.

// Constraints
// The length of numbers is between 1 and 100,000.
// Each element of numbers is between 0 and 1,000.
// Since the answer can be very large, return the answer as a string.

// Input/Output Examples
//     numbers                   return
//    [6, 10, 2]                 "6210"
// [3, 30, 34, 5, 9]            "9534330"

import java.util.Arrays;

public class Ex052_LargestNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] numbersString = new String[numbers.length];

        // 숫자를 문자열로 변환한다. # Convert the numbers into strings.
        for (int i = 0; i < numbers.length; i++) {
            numbersString[i] = String.valueOf(numbers[i]);
        }

        // 두 숫자를 연결했을 때 더 큰 순서로 정렬한다. # Sort by the larger concatenation result.
        Arrays.sort(numbersString, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // 정렬된 문자열을 하나로 이어 붙인다. # Concatenate the sorted strings.
        for (String number : numbersString) {
            sb.append(number);
        }

        // 모든 숫자가 0인 경우 "000..." 대신 "0"을 반환한다. # Return "0" when all numbers are zero.
        if (numbersString[0].equals("0")) {
            return "0";
        }

        return sb.toString();
    }
}