public class Ex049_qrCode {
    public static void main(String[] args) {
        // 테스트 케이스 실행
        // Run test cases
        System.out.println(solution1(3, 1, "qjnwezgrpirldywt"));  // 결과: jegryt
        System.out.println(solution1(1, 0, "programmers"));       // 결과: programmers
        System.out.println(solution2(3, 1, "qjnwezgrpirldywt"));  // 결과: jegryt
        System.out.println(solution2(1, 0, "programmers"));       // 결과: programmers
    }

    // 첫 번째 방식: 전체 인덱스를 순회하며 나머지 비교
    // First approach: iterate through all indices and compare remainder
    public static String solution1(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();  // 결과 문자열을 저장할 StringBuilder 생성
                                                 // Create StringBuilder to store the result

        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {                    // 인덱스를 q로 나눈 나머지가 r이면
                                                 // If index % q equals r
                sb.append(code.charAt(i));       // 해당 문자 추가
                                                 // Append the character at index i
            }
        }
        return sb.toString();                    // 최종 문자열 반환
                                                 // Return the final string
    }

    // 두 번째 방식: r부터 q씩 건너뛰며 순회
    // Second approach: iterate from r with steps of q
    public static String solution2(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();  // 결과 문자열을 저장할 StringBuilder 생성
                                                 // Create StringBuilder to store the result

        for (int i = r; i < code.length(); i += q) {
            sb.append(code.charAt(i));           // 해당 인덱스 문자 추가
                                                 // Append character at index i
        }
        return sb.toString();                    // 최종 문자열 반환
                                                 // Return the final string
    }
}