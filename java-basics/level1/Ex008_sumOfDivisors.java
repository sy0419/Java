// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
// 제한 사항: n은 0 이상 3000이하인 정수입니다.

public class Ex008_sumOfDivisors {
    public static void main(String[] args) {
        System.out.println(solution(12)); // 12의 약수는 1, 2, 3, 4, 6, 12 -> 합: 28 # Divisors of 12: 1, 2, 3, 4, 6, 12 -> Sum: 28
        System.out.println(solution(5));  // 5의 약수는 1, 5 -> 합: 6 # Divisors of 5: 1, 5 -> Sum: 6
    }

    public static int solution(int n) { 
        int result = 0; // 약수들의 합을 저장할 변수 # Variable to store the sum of divisors
        for (int i = 1; i <= n; i++) { // 1부터 n까지 반복 # Loop through 1 to n
            if (n % i == 0) { // i가 n의 약수라면 # If i is a divisor of n
                result += i; // result에 i를 더함 # Add i to the result
            }
        }
        return result; // 약수들의 합 반환 # Return the sum of divisors
    }
}