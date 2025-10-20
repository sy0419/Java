// 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// n은 1 이상 100,000,000 이하인 자연수입니다.

public class Ex034_reverseTernary {
    public static void main(String[] args) {
        System.out.println(solution(45));   // 7 출력 # Should print 7
        System.out.println(solution(125));  // 229 출력 # Should print 229
    }

    public static int solution(int n) {
        String strN = Integer.toString(n, 3);                  // 10진수를 3진법 문자열로 변환 # Convert decimal to ternary string
        String reversedStr = new StringBuilder(strN).reverse().toString(); // 3진법 문자열을 뒤집음 # Reverse the ternary string
        int result = Integer.parseInt(reversedStr, 3);         // 뒤집은 3진법을 다시 10진수로 변환 # Convert reversed ternary back to decimal
        return result;                                         // 결과 반환 # Return the final result
    }
}