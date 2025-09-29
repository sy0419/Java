// 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ left ≤ right ≤ 1,000

public class Ex024_DivisorSum {
    public static void main(String[] args) {
        System.out.println(solution(13, 17)); // 43 출력 예상 # Expected output: 43
        System.out.println(solution(24, 27)); // 52 출력 예상 # Expected output: 52
    }

    public static int solution(int left, int right) {
        int sum = 0; // 결과값을 저장할 변수 # Variable to store the result sum
        for (int num = left; num <= right; num++) { // left부터 right까지 모든 수에 대해 반복 # Loop through all numbers from left to right
            int divisorCount = 0; // 현재 수의 약수 개수를 셀 변수 # Variable to count divisors of current number
            int sqrt = (int) Math.sqrt(num); // 현재 수의 제곱근 계산 # Calculate square root of current number

            for (int i = 1; i <= sqrt; i++) { // 1부터 제곱근까지 반복 # Loop from 1 to sqrt(num)
                if (num % i == 0) { // i가 num의 약수이면 # If i divides num evenly
                    if (i == sqrt) { // 완전제곱수인 경우 약수가 한 개임 # If perfect square, count only one divisor
                        divisorCount += 1; // 약수 한 개 추가 # Add one divisor
                    } else {
                        divisorCount += 2; // 쌍으로 약수 두 개 추가 (i와 num/i) # Add two divisors (i and num/i)
                    }
                }
            }

            if (divisorCount % 2 == 0) { // 약수 개수가 짝수이면 # If the number of divisors is even
                sum += num; // 해당 수를 더함 # Add the number to sum
            } else { // 약수 개수가 홀수이면 # If the number of divisors is odd
                sum -= num; // 해당 수를 뺌 # Subtract the number from sum
            }
        }
        return sum; // 최종 결과 반환 # Return the final sum
    }
}