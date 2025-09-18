// 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

// 제한 조건
// num은 int 범위의 정수입니다.
// 0은 짝수입니다.

public class Ex003_evenOdd {
    public static void main(String[] args) {
        System.out.println(solution(3));  // 테스트: 홀수 입력 # Test: input is odd
        System.out.println(solution(4));  // 테스트: 짝수 입력 # Test: input is even
    }

    public static String solution(int num) {
        String result = "";  // 반환할 문자열 변수 초기화 # Initialize result string

        // 홀수이면 "Odd"를 추가 # If number is odd, append "Odd"
        if (num % 2 != 0) {
            result += "Odd";
        } else {
            result += "Even";  // 그 외의 경우(짝수)이면 "Even" 추가 # Otherwise (even), append "Even"
        }

        return result;  // 결과 반환 # Return result
    }
}