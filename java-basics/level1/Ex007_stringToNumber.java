// 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
// 제한 조건:
// s의 길이는 1 이상 5이하입니다.
// s의 맨앞에는 부호(+, -)가 올 수 있습니다.
// s는 부호와 숫자로만 이루어져있습니다.
// s는 "0"으로 시작하지 않습니다.

public class Ex007_stringToNumber {
    public static void main(String[] args) { // main 메소드에서 테스트 케이스 실행 # Running the function with sample test cases
        System.out.println(solution("1234")); // 입력값 "1234"에 대해 실행 # Running the function with input "1234"
        System.out.println(solution("-1234")); // 입력값 "-1234"에 대해 실행 # Running the function with input "-1234"
    }

    public static int solution(String s) { // 문자열 s를 숫자로 변환하는 메소드 # A method to convert string s to an integer
        int result = Integer.parseInt(s); // Integer.parseInt()를 사용하여 문자열을 숫자로 변환 # Using Integer.parseInt() to convert the string to an integer
        return result; // 변환된 숫자를 반환 # Return the converted integer
    }
}