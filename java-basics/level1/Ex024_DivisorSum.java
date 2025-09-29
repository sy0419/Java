// 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ left ≤ right ≤ 1,000

public class Ex024_DivisorSum {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int sum = 0;
        for (int num = left; num <= right; num++) {
            int divisorCount = 0;
            int sqrt = (int) Math.sqrt(num); // 제곱근 미리 계산

            for (int i = 1; i <= sqrt; i++) { // <= 로 수정
                if (num % i == 0) {
                    if (i == sqrt) {
                        divisorCount += 1; // 완전제곱수일 때 약수 한 개만 추가
                    } else {
                        divisorCount += 2; // 쌍으로 약수 두 개 추가
                    }
                }
            }

            if (divisorCount % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        return sum;
    }
}