// 숫자의 표현

// Finn은 요즘 수학공부에 빠져 있습니다. 
// 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 
// 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
// 1 + 2 + 3 + 4 + 5 = 15
// 4 + 5 + 6 = 15
// 7 + 8 = 15
// 15 = 15

// 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

// 제한사항
// n은 10,000 이하의 자연수 입니다.

// 입출력 예
//  n	result
//  15	  4

public class Ex006_ConsecutiveNumberSum {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {

        // 연속합 표현 개수 저장 변수 # Variable to store number of valid cases
        int result = 0;

        // 시작 숫자 설정 # Set starting number
        for (int i = 1; i <= n; i++) {

            // 현재 시작점의 누적합 # Accumulated sum for current start point
            int sum = 0;

            // i부터 연속해서 더하기 # Add consecutive numbers starting from i
            for (int j = i; j <= n; j++) {

                sum += j;

                // 누적합이 n과 같으면 경우의 수 증가 # Increase count if sum equals n
                if (sum == n) {
                    result++;
                    break;
                }

                // 누적합이 n보다 커지면 종료 # Stop if sum exceeds n
                if (sum > n) {
                    break;
                }
            }
        }

        // 최종 경우의 수 반환 # Return total number of cases
        return result;
    }
}