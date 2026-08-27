// 소수 찾기
// 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
// 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
// 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어질 때,
// 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// numbers는 길이 1 이상 7 이하인 문자열입니다.
// numbers는 0~9까지 숫자만으로 이루어져 있습니다.
// "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

// 입출력 예
// numbers    return
//  "17"        3
// "011"        2

// 입출력 예 설명
// 예제 #1
// [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
// 예제 #2
// [0, 1, 1]으로는 소수 [11, 101]을 만들 수 있습니다.
// 11과 011은 같은 숫자로 취급합니다.

// Find Prime Numbers
// Single-digit numbers are written on separate paper pieces.
// We want to determine how many prime numbers can be formed by combining these paper pieces.
// Given a string numbers containing the digits written on the paper pieces,
// complete the solution function to return the number of prime numbers that can be formed.

// Constraints
// numbers is a string with a length between 1 and 7.
// numbers consists only of digits from 0 to 9.
// "013" means that paper pieces containing the digits 0, 1, and 3 are scattered.

// Examples
// numbers    return
//  "17"        3
// "011"        2

// Example Explanation
// Example #1
// From [1, 7], the prime numbers [7, 17, 71] can be formed.
// Example #2
// From [0, 1, 1], the prime numbers [11, 101] can be formed.
// 11 and 011 are considered the same number.

import java.util.HashSet;
import java.util.Set;

public class Ex055_FindPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int result = 0;

        // 만들 수 있는 숫자를 저장하고 중복을 제거한다. # Store possible numbers and remove duplicates.
        Set<Integer> numbersSet = new HashSet<>();

        // 각 숫자 조각의 사용 여부를 저장한다. # Store whether each digit piece has been used.
        boolean[] used = new boolean[numbers.length()];

        // 재귀적으로 만들 수 있는 모든 숫자를 생성한다. # Recursively generate all possible numbers.
        makeNumber(numbers, used, 0, numbersSet);

        // 만들어진 숫자 중 소수의 개수를 센다. # Count the prime numbers among the generated numbers.
        for (int number : numbersSet) {
            if (isPrime(number)) {
                result++;
            }
        }

        return result;
    }

    private static void makeNumber(String numbers, boolean[] used, int number, Set<Integer> numbersSet) {
        // 사용하지 않은 숫자 조각을 하나씩 선택한다. # Select each unused digit piece.
        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                // 선택한 숫자 조각을 정수로 변환한다. # Convert the selected digit piece to an integer.
                int digit = numbers.charAt(i) - '0';

                // 현재 숫자 뒤에 선택한 숫자를 붙인다. # Append the selected digit to the current number.
                int newNumber = number * 10 + digit;

                // 선택한 숫자 조각을 사용했다고 표시한다. # Mark the selected digit piece as used.
                used[i] = true;

                // 새로 만든 숫자를 저장한다. # Store the newly created number.
                numbersSet.add(newNumber);

                // 다음 숫자 조각을 선택하기 위해 재귀 호출한다. # Recursively select the next digit piece.
                makeNumber(numbers, used, newNumber, numbersSet);

                // 다음 조합을 위해 사용 상태를 되돌린다. # Restore the used state for the next combination.
                used[i] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        // 2보다 작은 수는 소수가 아니다. # Numbers smaller than 2 are not prime.
        if (number < 2) {
            return false;
        }

        // 제곱근 이하의 약수만 확인한다. # Check only divisors up to the square root.
        for (int i = 2; i * i <= number; i++) {
            // 나누어떨어지면 소수가 아니다. # If divisible, the number is not prime.
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}