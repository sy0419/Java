// k진수에서 소수 개수 구하기
// 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때,
// 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
//
// 0P0처럼 소수 양쪽에 0이 있는 경우
// P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
// 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
// P처럼 소수 양쪽에 아무것도 없는 경우
// 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
//
// 정수 n과 k가 매개변수로 주어질 때,
// 조건에 맞는 소수의 개수를 반환하세요.

// Count Prime Numbers in K-base Representation
// Given a positive integer n, convert it into a k-base string and count the prime numbers separated by zeros.
// A valid prime can appear as:
// 0P0
// P0
// 0P
// P
//
// P must not contain the digit 0.
//
// Return the number of valid prime numbers.

public class Ex042_KBasePrimeCount {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {

        // 숫자를 k진수 문자열로 변환한다. # Convert the number into a k-base string.
        String convertedInt = Integer.toString(n, k);

        // 소수의 개수를 저장한다. # Store the number of prime numbers.
        int result = 0;

        // 0을 기준으로 문자열을 분리한다. # Split the string by consecutive zeros.
        String[] arr = convertedInt.split("0+");

        // 분리된 문자열을 하나씩 확인한다. # Check each separated segment.
        for (String arr1 : arr) {

            // 빈 문자열은 건너뛴다. # Skip empty strings.
            if (arr1.isEmpty()) {
                continue;
            }

            // 문자열을 숫자로 변환한다. # Convert the string into a number.
            long convertNum = Long.parseLong(arr1);

            // 소수이면 개수를 증가시킨다. # Increase the count if it is prime.
            if (isPrime(convertNum)) {
                result++;
            }
        }

        return result;
    }

    public static boolean isPrime(long num) {

        // 1 이하는 소수가 아니다. # Numbers less than or equal to 1 are not prime.
        if (num <= 1) {
            return false;
        }

        // 제곱근까지 나누어 떨어지는 수를 확인한다.
        // Check divisibility up to the square root.
        for (int i = 2; i <= Math.sqrt(num); i++) {

            // 나누어 떨어지면 소수가 아니다. # If divisible, it is not a prime number.
            if (num % i == 0) {
                return false;
            }
        }

        // 끝까지 나누어 떨어지지 않으면 소수이다. # Return true if no divisor exists.
        return true;
    }
}