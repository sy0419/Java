// 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.  
// 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
// # Given a natural number N, return the sum of its digits (e.g., N = 123 → 1+2+3 = 6)

// 제한사항
// N의 범위 : 100,000,000 이하의 자연수
// # Constraints: N is a natural number less than or equal to 100,000,000

public class Ex001_digitSum {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(solution(123)); // 6
        System.out.println(solution(987)); // 24
        System.out.println(solution2(123)); // 6
        System.out.println(solution2(987)); // 24
    }

    // 방법 1: 문자열로 변환하여 각 자릿수 합산 # Method 1: Convert to string and sum digits
    public static int solution(int n) {
        int result = 0;
        String str = Integer.toString(n); // 숫자를 문자열로 변환 # Convert number to string
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) - '0'; // 문자를 숫자로 변환하여 더함 # Convert char to digit and add
        }
        return result; // 결과 반환 # Return the result
    }

    // 방법 2: 나눗셈과 나머지 연산으로 자릿수 추출하여 합산 # Method 2: Use modulo and division to extract and sum digits
    public static int solution2(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  // 마지막 자릿수 더함 # Add the last digit
            n /= 10;        // 마지막 자릿수 제거 # Remove the last digit
        }
        return sum; // 결과 반환 # Return the result
    }
}