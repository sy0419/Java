// 문자열들이 담긴 리스트가 주어졌을 때, 모든 문자열들을 순서대로 합친 문자열을 꼬리 문자열이라고 합니다.
// 꼬리 문자열을 만들 때 특정 문자열을 포함한 문자열은 제외시키려고 합니다. 
// 예를 들어 문자열 리스트 ["abc", "def", "ghi"]가 있고 문자열 "ef"를 포함한 문자열은 제외하고 꼬리 문자열을 만들면 "abcghi"가 됩니다.
// 문자열 리스트 str_list와 제외하려는 문자열 ex가 주어질 때, str_list에서 ex를 포함한 문자열을 제외하고 만든 
// 꼬리 문자열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ str_list의 길이 ≤ 10
// 1 ≤ str_list의 원소의 길이 ≤ 10
// 1 ≤ ex의 길이 ≤ 5

public class Ex109_tailString {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"abc", "def", "ghi"}, "ef"));   // 출력: abcghi # Output: abcghi
        System.out.println(solution(new String[] {"abc", "bbc", "cbc"}, "c"));    // 출력:  # Output: (빈 문자열)
    }

    public static String solution(String[] strList, String ex) {
        String result = "";  // 결과 문자열 초기화 # Initialize result string

        for (String str : strList) {
            if (!str.contains(ex)) {  // ex가 포함되어 있지 않은 문자열만 추가 # Add strings that do not contain ex
                result += str;  // 문자열 이어붙이기 # Concatenate string to result
            }
        }

        return result;  // 완성된 꼬리 문자열 반환 # Return concatenated tail string
    }
}