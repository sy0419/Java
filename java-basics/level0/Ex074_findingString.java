// 알파벳으로 이루어진 문자열 myString과 pat이 주어집니다.
// myString의 연속된 부분 문자열 중 pat이 존재하면 1을 그렇지 않으면 0을 return 하는 solution 함수를 완성해 주세요.
// 단, 알파벳 대문자와 소문자는 구분하지 않습니다.

// 제한사항
// 1 ≤ myString의 길이 ≤ 100,000
// 1 ≤ pat의 길이 ≤ 300
// myString과 pat은 모두 알파벳으로 이루어진 문자열입니다.

public class Ex074_findingString {
    public static void main(String[] args) {
        // 예시 테스트 출력
        // # Test case output
        System.out.println(solution("AbCdEfG", "aBc"));
        System.out.println(solution("aaAA", "aaaaa"));  
    }

    public static int solution(String myString, String pat) {
        // myString을 소문자로 변환
        // # Convert myString to lowercase for case-insensitive comparison
        String lowerCaseMyString = myString.toLowerCase();

        // pat을 소문자로 변환
        // # Convert pat to lowercase for case-insensitive comparison
        String lowerCasePat = pat.toLowerCase();
        
        // 변환된 문자열에서 pat이 포함되어 있는지 확인
        // # Check if lowerCaseMyString contains lowerCasePat
        if (lowerCaseMyString.contains(lowerCasePat)) {
            return 1; // 포함되면 1 반환
                      // # Return 1 if the pattern exists in the string
        }

        return 0; // 포함되지 않으면 0 반환
                  // # Return 0 if the pattern does not exist in the string
    }
}