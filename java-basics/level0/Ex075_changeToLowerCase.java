// 알파벳으로 이루어진 문자열 myString이 주어집니다. 모든 알파벳을 소문자로 변환하여 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ myString의 길이 ≤ 100,000
// myString은 알파벳으로 이루어진 문자열입니다.

public class Ex075_changeToLowerCase {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // # Print test case results
        System.out.println(solution("aBcDeFg")); // 기대 결과: abcdefg
        System.out.println(solution("AAA"));     // 기대 결과: aaa
    }

    public static String solution(String myString) {
        // 문자열을 소문자로 변환하여 반환
        // # Convert the input string to lowercase and return it
        return myString.toLowerCase();
    }
}