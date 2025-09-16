// 정수 n이 주어질 때, n을 문자열로 변환하여 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 10000

public class Ex106_intToStr {
    public static void main(String[] args) {
        System.out.println(solution1(123));
        System.out.println(solution1(2573));
        System.out.println(solution2(123));
        System.out.println(solution2(2573));
    }

    public static String solution1(int n) {
        return String.valueOf(n);
    }

    public static String solution2(int n) {
        return Integer.toString(n);
    }
}
