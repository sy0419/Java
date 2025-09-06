// 문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다.
// myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중 pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.

// 제한사항
// 1 ≤ myString의 길이 ≤ 100
// 1 ≤ pat의 길이 ≤ 10
// myString과 pat는 문자 "A"와 "B"로만 이루어진 문자열입니다.

public class Ex087_switchStrings {
    public static void main(String[] args) {
        // 테스트 케이스 출력  # Print test case results
        System.out.println(solution("ABBAA", "AABB")); // 기대값: 1
        System.out.println(solution("ABAB", "ABAB"));  // 기대값: 0
    }

    public static int solution(String myString, String pat) {
        // 1단계: A를 임시문자 X로 치환  # Step 1: Replace A with temporary character X
        String step1 = myString.replace("A", "X");

        // 2단계: B를 A로 치환  # Step 2: Replace B with A
        String step2 = step1.replace("B", "A");

        // 3단계: 임시문자 X를 B로 치환 → A와 B가 서로 바뀐 결과  # Step 3: Replace X with B → final converted string
        String converted = step2.replace("X", "B");

        // pat이 포함되어 있는지 확인 후 1 또는 0 반환  # Check if 'pat' is in converted string
        if (converted.contains(pat)) {
            return 1;
        }
        return 0;
    }
}