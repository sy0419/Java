

// 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 
// 칸이 총 4개 있을 때, 효진이는
// (1칸, 1칸, 1칸, 1칸)
// (1칸, 2칸, 1칸)
// (1칸, 1칸, 2칸)
// (2칸, 1칸, 1칸)
// (2칸, 2칸)
// 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 
// 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
// 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 
// 예를 들어 4가 입력된다면, 5를 return하면 됩니다.

// 제한 사항
// n은 1 이상, 2000 이하인 정수입니다.

// 입출력 예
// n	result
// 4	  5
// 3	  3

// 입출력 예 설명
// 입출력 예 #1
// 위에서 설명한 내용과 같습니다.

// 입출력 예 #2
// (2칸, 1칸)
// (1칸, 2칸)
// (1칸, 1칸, 1칸)
// 총 3가지 방법으로 멀리 뛸 수 있습니다.

public class Ex016_LongJump {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }

    public static int solution(int n) {

        // n이 1이면 방법 1개 반환 # Return 1 if n is 1
        if (n == 1) {
            return 1;
        }

        // n이 2이면 방법 2개 반환 # Return 2 if n is 2
        if (n == 2) {
            return 2;
        }

        // DP 배열 생성 # Create DP array
        int[] dp = new int[n + 1];

        // 초기값 설정 # Set base cases
        dp[1] = 1;
        dp[2] = 2;

        // 3부터 n까지 경우의 수 계산 # Calculate number of ways from 3 to n
        for (int i = 3; i <= n; i++) {

            // 이전 두 경우의 수를 더하고 나머지 연산 적용 # Add previous two cases and apply modulo
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        // n칸 도달 방법 수 반환 # Return number of ways to reach n
        return dp[n];
    }
}