// 두 정수 q, r과 문자열 code가 주어질 때, code의 각 인덱스를 q로 나누었을 때 
// 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 0 ≤ r < q ≤ 20
// r < code의 길이 ≤ 1,000
// code는 영소문자로만 이루어져 있습니다.

public class Ex049_qrCode {
    public static void main(String[] args) {
        System.out.println(solution1(3, 1, "qjnwezgrpirldywt"));
        System.out.println(solution1(1, 0, "programmers"));
        System.out.println(solution2(3, 1, "qjnwezgrpirldywt"));
        System.out.println(solution2(1, 0, "programmers"));
    }

    public static String solution1(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                sb.append(code.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String solution2(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = r; i < code.length(); i += q)
            sb.append(code.charAt(i));
        return sb.toString();
    }
}
