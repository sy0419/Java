// 한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 3 ≤ num_str ≤ 100

public class Ex102_sumDigits {
    public static void main(String[] args) {
        System.out.println(solution("123456789")); // 테스트 케이스 1 출력 # Output for test case 1
        System.out.println(solution("1000000"));   // 테스트 케이스 2 출력 # Output for test case 2
    }

    public static int solution(String numStr) {
        int sum = 0; // 각 자리 숫자의 합을 저장할 변수 초기화 # Initialize variable to store digit sum

        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i); // 문자열에서 i번째 문자를 추출 # Get the i-th character from the string
            int digit = ch - '0';        // 문자형 숫자를 정수형 숫자로 변환 # Convert character digit to integer using ASCII subtraction
            sum += digit;                // 변환한 숫자를 합계에 더함 # Add digit to the running total
        }

        return sum; // 최종 합계 반환 # Return the final sum
    }
}