// 피보나치 수

// 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

// 예를들어
// F(2) = F(0) + F(1) = 0 + 1 = 1
// F(3) = F(1) + F(2) = 1 + 1 = 2
// F(4) = F(2) + F(3) = 1 + 2 = 3
// F(5) = F(3) + F(4) = 2 + 3 = 5
// 와 같이 이어집니다.

// 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

// 제한 사항
// n은 2 이상 100,000 이하인 자연수입니다.

// 입출력 예
// n	return
// 3	  2
// 5	  5 

// 입출력 예 설명
// 피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.

public class Ex008_FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static int solution(int n) {

        // 피보나치 수를 저장할 배열 생성 # Create array to store Fibonacci numbers
        int[] fb = new int[n+1];

        // 피보나치 초기값 설정 # Set initial Fibonacci values
        fb[0] = 0;
        fb[1] = 1;

        // 2번째 피보나치 수부터 계산 # Calculate Fibonacci numbers starting from index 2
        for (int i = 2; i <= n; i++) {

            // 이전 두 값을 더하여 현재 피보나치 값 저장
            // Store current Fibonacci value using previous two values
            fb[i] = fb[i-1] + fb[i-2];
        }

        // n번째 피보나치 수를 1234567로 나눈 나머지 반환
        // Return Fibonacci number modulo 1234567
        return fb[n] % 1234567;
    }
}