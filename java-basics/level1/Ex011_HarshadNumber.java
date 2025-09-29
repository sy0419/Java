// 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
// 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
// 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

// 제한 조건
// x는 1 이상, 10000 이하인 정수입니다.

public class Ex011_HarshadNumber {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Running sample test cases
        System.out.println(solution(10)); // true 기대값 # Expected: true
        System.out.println(solution(12)); // true 기대값 # Expected: true
        System.out.println(solution(11)); // false 기대값 # Expected: false
        System.out.println(solution(13)); // false 기대값 # Expected: false
    }

    public static boolean solution(int x) {
        String strX = Integer.toString(x); // 정수를 문자열로 변환 # Convert integer to string
        int digitSum = 0; // 자릿수 합을 저장할 변수 # Variable to store the sum of digits

        for (int i = 0; i < strX.length(); i++) {
            int digit = strX.charAt(i) - '0'; // 문자형 숫자를 정수형 숫자로 변환 # Convert char digit to int
            digitSum += digit; // 자릿수 누적합 계산 # Add digit to total sum
        }

        return x % digitSum == 0; // 하샤드 수 판별 # Check if x is divisible by the digit sum
    }
}