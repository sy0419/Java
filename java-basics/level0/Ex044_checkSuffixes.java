import java.util.HashSet;

// 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 
// 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
// 문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 100
// 1 ≤ is_suffix의 길이 ≤ 100
// my_string과 is_suffix는 영소문자로만 이루어져 있습니다.

public class Ex044_checkSuffixes {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // Print results of test cases
        System.out.println(solution1("banana", "ana"));   // 1
        System.out.println(solution1("banana", "wxyz"));  // 0
        System.out.println(solution2("banana", "ana"));  // 1
        System.out.println(solution2("banana", "wxyz")); // 0
    }

    // 방법 1: HashSet을 사용해 모든 접미사 저장 후 비교
    // Method 1: Store all suffixes using HashSet and check for match
    public static int solution1(String myString, String isSuffix) {
        HashSet<String> suffixes = new HashSet<>();  // 접미사 저장용 HashSet
        for (int i = 0; i < myString.length(); i++) {
            String suffix = myString.substring(i);   // i번째부터 끝까지 문자열 자르기 (접미사)
            suffixes.add(suffix);                    // HashSet에 추가
        }

        // isSuffix가 접미사 목록에 포함되어 있다면 1 반환
        // Return 1 if isSuffix is in the set of suffixes
        if (suffixes.contains(isSuffix)) {
            return 1;
        }
        return 0;
    }

    // 방법 2: String 클래스의 endsWith() 메서드 사용
    // Method 2: Use String's built-in endsWith() method
    public static int solution2(String myString, String isSuffix) {
        // 문자열이 해당 접미사로 끝나는지 확인
        // Check if the string ends with the given suffix
        if (myString.endsWith(isSuffix)) {
            return 1;
        }
        return 0;
    }
}
