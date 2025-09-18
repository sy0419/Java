// 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
// 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

// 제한사항
// N의 범위 : 100,000,000 이하의 자연수

public class Ex001_digitSum {
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(987));
        System.out.println(solution2(123));
        System.out.println(solution2(987));
    }

    public static int solution(int N) {
        int result = 0;
        String str = Integer.toString(N);
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) - '0';
        }
        return result;
    }

    public static int solution2(int N) {
        int sum = 0;
        while (N > 0) {
            sum += N % 10;  // 마지막 자리 더하기
            N /= 10;        // 마지막 자리 제거
        }
        return sum;
    }
}