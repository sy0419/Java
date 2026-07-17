// k진수에서 소수 개수 구하기
// 양의 정수 n이 주어집니다. 
// 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
// 0P0처럼 소수 양쪽에 0이 있는 경우
// P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
// 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
// P처럼 소수 양쪽에 아무것도 없는 경우
// 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
// 예를 들어, 101은 P가 될 수 없습니다.
// 예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 
// 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. 
// (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 
// 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

// 정수 n과 k가 매개변수로 주어집니다. 
// n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ n ≤ 1,000,000
// 3 ≤ k ≤ 10

// 입출력 예
// n	k	result
// 437674	3	3
// 110011	10	2

// 입출력 예 설명
// 입출력 예 #1
// 문제 예시와 같습니다.

// 입출력 예 #2
// 110011을 10진수로 바꾸면 110011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 11, 11 2개입니다. 
// 이와 같이, 중복되는 소수를 발견하더라도 모두 따로 세어야 합니다.

// Count Prime Numbers in K-base Representation
// Given a positive integer n,
// convert it into a k-base number and determine how many prime numbers
// in the converted number satisfy the following conditions.

// - A prime number with zeros on both sides (0P0)
// - A prime number with a zero only on the right (P0)
// - A prime number with a zero only on the left (0P)
// - A prime number with no zeros on either side (P)

// P must be a prime number whose digits do not contain 0.
// For example, 101 cannot be considered as P.

// For example, when 437674 is converted into base 3,
// it becomes 211020101011.
// The valid prime numbers are 211, 2, and 11,
// so the answer is 3.

// Note that 211, 2, and 11 must be prime numbers in decimal,
// not in base k.
// 211 is found in the form P0,
// 2 is found in the form 0P0,
// and 11 is found in the form 0P.

// Given two integers n and k,
// complete the solution function to return the number of prime numbers
// that satisfy the above conditions in the k-base representation.

// Constraints
// 1 ≤ n ≤ 1,000,000
// 3 ≤ k ≤ 10

// Examples
// n       k   result
// 437674  3   3
// 110011  10  2

// Example Explanation
// Example #1
// The result is the same as described in the example above.

// Example #2
// When 110011 is represented in decimal, it remains 110011.
// The valid prime numbers are 11 and 11.
// Even if the same prime number appears multiple times,
// each occurrence should be counted separately.

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