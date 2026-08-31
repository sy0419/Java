// 큰 수 만들기
// 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
// 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
// 이 중 가장 큰 숫자는 94 입니다.

// 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
// number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

// 제한 조건
// number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
// k는 1 이상 number의 자릿수 미만인 자연수입니다.

// 입출력 예
// number          k       return
// "1924"          2       "94"
// "1231234"       3       "3234"
// "4177252841"    4       "775841"

// Make Big Number
// Given a number, find the largest possible number after removing k digits.
// For example, removing two digits from 1924 can produce [19, 12, 14, 92, 94, 24].
// Among these numbers, the largest number is 94.

// The number number and the number of digits to remove k are given as parameters
// of the solution function in string format.
// Complete the solution function so that it returns the largest number
// that can be obtained after removing k digits from number.

// Constraints
// number is between 2 and 1,000,000 digits long.
// k is a natural number between 1 and one less than the number of digits.

// Examples
// number          k       return
// "1924"          2       "94"
// "1231234"       3       "3234"
// "4177252841"    4       "775841"

import java.util.*;

public class Ex059_MakeBigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        Stack<Character> numberStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            // 현재 숫자보다 작은 숫자를 제거한다. # Remove smaller digits than the current digit.
            while (!numberStack.isEmpty()
                    && k > 0
                    && numberStack.peek() < number.charAt(i)) {

                numberStack.pop();
                k--;
            }

            // 현재 숫자를 스택에 추가한다. # Add the current digit to the stack.
            numberStack.add(number.charAt(i));
        }

        // 남은 제거 횟수만큼 뒤쪽 숫자를 제거한다. # Remove digits from the end for the remaining count.
        while (k > 0) {
            numberStack.pop();
            k--;
        }

        // 스택의 숫자를 결과에 추가한다. # Append the digits from the stack to the result.
        while (!numberStack.isEmpty()) {
            result.append(numberStack.pop());
        }

        // 뒤집어서 원래 순서로 만든다. # Reverse the result to restore the original order.
        return result.reverse().toString();
    }
}