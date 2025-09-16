// 0 이상의 두 정수가 문자열 a, b로 주어질 때, a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ a의 길이 ≤ 100,000
// 1 ≤ b의 길이 ≤ 100,000
// a와 b는 숫자로만 이루어져 있습니다.
// a와 b는 정수 0이 아니라면 0으로 시작하지 않습니다.

import java.math.BigInteger;

public class Ex105_intAdd {
    public static void main(String[] args) {
        System.out.println(solution("582", "734"));                          // 출력: 1316 # Output: 1316
        System.out.println(solution("18446744073709551615", "287346502836570928366")); // 출력: 305793246910280479981 # Output: 305793246910280479981
        System.out.println(solution("0", "0"));                              // 출력: 0 # Output: 0
    }

    public static String solution(String a, String b) {
        BigInteger bigA = new BigInteger(a);         // 문자열 a를 BigInteger로 변환 # Convert string a to BigInteger
        BigInteger bigB = new BigInteger(b);         // 문자열 b를 BigInteger로 변환 # Convert string b to BigInteger
        BigInteger sum = bigA.add(bigB);             // 두 BigInteger를 더함 # Add the two BigInteger numbers

        return sum.toString();                       // 결과를 문자열로 변환해 반환 # Convert result to string and return
    }
}