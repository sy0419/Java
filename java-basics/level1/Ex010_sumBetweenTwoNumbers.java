// 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
// 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

// 제한 조건
// a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
// a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
// a와 b의 대소관계는 정해져있지 않습니다.

public class Ex010_sumBetweenTwoNumbers {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));  
        System.out.println(solution(3, 3));  
        System.out.println(solution(5, 3));  
    }

    public static long solution(int a, int b) {
        // a와 b의 대소 관계에 따라 작은 값(min)과 큰 값(max) 결정 # Determine min and max from a and b
        int min;
        int max;
        if (a > b) {
            max = a;
            min = b;
        } else {
            min = a;
            max = b;
        }

        // 작은 값(min)부터 큰 값(max)까지 합산 # Add numbers from min to max, inclusive
        long result = 0;
        for (int i = min; i <= max; i++) {
            result += i;  // result는 long 타입, i는 int 타입이므로 자동으로 i가 long으로 형변환됨 # Automatic type conversion: i (int) is implicitly converted to long
        }

        // 계산된 합을 리턴 # Return the calculated sum
        return result;
    }
}