// 문자열 배열 strArr가 주어집니다.
// 모든 원소가 알파벳으로만 이루어져 있을 때, 배열에서 홀수번째 인덱스의 문자열은 모든 문자를 대문자로,
// 짝수번째 인덱스의 문자열은 모든 문자를 소문자로 바꿔서 반환하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ strArr ≤ 20
// 1 ≤ strArr의 원소의 길이 ≤ 20
// strArr의 원소는 알파벳으로 이루어진 문자열 입니다.

import java.util.Arrays;

public class Ex076_changeArrayUpperCaseLowerCase {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // # Print test case results
        System.out.println(Arrays.toString(solution(new String[] {"AAA","BBB","CCC","DDD"})));
        System.out.println(Arrays.toString(solution(new String[] {"aBc","AbC"})));
    }

    public static String[] solution(String[] strArr) {
        // 배열의 모든 요소를 인덱스에 따라 대소문자 변환
        // # Iterate over the array and convert each element based on its index
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 1) {
                // 홀수 인덱스는 대문자로 변환
                // # Convert to uppercase if index is odd
                strArr[i] = strArr[i].toUpperCase();
            } else {
                // 짝수 인덱스는 소문자로 변환
                // # Convert to lowercase if index is even
                strArr[i] = strArr[i].toLowerCase();
            }
        }
        return strArr; // 변환된 배열 반환
                       // # Return the modified array
    }
}