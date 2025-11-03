// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
// 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)

// 제한 조건
// n은 2이상 1000000이하의 자연수입니다.

public class Ex057_countPrimes {
    public static void main(String[] args) {
        System.out.println(solution(10)); // 10까지 소수 개수 출력 # Output count of primes up to 10
        System.out.println(solution(5));  // 5까지 소수 개수 출력 # Output count of primes up to 5
    }

    public static int solution(int n) {
        int result = 0; // 소수 개수를 저장할 변수 # Variable to store prime count
        
        for (int i = 2; i <= n; i++) { // 2부터 n까지 반복 # Loop from 2 to n
            boolean isPrime = true; // 소수 여부 플래그 # Flag to check if i is prime
            int sqrt = (int) Math.sqrt(i); // 반복 전에 제곱근 계산 # Calculate square root once
            for (int j = 2; j <= sqrt; j++) { // 2부터 sqrt까지 반복 # Loop from 2 to sqrt
                if (i % j == 0) { // 나누어 떨어지면 소수가 아님 # Not prime if divisible
                    isPrime = false;
                    break; // 더 이상 확인 필요 없음 # No need to check further
                }
            }
            if (isPrime) {
                result++; // 소수면 카운트 증가 # Increment count if prime
            }
        }
        return result; // 최종 결과 반환 # Return final count
    }
}