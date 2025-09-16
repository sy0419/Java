// 1부터 6까지 숫자가 적힌 주사위가 두 개 있습니다. 두 주사위를 굴렸을 때 나온 주사위 숫자를 각각 a, b라고 했을 때 얻는 점수는 다음과 같습니다.
// a와 b가 모두 홀수라면 a2 + b2 점을 얻습니다.
// a와 b 중 하나만 홀수라면 2 × (a + b) 점을 얻습니다.
// a와 b 모두 홀수가 아니라면 |a - b| 점을 얻습니다.
// 두 정수 a와 b가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// a와 b는 1 이상 6 이하의 정수입니다.

public class Ex111_diceGame1 {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));  // 34
        System.out.println(solution(6, 1));  // 14
        System.out.println(solution(2, 4));  // 2
    }

    public static int solution(int a, int b) {
        int result = 0;  // 결과 점수를 저장할 변수 # Variable to store final score

        if (a % 2 == 1 && b % 2 == 1) {  // a와 b 모두 홀수인 경우 # If both are odd
            int a2 = (int) Math.pow(a, 2);  // a의 제곱 # Square of a
            int b2 = (int) Math.pow(b, 2);  // b의 제곱 # Square of b
            result += a2 + b2;  // 점수 계산 # Score is a² + b²
        } else if (a % 2 == 0 && b % 2 == 0) {  // a와 b 모두 짝수인 경우 # If both are even
            result += Math.abs(a - b);  // 점수는 두 수의 차이의 절댓값 # Score is |a - b|
        } else {  // 하나만 홀수인 경우 # If only one is odd
            result += 2 * (a + b);  // 점수는 두 수의 합에 2를 곱한 값 # Score is 2 * (a + b)
        }

        return result;  // 최종 점수 반환 # Return final score
    }
}