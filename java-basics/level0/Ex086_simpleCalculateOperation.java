// 문자열 binomial이 매개변수로 주어집니다. 
// binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수, op는 '+', '-', '*' 중 하나입니다. 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 0 ≤ a, b ≤ 40,000
// 0을 제외하고 a, b는 0으로 시작하지 않습니다.

public class Ex086_simpleCalculateOperation {
    public static void main(String[] args) {
        // 결과 출력  # Print calculation results
        System.out.println(solution("43 + 12"));
        System.out.println(solution("0 - 7777"));
        System.out.println(solution("40000 * 40000"));
    }

    public static int solution(String binomial) {
        String[] parts = binomial.split(" "); // 문자열을 공백 기준으로 분리  # Split the string by space

        int a = Integer.parseInt(parts[0]); // 첫 번째 피연산자 변환  # Convert first operand to int
        int b = Integer.parseInt(parts[2]); // 두 번째 피연산자 변환  # Convert second operand to int
        String op = parts[1];               // 연산자 추출  # Extract operator

        int result;
        // 연산자에 따라 연산 수행  # Perform operation based on the operator
        result = switch (op) {
            case "+" -> a + b;  // 덧셈  # Addition
            case "-" -> a - b;  // 뺄셈  # Subtraction
            default -> a * b;   // 곱셈  # Multiplication (default case)
        };

        return result; // 계산 결과 반환  # Return the result
    }
}